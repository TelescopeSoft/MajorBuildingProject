package com.qlmsoft.mbp.common.utils;

import org.apache.log4j.Logger;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * Base64格式XML解码工具: 用于xml文件所有节点的Base64格式解码
 * 
 * @author huang.zhengyu
 * @date 2018-08-21
 */
public abstract class XmlDecodeUtil {
	private final static Logger log = Logger.getLogger(XmlDecodeUtil.class);


	/**
	 * 将XML字符串转换为指定类型的pojo
	 *
	 * @param xmlStr
	 * @return
	 */
	public static String xmlStrToObject(String xmlStr,String decodeType) {
		SAXReader sax=new SAXReader();//创建一个SAXReader对象

		Document document= null;
		try {
			document = DocumentHelper.parseText(xmlStr);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root=document.getRootElement();
		traversalNodes(root, decodeType);
		return document.asXML();
	}

	public static void traversalNodes(Element node, String decodeType){

		if(StringUtils.isEmpty(decodeType)){
			decodeType = Encodes.DEFAULT_URL_ENCODING;
		}
		if(StringUtils.isNotEmpty(node.getTextTrim())){
			node.setText(Encodes.decodeBase64String(node.getTextTrim(),decodeType));
		}


		//递归遍历当前节点所有的子节点
		List<Element> listElement=node.elements();//所有一级子节点的list
		for(Element e:listElement){//遍历所有一级子节点
			traversalNodes(e,decodeType);//递归
		}
	}
}
