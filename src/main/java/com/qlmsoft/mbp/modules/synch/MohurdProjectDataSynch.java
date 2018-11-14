/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.synch;

import com.qlmsoft.mbp.common.config.Global;
import com.qlmsoft.mbp.common.utils.*;
import com.qlmsoft.mbp.modules.project.bean.DataTableProjectInfo;
import com.qlmsoft.mbp.modules.project.entity.ProjectInfo;
import com.qlmsoft.mbp.modules.project.service.TBProjectInfoService;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;


@Service
public class MohurdProjectDataSynch {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String MOHURD_SERVICE = "http://218.90.162.110:8889/WxjzgcjczyPage/DataExchange.asmx";
    public static final String NAMESPACE = "http://218.90.162.110:8889/WxjzgcjczyPage/";
    public static final String NAMESPACE_TAG = "wxj";
    public static final String METHOD = "ReadTBDataForCounty";

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String USER = Global.getConfig("zj.interface.user");
    public static final String PASSWORD = Global.getConfig("zj.interface.pass");


    @Autowired
    TBProjectInfoService service;

    public boolean synchProjectInfo() {

        String endDate = DateUtils.getDate();

        //如果设置了开始时间，则使用设置的开始时间，如果没有，默认当天往前推5天
        String startDate = Global.getConfig("zj.interface.begindate");
        if (StringUtils.isEmpty(startDate)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 5);
            startDate = DateUtils.formatDate(calendar.getTime(), DATE_FORMAT);
        }

        return synchProjectInfo(startDate, endDate);
    }

    public boolean synchProjectInfo(String startDate, String endDate) {
        boolean success = true;
        ServiceClient sender = null;
        try {
            sender = new ServiceClient();

            EndpointReference endpointReference = new EndpointReference(MOHURD_SERVICE);
            Options options = new Options();
            options.setAction(NAMESPACE + METHOD);
            options.setTo(endpointReference);
            options.setProperty(HTTPConstants.CHUNKED, "false");
            sender.setOptions(options);
            OMFactory fac = OMAbstractFactory.getOMFactory();

            OMNamespace omNs = fac.createOMNamespace(NAMESPACE, NAMESPACE_TAG);
            OMElement method = fac.createOMElement(METHOD, omNs);
            // 对应参数的节点
            String[] params = new String[]{"tableName", "user", "password", "beginDate", "endDate"};
            // 参数值
            String[] paramValues = new String[]{"tbprojectinfo", USER, PASSWORD, startDate, endDate};
            for (int i = 0; i < params.length; i++) {
                OMElement inner = fac.createOMElement(params[i], omNs);
                inner.setText(paramValues[i]);
                method.addChild(inner);
            }
            // 发送数据，返回结果
            OMElement result = sender.sendReceive(method);

            String decodeStr = XmlDecodeUtil.xmlStrToObject(result.getFirstElement().getText(), Encodes.ENCODING_GBK);
            DataTableProjectInfo dataTable = (DataTableProjectInfo) XmlBuilder.xmlStrToObject(DataTableProjectInfo.class, decodeStr);
            if(dataTable != null && dataTable.getRows() != null){
                for(ProjectInfo pi : dataTable.getRows()){
                    logger.info("ProjectInfo-----" + pi.getPkid() + "," + pi.getPrjnum());
                    try{
                        service.checkDuplicatedAndSave(pi);
                    }catch(Exception e){
                        e.printStackTrace();
                        logger.error(e.getMessage());
                    }

                }
            }

        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
            logger.error(axisFault.getMessage());
            success = false;
        } catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            success = false;
        }

        return success;

    }

}
