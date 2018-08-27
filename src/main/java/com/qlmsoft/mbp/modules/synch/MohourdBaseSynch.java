package com.qlmsoft.mbp.modules.synch;

import com.qlmsoft.mbp.common.config.Global;
import com.qlmsoft.mbp.common.utils.*;
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

import java.util.Calendar;
import java.util.Date;

public abstract class MohourdBaseSynch {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String USER = Global.getConfig("zj.interface.user");
    public static final String PASSWORD = Global.getConfig("zj.interface.pass");

    protected String tableName = null;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public boolean synchTable(String tableName ) {

        logger.info("synchTable : " + tableName);
        this.setTableName(tableName);

        String endDate = DateUtils.getDate();

        //如果设置了开始时间，则使用设置的开始时间，如果没有，默认当天往前推5天
        String startDate = Global.getConfig("zj.interface.begindate");
        if (StringUtils.isEmpty(startDate)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 5);
            startDate = DateUtils.formatDate(calendar.getTime(), MohurdConstant.DATE_FORMAT);
        }
        return synchTable(startDate, endDate);

    }

    private boolean synchTable(String startDate, String endDate) {
        logger.info("synchTable : " + startDate + " to  " + endDate);
        boolean success = true;
        ServiceClient sender = null;
        try {
            sender = new ServiceClient();

            EndpointReference endpointReference = new EndpointReference(MohurdConstant.MOHURD_SERVICE);
            Options options = new Options();
            options.setAction(MohurdConstant.NAMESPACE + MohurdConstant.METHOD);
            options.setTo(endpointReference);
            options.setProperty(HTTPConstants.CHUNKED, "false");
            sender.setOptions(options);
            OMFactory fac = OMAbstractFactory.getOMFactory();

            OMNamespace omNs = fac.createOMNamespace(MohurdConstant.NAMESPACE, MohurdConstant.NAMESPACE_TAG);
            OMElement method = fac.createOMElement(MohurdConstant.METHOD, omNs);
            // 对应参数的节点
            String[] params = new String[]{"tableName", "user", "password", "beginDate", "endDate"};
            // 参数值
            String[] paramValues = new String[]{tableName , USER, PASSWORD, startDate, endDate};
            for (int i = 0; i < params.length; i++) {
                OMElement inner = fac.createOMElement(params[i], omNs);
                inner.setText(paramValues[i]);
                method.addChild(inner);
            }
            // 发送数据，返回结果
            OMElement result = sender.sendReceive(method);

            String decodeStr = XmlDecodeUtil.xmlStrToObject(result.getFirstElement().getText(), Encodes.ENCODING_GBK);

            resolveResponse(decodeStr);


        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
            logger.error(axisFault.getMessage());
            success = false;
        }catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            success = false;
        }

        return success;

    }

    protected abstract void resolveResponse(String decodeStr);

}
