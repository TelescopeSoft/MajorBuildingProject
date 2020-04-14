package com.qlmsoft.mbp.modules.crawler.service;

import com.alibaba.fastjson.JSON;
import com.qlmsoft.mbp.common.utils.DateUtils;
import com.qlmsoft.mbp.modules.project.bean.ExpropriationBean;
import com.qlmsoft.mbp.modules.project.bean.ExpropriationData;
import com.qlmsoft.mbp.modules.project.entity.Expropriation;
import com.qlmsoft.mbp.modules.project.entity.ExpropriationDetail;
import com.qlmsoft.mbp.modules.project.entity.ExpropriationDetailInfo;
import com.qlmsoft.mbp.modules.project.service.ExpropriationDetailService;
import com.qlmsoft.mbp.modules.project.service.ExpropriationService;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aaronhuang on 2018/7/24.
 */
@Service
public class ExpropriationCrawler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

//    public static final String QUERY_URL = "http://z.jsmlr.gov.cn/jstdgk/xxgkController/queryXxgkList4Page.do";
    public static final String QUERY_URL = "http://zrzy.jiangsu.gov.cn/zd/xxgkController/queryXxgkList4Page.do";

//    public static final String QUERY_DETAIL_URL = "http://z.jsmlr.gov.cn/jstdgk/xxgkController/turnToDetail.do?lcid={0}&unitCode=320211";
    public static final String QUERY_DETAIL_URL = "http://zrzy.jiangsu.gov.cn/zd/xxgkController/turnToMoreDetail.do?lcid={0}&unitCode=320211&flag=4";

    @Autowired
    ExpropriationService service;

    @Autowired
    ExpropriationDetailService detailService;

    public CloseableHttpClient closeHttpClient = null; // HttpClients.createDefault();

    public boolean synchAll() {

        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
        CloseableHttpClient closeHttpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();

        boolean result = true;
        CloseableHttpResponse httpResponse = null;
        HttpPost httpPost = new HttpPost(QUERY_URL);

        // 设置Post参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("xzqhdm", "320211"));
        params.add(new BasicNameValuePair("keyWord", "1"));
        params.add(new BasicNameValuePair("pageIndex", "1"));
        params.add(new BasicNameValuePair("pageSize", "200"));

        httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        Set<String> lcids = new HashSet<String>();

        try {

            httpResponse = closeHttpClient.execute(httpPost);
            String html = EntityUtils.toString(httpResponse.getEntity(),
                    "UTF-8");

            if (html != null) {

                ExpropriationData data = JSON.parseObject(html, ExpropriationData.class);

                if(data != null && "0".equals(data.getCode())
                        && data.getData() != null && data.getData().getRows() != null){
                    for(ExpropriationBean bean : data.getData().getRows()  ){
                        lcids.add(bean.getLcid());
                        Expropriation ex = transferToEntity(bean);
                        service.checkDuplicatedAndSave(ex);

                    }
                }

                for(String lcid: lcids){
                    ExpropriationDetail d = getDetail(lcid);
                    Thread.sleep(30*1000L);
                    detailService.checkDuplicatedAndSave(d);

                }

            }
        } catch (IOException e) {
            result = false;
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;

    }


        public ExpropriationDetail getDetail(String lcid)  {
        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
        CloseableHttpClient closeHttpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();

        logger.debug("getDetail : " + lcid);
        ExpropriationDetail result = new ExpropriationDetail();
        result.setLcid(lcid);
        CloseableHttpResponse httpResponse = null;
        String url = QUERY_DETAIL_URL.replace("{0}",lcid);
        logger.debug("url : " + url);
        HttpGet httpReq = new HttpGet(url);

        try {

            httpResponse = closeHttpClient.execute(httpReq);
            String html = EntityUtils.toString(httpResponse.getEntity(),
                    "UTF-8");
            if (html != null) {
                Document doc = Jsoup.parse(html);
                abstractData(result, doc);
            }

        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch (ParseException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;
    }

    /**
     * 提取数据方法
     * @param data
     * @param doc
     * @throws ParseException
     */
    private void abstractData(ExpropriationDetail data, Document doc)
            throws ParseException {
        Elements tables = doc.select("body table");
        int currentSize = 0;

        //征地信息
        Elements expropriationInfoTrs = tables.get(0).select("tr");
        data.setPrjName(expropriationInfoTrs.get(0).select("td").get(1).html());
        String approveDate = expropriationInfoTrs.get(1).select("td").get(1).html();
        data.setApproveDate(DateUtils.parseDate(approveDate,"yyyy-MM-dd"));
        data.setApproveNum(expropriationInfoTrs.get(2).select("td").get(1).html());
        data.setAddress(expropriationInfoTrs.get(3).select("td").get(1).html());

        //批前
        Elements beforeApproveTrs = tables.get(2).select("tr");
        abstractExpropriationInfo(data, beforeApproveTrs ,ExpropriationDetailInfo.BEFORE_APPROVE);

        //批中
        Elements inApproveTrs = tables.get(4).select("tr");
        abstractExpropriationInfo(data, inApproveTrs ,ExpropriationDetailInfo.IN_APPROVE);

        //批后
        Elements afterApproveTrs = tables.get(6).select("tr");
        abstractExpropriationInfo(data, afterApproveTrs ,ExpropriationDetailInfo.AFTER_APPROVE);

    }

    private void abstractExpropriationInfo(ExpropriationDetail data, Elements beforeApproveTrs,String infoType) {
        for(Element tr : beforeApproveTrs){
            if(!tr.hasClass("titbg")){
                Elements tds = tr.select("td");
                if(tds.size() < 6 || "暂无相关信息".equals(tds.get(0).html())){
                    continue;
                }
                ExpropriationDetailInfo info = new ExpropriationDetailInfo();
                info.setLcid(data.getLcid());
                info.setInfoType(infoType);
                try{
                    info.setSort(Integer.parseInt(tds.get(0).html()));
                }catch (Exception e){
                    logger.error(e.getMessage());
                    e.printStackTrace();
                }
                info.setContent(tds.get(1).html());
                //info.setInfoType(tds.get(1).html());
                info.setTitle(tds.get(2).html());
                info.setPublicUnit(tds.get(3).html());

                try{
                    info.setPublicDate(DateUtils.parseDate(tds.get(4).html(), YYYY_MM_DD));
                }catch (Exception e){
                    logger.error(e.getMessage());
                    e.printStackTrace();
                }

                String viewJs = tds.get(5).selectFirst("a").attr("onclick");
                // TODO: 2018/7/25 添加文件链接
                info.setFileUrl(viewJs);
                //info.setFileUrl(RegUtils.abstractStringByPattern(viewJs, RegUtils.EXPROPRIATION_INFO_VIEW_PATTERN));


                data.getExpropriationDetailInfoList().add(info);

            }
        }
    }

    private Expropriation transferToEntity(ExpropriationBean bean) {
        Expropriation result = new Expropriation();
        if(bean != null){
            result.setPrjName(bean.getXmmc());
            result.setApproveNum(bean.getPfwh());
            result.setAddress(bean.getXmwzmc());
            result.setTown(bean.getGgssz());
            result.setVillage(bean.getGgssc());
            result.setLcid(bean.getLcid());
            try {
                result.setApproveDate(DateUtils.parseDate(bean.getPzsj(),"yyyy-MM-dd"));
            } catch (ParseException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return result;
    }



}
