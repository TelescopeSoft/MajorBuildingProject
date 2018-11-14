/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.synch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("mohurdProjectTask")
public class MohurdProjectTask {
    protected Logger logger = LoggerFactory.getLogger(MohurdProjectTask.class);

    @Autowired
    private MohurdProjectDataSynch syncher;

    @Autowired
    private TenderInfoSynch tenderSynch;

    @Autowired
    private ContractRecordSynch contractRecordSynch;

    @Autowired
    private BuildLicenseSynch buildLicenseSynch;

    @Autowired
    private ProjectFinishSynch projectFinishSynch;

    @Autowired
    private ApAjsbbSynch ajSynch;

    @Autowired
    private ApZjsbbSynch zjSynch;


    public void execute() {
        logger.info("MohurdProjectTask.execute start");
        long start = System.currentTimeMillis();
        try {

            syncher.synchProjectInfo();

            tenderSynch.synchTable(MohurdConstant.TENDER);
            contractRecordSynch.synchTable(MohurdConstant.CONTRACT_RECORD);
            buildLicenseSynch.synchTable(MohurdConstant.BUILD_LICENSE);
            projectFinishSynch.synchTable(MohurdConstant.PROJECT_FINISH);

            ajSynch.synchTable(MohurdConstant.APAJSBB);
            zjSynch.synchTable(MohurdConstant.APZJSBB);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());

        }

        long end = System.currentTimeMillis();
        logger.info("MohurdProjectTask cost:" + (end - start) + " secs");

    }

}
