package com.qlmsoft.mbp.modules.crawler.service;

import com.qlmsoft.mbp.common.utils.RegUtils;
import com.qlmsoft.mbp.common.utils.StringUtils;
import com.qlmsoft.mbp.modules.project.entity.*;
import com.qlmsoft.mbp.modules.project.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Service
public class ProjectMatch {

    public static final String USER_MATCHERBYAPPROVENUM = "matcherbyapprovenum";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ApplyProjectInfoService fgProjectService;

    @Autowired
    private ApproveItemInfoService approveService;

    @Autowired
    private PubApproveResultService approveResultService;

    @Autowired
    TBProjectInfoService zjProjectService;

    @Autowired
    TenderInfoService zjTenderService;

    @Autowired
    TradeService tradeService;


    public void start() {

        //按发改重大建设项目匹配住建项目

        ApplyProjectInfo fgPrj = new ApplyProjectInfo();
        fgPrj.setTotalMoney(new BigDecimal(5000));

        List<ApplyProjectInfo> projects = fgProjectService.findNotMatchedList(fgPrj);

        int total = projects.size();
        int success = 0;
        for (ApplyProjectInfo prj : projects) {
            try {
//                logger.info("begin :" + prj.getProjectCode() + " , " + prj.getProjectName());

                //按名称匹配
                ProjectInfo zjPrjInfo = zjProjectService.getBaseByName(prj.getProjectName());
                if (zjPrjInfo != null && StringUtils.isEmpty(zjPrjInfo.getPrjCode())) {

//                    logger.info("match :" + prj.getProjectCode() + " , " + prj.getProjectName() + "," + zjPrjInfo.getPrjnum());
                    zjPrjInfo.setPrjCode(prj.getProjectCode());
                    zjPrjInfo.setXgrqsj(new Date());
                    zjPrjInfo.setUpdateuser("matcherbyname");
                    zjProjectService.updateProjectCode(zjPrjInfo);
                    success++;
                } else {
                    //按发改立项文号匹配

                    //投资在线监管平台推送的数据
                    ApproveItemInfo approveItem = new ApproveItemInfo();
                    approveItem.setProjectCode(prj.getProjectCode());
                    approveItem.setDeptCode("320211012");

                    List<ApproveItemInfo> list = approveService.findList(approveItem);
                    if (list != null && !list.isEmpty()) {
                        for (ApproveItemInfo item : list) {
//                            logger.info("item.getApprovalNum():----- :" + item.getApprovalNum());
                            List<String> approveList = RegUtils.abstractApproveNum(item.getApprovalNum());
                            if (approveList != null && !approveList.isEmpty()) {
                                String approveType = approveList.get(0);
                                String approveNum = approveList.get(1) + approveList.get(2);
//                                logger.info(prj.getProjectName() + "----" + approveType + "|" + approveNum);
                                if (StringUtils.isNotEmpty(approveType) && StringUtils.isNotEmpty(approveNum)) {
                                    ProjectInfo zjPrjInfo1 = zjProjectService.getBaseByApproveNum(approveType, approveNum);
                                    if (zjPrjInfo1 != null) {
//                                        logger.info("-----match :" + prj.getProjectCode() + " , " + prj.getProjectName() + "," + zjPrjInfo1.getPrjnum());
                                        zjPrjInfo1.setPrjCode(prj.getProjectCode());
                                        zjPrjInfo1.setXgrqsj(new Date());
                                        zjPrjInfo1.setUpdateuser("matcherbyapprovenum");
                                        zjProjectService.updateProjectCode(zjPrjInfo1);
                                        success++;
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    //省投资在线审批监管平台公示数据
                    PubApproveResult pubResult = new PubApproveResult();
                    pubResult.setPrjCode(prj.getProjectCode());
                    //pubResult.setApproveDept("发改");
                    List<PubApproveResult> pubList = approveResultService.findList(pubResult);
                    if (pubList != null && !pubList.isEmpty()) {
                        for (PubApproveResult item : pubList) {
//                            logger.info("PubApproveResult.getApprovalNum():----- :" + item.getApproveNum());
                            List<String> approveList = RegUtils.abstractApproveNum(item.getApproveNum());
                            if (approveList != null && !approveList.isEmpty()) {
                                String approveType = approveList.get(0);
                                String approveNum = approveList.get(1) + approveList.get(2);
                                logger.info(prj.getProjectName() + "----" + approveType + "|" + approveNum);
                                if (StringUtils.isNotEmpty(approveType) && StringUtils.isNotEmpty(approveNum)) {
                                    ProjectInfo zjPrjInfo1 = zjProjectService.getBaseByApproveNum(approveType, approveNum);
                                    if (zjPrjInfo1 != null && StringUtils.isEmpty(zjPrjInfo1.getPrjCode())) {
//                                        logger.info("-----match :" + prj.getProjectCode() + " , " + prj.getProjectName() + "," + zjPrjInfo1.getPrjnum());
                                        zjPrjInfo1.setPrjCode(prj.getProjectCode());
                                        zjPrjInfo1.setXgrqsj(new Date());
                                        zjPrjInfo1.setUpdateuser(USER_MATCHERBYAPPROVENUM);
                                        zjProjectService.updateProjectCode(zjPrjInfo1);
                                        success++;
                                        break;
                                    }
                                }
                            }
                        }
                    }

                }


            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }


        }

        logger.info("-----matched project :" + success + "/" + total);

        //按招标投标信息匹配
        List<Trade> tenders = tradeService.findListWithNoPrjCode();
        int totalTender = tenders.size();
        int successTender = 0;
        for (Trade trade : tenders) {
//            logger.info("====" + trade.getTitle() + "|" + trade.getTenderInnerNum());
            String prjCode = zjTenderService.getByTenderInnerNum(trade.getTenderInnerNum());
//            logger.info("====prjCode:" + prjCode);
            if (StringUtils.isNotEmpty(prjCode)) {
                trade.setPrjCode(prjCode);
                tradeService.updateProjectInfo(trade);
                successTender++;
            }
        }
        logger.info("-----matched tender  :" + successTender + "/" + totalTender);

    }

}
