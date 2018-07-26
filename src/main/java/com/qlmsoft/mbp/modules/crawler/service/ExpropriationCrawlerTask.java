package com.qlmsoft.mbp.modules.crawler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by aaronhuang on 2018/7/24.
 */
@Component("expropriationCrawlerTask")
public class ExpropriationCrawlerTask {
    protected Logger logger = LoggerFactory.getLogger(ExpropriationCrawlerTask.class);

    @Autowired
    private ExpropriationCrawler crawler;

    public void execute() {
        logger.info("ExpropriationCrawlerTask.execute start");
        long start = System.currentTimeMillis();
        try {

            crawler.synchAll();

        } catch (Exception e) {
            logger.error(e.getMessage());

        }

        long end = System.currentTimeMillis();
        logger.info("ExpropriationCrawlerTask cost:" + (end - start) + " secs");

    }

}
