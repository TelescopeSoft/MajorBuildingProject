package com.qlmsoft.mbp.modules.crawler.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qlmsoft.mbp.modules.project.entity.PubAdminPenalty;
import com.qlmsoft.mbp.modules.project.service.PubAdminPenaltyService;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by aaronhuang on 2018/7/24.
 */
@Service
public class AdminPenaltyCrawler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String QUERY_URL = "http://58.215.18.240/webshow/list.json";


    @Autowired
    PubAdminPenaltyService service;


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
        params.add(new BasicNameValuePair("id", "2"));
        params.add(new BasicNameValuePair("name", ""));
        params.add(new BasicNameValuePair("deptCode", "014032097"));
        params.add(new BasicNameValuePair("secCode", "320211"));
        params.add(new BasicNameValuePair("page", "1"));
        params.add(new BasicNameValuePair("rows", "100"));

        httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));

        try {

            httpResponse = closeHttpClient.execute(httpPost);
            String html = EntityUtils.toString(httpResponse.getEntity(),
                    "UTF-8");
            logger.info(html);
            if (html != null) {
                JSONObject data = JSON.parseObject(html);
                int total = data.getIntValue("total");
                logger.info("----total : " + total);
                JSONArray rows = data.getJSONArray("rows");
                logger.info("----rows.size() : " + rows.size());
                if (rows.size() > 0) {
                    for (java.util.Iterator iter = rows.iterator(); iter.hasNext(); ) {
                        JSONObject item = (JSONObject) iter.next();

                        PubAdminPenalty pe = transferToEntity(item);

                        service.checkDuplicatedAndSave(pe);

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


    private PubAdminPenalty transferToEntity(JSONObject json) {
        PubAdminPenalty result = new PubAdminPenalty();
        if (json != null) {
            try {
                result.setLetterOfDecision(json.getString("CF_WSH"));
                result.setName(json.getString("CF_CFMC"));
                result.setPunishCategory(json.getString("CF_CFLB1"));
                result.setPunishReason(json.getString("CF_SY"));
                result.setPunishBasis(json.getString("CF_YJ"));
                result.setAdminRelativePerson(json.getString("CF_XDR_MC"));
                result.setAdminRelativePersonCode(json.getString("CF_XDR_SHXYM"));
                result.setLegalRepresentative(json.getString("CF_FR"));
                //result.setPunishResult(json.getString("CFJC"));
                //result.setPunishResult(json.getString("CF_JG"));


                result.setPunishmentDecisionDate(new Date(json.getLong("CF_JDRQ")));
                //result.setPunishDeptLabel(json.getString("XXTGBM"));
                result.setPunishDeptLabel(json.getString("CF_XZJG"));
                result.setDisplayFlag("0");

                result.setPublicDeadline(new Date(json.getLong("CF_GSJZQ")));
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }


        }
        return result;
    }

}
