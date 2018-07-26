package com.qlmsoft.mbp.modules.crawler.service;

import com.qlmsoft.mbp.modules.project.bean.ResultBean;
import com.qlmsoft.mbp.modules.project.dao.TBProjectInfoDao;
import com.qlmsoft.mbp.modules.project.entity.ProjectInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by aaronhuang on 2018/7/21.
 */
@Component("approveResultCrawlerTask")
public class ApproveResultCrawlerTask {
    protected Logger logger = LoggerFactory.getLogger(ApproveResultCrawlerTask.class);

    @Autowired
    TBProjectInfoDao projectDao;

    @Autowired
    private ApproveResultCrawler crawler;

    public void execute() {
        logger.info("ApproveResultCrawlerTask.execute start");
        long start = System.currentTimeMillis();

        List<ProjectInfo> list = this.projectDao.getCrawlerProjectList();
        for(ProjectInfo i : list  ){
            try {
                boolean r = crawler.synchByPrjName(i);
                Thread.sleep(30*1000l);
                if(!r){
                    logger.info("crawler " + i.getPrjname() + "[fail]");
                }

            } catch (Exception e) {
                logger.error(e.getMessage());
                logger.error("crawler " + i.getPrjname() + "[fail]");
            }
        }

        long end = System.currentTimeMillis();
        logger.info("synch org cost:" + (end - start) + " secs");

    }

}
