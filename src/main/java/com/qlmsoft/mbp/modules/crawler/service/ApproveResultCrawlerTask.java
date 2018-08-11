package com.qlmsoft.mbp.modules.crawler.service;

import com.qlmsoft.mbp.modules.project.bean.ResultBean;
import com.qlmsoft.mbp.modules.project.dao.TBProjectInfoDao;
import com.qlmsoft.mbp.modules.project.entity.ApplyProjectInfo;
import com.qlmsoft.mbp.modules.project.entity.ProjectInfo;
import com.qlmsoft.mbp.modules.project.service.ApplyProjectInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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
    ApplyProjectInfoService fgProjectService;

    @Autowired
    private ApproveResultCrawler crawler;

    public void execute() {
        logger.info("ApproveResultCrawlerTask.execute start");
        long start = System.currentTimeMillis();

//        List<ProjectInfo> list = this.projectDao.getCrawlerProjectList();
        ApplyProjectInfo fgPrj = new ApplyProjectInfo();
        fgPrj.setTotalMoney(new BigDecimal(5000));
//        List<ApplyProjectInfo> list = fgProjectService.findNotMatchedList(fgPrj);
        List<ApplyProjectInfo> list = fgProjectService.findList(fgPrj);
        for(ApplyProjectInfo i : list  ){
            try {
                boolean r = crawler.synchByPrjName(i);
                Thread.sleep(30*1000l);
                if(!r){
                    logger.info("crawler " + i.getProjectName() + "[fail]");
                }

            } catch (Exception e) {
                logger.error(e.getMessage());
                logger.error("crawler " + i.getProjectName()+ "[fail]");
            }
        }

        long end = System.currentTimeMillis();
        logger.info("synch org cost:" + (end - start) + " secs");

    }

}
