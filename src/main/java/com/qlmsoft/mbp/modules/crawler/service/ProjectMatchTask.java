package com.qlmsoft.mbp.modules.crawler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by aaronhuang on 2018/7/24.
 */
@Component("projectMatchTask")
public class ProjectMatchTask {
    protected Logger logger = LoggerFactory.getLogger(ProjectMatchTask.class);

    @Autowired
    private ProjectMatch matcher;

    public void execute() {
        logger.info("ProjectMatchTask.execute start");
        long start = System.currentTimeMillis();
        try {

            matcher.start();

        } catch (Exception e) {
            logger.error(e.getMessage());

        }

        long end = System.currentTimeMillis();
        logger.info("ProjectMatchTask cost:" + (end - start) + " secs");

    }

}
