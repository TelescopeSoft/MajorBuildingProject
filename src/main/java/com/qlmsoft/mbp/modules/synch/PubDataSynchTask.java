/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.synch;

import com.qlmsoft.mbp.common.utils.DateUtils;
import com.qlmsoft.mbp.modules.project.entity.ApplyProjectInfo;
import com.qlmsoft.mbp.modules.project.entity.ApproveItemInfo;
import com.qlmsoft.mbp.modules.project.entity.PubConfig;
import com.qlmsoft.mbp.modules.project.service.ApplyProjectInfoService;
import com.qlmsoft.mbp.modules.project.service.ApproveItemInfoService;
import com.qlmsoft.mbp.modules.project.service.PubConfigService;
import com.qlmsoft.mbp.modules.project.service.SynchPubDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Component("pubDataSynchTask")
public class PubDataSynchTask {
    protected Logger logger = LoggerFactory.getLogger(PubDataSynchTask.class);


    @Autowired
    private ApplyProjectInfoService applyProjectInfoService;
    @Autowired
    private ApproveItemInfoService approveItemInfoService;
    @Autowired
    PubConfigService configService;

    @Autowired
    private SynchPubDataService synchPubDataService;




    public void execute() {
        logger.info("PubDataSynchTask.execute start");
        long start = System.currentTimeMillis();
        try {
            Date now = new Date();
            synchProjectInfoAll();
            //synchProjectInfo();

            List<ApplyProjectInfo> allProjectInfo = getAllProjectInfoByDate(new Date());

            List<String> projectCodeList = new ArrayList<String>();
            for(ApplyProjectInfo i : allProjectInfo){
                projectCodeList.add(i.getProjectCode());
            }

            synchApproveItemInfo(projectCodeList , now);





        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());

        }

        long end = System.currentTimeMillis();
        logger.info("PubDataSynchTask cost:" + (end - start) + " secs");

    }

    private void synchApproveItemInfo(List<String>  projectCodeList , Date now) {

        List<ApproveItemInfo> approveItemInfos =  approveItemInfoService.findPublicData(projectCodeList , now);

        if(approveItemInfos != null){
            for(ApproveItemInfo item : approveItemInfos){

            }
        }

    }

    public void synchProjectInfo() {
        Date  now = new Date();
        List<ApplyProjectInfo> lastMonthData = getProjectInfoByMonth(now);
//            logger.info("last month data : "  + DateUtils.formatDate(tmp, "yyyy-MM") + lastMonthData.size());
        for(ApplyProjectInfo info : lastMonthData){
            try{
                synchPubDataService.saveProjectInfo(info);
            }catch (Exception e){
                logger.error(e.getMessage(),e);
                e.printStackTrace();
            }
        }
    }

    public void synchProjectInfoAll() {

        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateUtils.parseDate("2016-01-01"));
        Date tmp = cal.getTime();

        while(tmp.before(now) ){

            List<ApplyProjectInfo> lastMonthData = getProjectInfoByMonth(tmp);
//            logger.info("last month data : "  + DateUtils.formatDate(tmp, "yyyy-MM") + lastMonthData.size());
            for(ApplyProjectInfo info : lastMonthData){
//                logger.info("info: " + info.toString());
                try{
//                    synchPubDataService.saveProjectInfo(info);
                }catch (Exception e){
                    logger.error(e.getMessage(),e);
                    e.printStackTrace();
                }
            }
            cal.add(Calendar.MONTH , 1);
            tmp = cal.getTime();
        }
    }

    public List<ApplyProjectInfo> getProjectInfoByMonth(Date currentDate){
        return getProjectInfoByDateRange(DateUtils.getFirstDayOfLastMonth(currentDate) ,
                DateUtils.getLastDayOfLastMonth(currentDate) );
    }

    public List<ApplyProjectInfo> getAllProjectInfoByDate(Date now){
        Calendar cal = Calendar.getInstance();
        cal.set(2013,0,1);
        return getProjectInfoByDateRange(DateUtils.formatDate(cal.getTime()), DateUtils.formatDate(now));
    }

    public List<ApplyProjectInfo> getProjectInfoByDateRange(Date startDate, Date endDate){
        return getProjectInfoByDateRange(DateUtils.formatDate(startDate), DateUtils.formatDate(endDate));
    }

    public List<ApplyProjectInfo> getProjectInfoByDateRange(String start, String end){
        ApplyProjectInfo projectInfo = new ApplyProjectInfo();
        PubConfig config = configService.getByKey("total_money");
        if(config == null){
            projectInfo.setTotalMoney(new BigDecimal(5000l));
        }else {
            projectInfo.setTotalMoney(new BigDecimal(config.getCvalue()));
        }
        projectInfo.setDisplayFlag("Y");
        projectInfo.setMajorFlag("Y");
        projectInfo.setApplyDateStart(start);
        projectInfo.setApplyDateEnd(end);
        projectInfo.setProjectType("A00001,A00002,A00003");
        return  applyProjectInfoService.findList(projectInfo);
    }

}
