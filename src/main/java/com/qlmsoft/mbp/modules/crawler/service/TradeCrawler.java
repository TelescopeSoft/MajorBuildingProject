package com.qlmsoft.mbp.modules.crawler.service;

import com.alibaba.fastjson.JSON;
import com.qlmsoft.mbp.common.utils.DateUtils;
import com.qlmsoft.mbp.common.utils.StringUtils;
import com.qlmsoft.mbp.modules.project.bean.TradeInfoBean;
import com.qlmsoft.mbp.modules.project.bean.TradeTableBean;
import com.qlmsoft.mbp.modules.project.entity.PubTradeContent;
import com.qlmsoft.mbp.modules.project.entity.Trade;
import com.qlmsoft.mbp.modules.project.service.PubTradeContentService;
import com.qlmsoft.mbp.modules.project.service.TradeService;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by aaronhuang on 2018/7/31.
 */
@Service
public class TradeCrawler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DOMAIN = "http://www.wxbh.gov.cn/";
    public static final String QUERY_URL = DOMAIN + "/intertidwebapp/govChanInfo/getBhDocuments";

    @Autowired
    TradeService service;
    @Autowired
    PubTradeContentService contentService;

    public CloseableHttpClient closeHttpClient = null;//HttpClients.createDefault();

    public boolean synchAll() {

        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
//        CloseableHttpClient closeHttpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();
        HttpClientBuilder builder = HttpClients.custom();
        builder.setUserAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
        closeHttpClient = builder.build();

        boolean result = true;
        CloseableHttpResponse httpResponse = null;
        HttpPost httpPost = new HttpPost(QUERY_URL);

        // 设置Post参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("pageIndex", "1"));
        params.add(new BasicNameValuePair("pageSize", "20"));
        params.add(new BasicNameValuePair("siteId", "174"));
        params.add(new BasicNameValuePair("ChannelType", "2"));
        params.add(new BasicNameValuePair("KeyWord", ""));
        params.add(new BasicNameValuePair("KeyWordType", ""));
        params.add(new BasicNameValuePair("chanId", "34130"));
        params.add(new BasicNameValuePair("order", "writetime"));

        httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));

        try {

            httpResponse = closeHttpClient.execute(httpPost);
            String html = EntityUtils.toString(httpResponse.getEntity(),
                    "UTF-8");

            if (html != null) {
                TradeTableBean data = JSON.parseObject(html, TradeTableBean.class);
                logger.info("----data: " + data.toString());

                //处理单页数据
                resolveSinglePageData(data);

                //处理分页数据
                if(data.getPageCount() > 1){
                    for(int i = data.getPageIndex() + 1; i <= data.getPageCount() ;i++){
                        Thread.sleep(30*1000l);
                        getPagedData(i);
                    }
                }
            }
        } catch (IOException e) {
            result = false;
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
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

    public void getPagedData(int page) {

//        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
//        CloseableHttpClient closeHttpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();
//        HttpClientBuilder builder = HttpClients.custom();
//        builder.setUserAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
//        closeHttpClient = builder.build();

        boolean result = true;
        CloseableHttpResponse httpResponse = null;
        HttpPost httpPost = new HttpPost(QUERY_URL);

        // 设置Post参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("pageIndex", Integer.toString(page)));
        params.add(new BasicNameValuePair("pageSize", "20"));
        params.add(new BasicNameValuePair("siteId", "174"));
        params.add(new BasicNameValuePair("ChannelType", "2"));
        params.add(new BasicNameValuePair("KeyWord", ""));
        params.add(new BasicNameValuePair("KeyWordType", ""));
        params.add(new BasicNameValuePair("chanId", "34130"));
        params.add(new BasicNameValuePair("order", "writetime"));

        httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));

        try {

            httpResponse = closeHttpClient.execute(httpPost);
            String html = EntityUtils.toString(httpResponse.getEntity(),
                    "UTF-8");

            if (html != null) {
                TradeTableBean data = JSON.parseObject(html, TradeTableBean.class);
                logger.info("----paged data: "  + page + data.toString());

                //处理分页中的单页数据
                resolveSinglePageData(data);
            }
        } catch (IOException e) {
            result = false;
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
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
    }

    public void getContentPageData(Trade trade) {
        if(trade != null && !StringUtils.isEmpty(trade.getUrl())){
            CloseableHttpResponse httpResponse = null;
            HttpGet httpGet = new HttpGet(DOMAIN + trade.getUrl());
            try {
                httpResponse = closeHttpClient.execute(httpGet);
                String html = EntityUtils.toString(httpResponse.getEntity(),
                        "UTF-8");

                if (html != null) {
                    Document doc = Jsoup.parse(html);

                    String contentStr = doc.select("div#Zoom").html();
                    PubTradeContent content = new PubTradeContent();
                    content.setIndexid(trade.getIndexid());
                    content.setContent(contentStr);
                    content.setCreateDate(new Date());
                    content.setUpdateDate(new Date());

                    contentService.checkDuplicatedAndSave(content);


                    if(trade.getTitle().contains("资格后审")){
                        trade.setTenderType("招标公告（资格后审）");
                        // do none
                    }else {
                        Elements trs = doc.select("div#Zoom table tr");
                        if(trs != null && !trs.isEmpty()){
                            //中标候选人公示，无锡市工程建设项目预中标候选人公示
                            Element typeTr = trs.get(0);
                            if(typeTr != null){
                                String typeLabel= typeTr.select("td").first().text();
                                trade.setTenderType(typeLabel);
                            }
                            Element tendInnerNumTr = trs.get(2);
                            if(tendInnerNumTr != null){
                                String innerNumLabel= tendInnerNumTr.select("td").first().text();
                                trade.setTenderInnerNum(innerNumLabel.substring(innerNumLabel.indexOf("：")+1).trim());
                                logger.info("------tenderinnernum:" + trade.getTenderInnerNum());
                            }
                        }else {
                            trs = doc.select("div#Zoom table tr");
                            //招标公告
                            if(trs != null && !trs.isEmpty()){
                                Element typeTr = trs.get(1);
                                if(typeTr != null){
                                    Element el = typeTr.select("td").first();
                                    if(el != null && !el.hasAttr("class")){
                                        String typeLabel= el.text();
                                        trade.setTenderType(typeLabel);
                                    }
                                }
                                if(!StringUtils.isEmpty(trade.getTenderType())){
                                    if(trade.getTenderType().contains("资格预审公告")){
                                        Element tendInnerNumTr = trs.get(2);
                                        if(tendInnerNumTr != null){
                                            String innerNumLabel= tendInnerNumTr.select("td p").first().text();
                                            trade.setTenderInnerNum(innerNumLabel);
                                            logger.info("------tenderinnernum:" + trade.getTenderInnerNum());
                                        }
                                    }else {
                                        Element tendInnerNumTr = trs.get(4);
                                        if(tendInnerNumTr != null){
                                            Elements pEl = tendInnerNumTr.select("td p");
                                            if(pEl != null && !pEl.isEmpty()){
                                                String innerNumLabel= pEl.first().text();
                                                trade.setTenderInnerNum(innerNumLabel);
                                                logger.info("------tenderinnernum:" + trade.getTenderInnerNum());
                                            }
                                        }
                                    }
                                }

                            }
                        }

                        if(!StringUtils.isEmpty(trade.getTenderInnerNum()) && trade.getTenderInnerNum().indexOf("WX") < 0){
                            trade.setTenderInnerNum("");
                        }

                    }

                }
            } catch (IOException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                logger.error("=======error:" + trade.toString());
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
        }
    }

    private void resolveSinglePageData(TradeTableBean data) {
        if (data != null && data.getList() != null && !data.getList().isEmpty()) {
            for (TradeInfoBean item : data.getList()) {
                Trade t = transferToEntity(item);
                try{

                    service.checkDuplicatedAndSave(t);

                    getContentPageData(t);

                    service.updateProjectInfo(t);

                }catch(Exception e){
                    e.printStackTrace();
                    logger.error(e.getMessage());
                    logger.error(t.toString());
                }
            }
        }
    }

    private Trade transferToEntity(TradeInfoBean bean) {
        Trade result = new Trade();
        if (bean != null) {
            try {
                result.setTitle(bean.getTitle());
                result.setWritetime(DateUtils.parseDate(bean.getWriteTime(), YYYY_MM_DD));
                result.setOpentime(DateUtils.parseDate(bean.getOpenTime(),YYYY_MM_DD));
                result.setIndexid(bean.getIndexId());
                result.setUrl(bean.getUrl());
                result.setOrganization(bean.getOrganization());
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }
        }
        return result;
    }

}
