package com.qlmsoft.mbp.test;

import com.qlmsoft.mbp.common.utils.Encodes;
import com.qlmsoft.mbp.common.utils.XmlBuilder;
import com.qlmsoft.mbp.common.utils.XmlDecodeUtil;
import com.qlmsoft.mbp.modules.project.bean.DataTableProjectInfo;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

/**
 * Created by aaronhuang on 2018/8/21.
 */
public class WebServiceTest {
    public static void main(String[] args) {
        axis2WebService();
    }
    private static void axis2WebService() {
        try {
            String soapBindingAddress = "http://218.90.162.110:8889/WxjzgcjczyPage/DataExchange.asmx";
            ServiceClient sender = new ServiceClient();
            EndpointReference endpointReference = new EndpointReference(soapBindingAddress);
            Options options = new Options();
            options.setAction("http://218.90.162.110:8889/WxjzgcjczyPage/ReadTBDataForCounty");
            options.setTo(endpointReference);
            options.setProperty(HTTPConstants.CHUNKED, "false");
            sender.setOptions(options);
            OMFactory fac = OMAbstractFactory.getOMFactory();

            OMNamespace omNs = fac.createOMNamespace("http://218.90.162.110:8889/WxjzgcjczyPage/",  "wxj");
            OMElement method = fac.createOMElement("ReadTBDataForCounty", omNs);
            // 对应参数的节点
            String[] strs = new String[] { "tableName","user","password","beginDate","endDate" };
            // 参数值
            String[] val = new String[] { "tbprojectinfo","320211","bhzj20180815","2018-08-01","2018-08-20" };
            for (int i = 0; i < strs.length; i++) {
                OMElement inner = fac.createOMElement(strs[i],omNs);
                inner.setText(val[i]);
                method.addChild(inner);
            }
            // 发送数据，返回结果
            OMElement result = sender.sendReceive(method);


            String decodeStr = XmlDecodeUtil.xmlStrToObject(result.getFirstElement().getText(), Encodes.ENCODING_GBK);
            DataTableProjectInfo dataTable = (DataTableProjectInfo) XmlBuilder.xmlStrToObject(DataTableProjectInfo.class, decodeStr);
            System.out.println(dataTable.toString());

        } catch (AxisFault ex) {
            ex.printStackTrace();
        }

    }

}
