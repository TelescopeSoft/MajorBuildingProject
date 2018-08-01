package com.qlmsoft.mbp.modules.crawler.service;

import com.qlmsoft.mbp.modules.project.entity.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by aaronhuang on 2018/7/24.
 */
@Component("tradeCrawlerTask")
public class TradeCrawlerTask {
    protected Logger logger = LoggerFactory.getLogger(TradeCrawlerTask.class);

    @Autowired
    private TradeCrawler crawler;

    public void execute() {
        logger.info("TradeCrawlerTask.execute start");
        long start = System.currentTimeMillis();
        try {

            crawler.synchAll();

        } catch (Exception e) {
            logger.error(e.getMessage());

        }

        long end = System.currentTimeMillis();
        logger.info("TradeCrawlerTask cost:" + (end - start) + " secs");

    }

}
