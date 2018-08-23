package com.qlmsoft.mbp.modules.synch;

import com.qlmsoft.mbp.modules.crawler.service.AdminPenaltyCrawler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("mohurdProjectTask")
public class MohurdProjectTask {
    protected Logger logger = LoggerFactory.getLogger(MohurdProjectTask.class);

    @Autowired
    private MohurdProjectDataSynch syncher;

    public void execute() {
        logger.info("MohurdProjectTask.execute start");
        long start = System.currentTimeMillis();
        try {

            syncher.synchProjectInfo();

        } catch (Exception e) {
            logger.error(e.getMessage());

        }

        long end = System.currentTimeMillis();
        logger.info("MohurdProjectTask cost:" + (end - start) + " secs");

    }

}
