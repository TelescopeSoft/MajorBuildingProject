package com.qlmsoft.mbp.modules.crawler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by aaronhuang on 2018/7/24.
 */
@Component("adminPenaltyCrawlerTask")
public class AdminPenaltyCrawlerTask {
    protected Logger logger = LoggerFactory.getLogger(AdminPenaltyCrawlerTask.class);

    @Autowired
    private AdminPenaltyCrawler crawler;

    public void execute() {
        logger.info("AdminPenaltyCrawlerTask.execute start");
        long start = System.currentTimeMillis();
        try {

            crawler.synchAll();

        } catch (Exception e) {
            logger.error(e.getMessage());

        }

        long end = System.currentTimeMillis();
        logger.info("AdminPenaltyCrawlerTask cost:" + (end - start) + " secs");

    }

}
