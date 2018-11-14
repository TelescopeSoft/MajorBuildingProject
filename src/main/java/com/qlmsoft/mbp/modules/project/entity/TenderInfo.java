/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.qlmsoft.mbp.common.utils.JaxbDateAdapter;
import com.qlmsoft.mbp.common.utils.JaxbDateAdapter2;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 招标投标Entity
 * 
 * @author huangzhengyu
 * @version 2018-07-14
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TenderInfo extends DataEntity<TenderInfo> {

	private static final long serialVersionUID = 1L;
	@XmlElement(name = "PKID")
	private String pkid; // pkid
	@XmlElement(name = "TenderName")
	private String tendername; // 标段名称
	@XmlElement(name = "TenderNum")
	private String tendernum; // 中标通知书编号
	@XmlElement(name = "TenderInnerNum")
	private String tenderinnernum; // 中标通知书内部编号
	@XmlElement(name = "PrjNum")
	private String prjnum; // 项目编号
	@XmlElement(name = "TenderClassNum")
	private String tenderclassnum; // 招标类型

	private String tenderclassnumlabel; // 招标类型文本
	@XmlElement(name = "TenderTypeNum")
	private String tendertypenum; // 招标方式
	private String tendertypenumlabel; // 招标方式文本
	@XmlElement(name = "TenderResultDate")
	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	private Date tenderresultdate; // 中标日期

	@XmlElement(name = "TenderMoney")
	private Double tendermoney; // 中标金额

	@XmlElement(name = "PrjSize")
	private String prjsize; // 建设规模

	@XmlElement(name = "Area")
	private Double area; // 面积（平方米）

	@XmlElement(name = "AgencyCorpName")
	private String agencycorpname; // 招标代理单位名称
	@XmlElement(name = "AgencyCorpCode")
	private String agencycorpcode; // 招标代理单位组织机构代码（社会信用代码）
	@XmlElement(name = "TenderCorpName")
	private String tendercorpname; // 中标单位名称
	@XmlElement(name = "TenderCorpCode")
	private String tendercorpcode; // 中标单位组织机构代码（社会信用代码）

	@XmlElement(name = "ConstructorName")
	private String constructorname; // 项目经理/总监理工程师姓名

	@XmlElement(name = "ConstructorPhone")
	private String constructorphone; // 项目经理/总监理工程师电话

	@XmlElement(name = "IDCardTypeNum")
	private String idcardtypenum; // 项目经理/总监理工程师证件类型

	@XmlElement(name = "ConstructorIDCard")
	private String constructoridcard; // 项目经理/总监理工程师证件号码

	@XmlElement(name = "shypbf")
	private String shypbf; // 三合一评标法

	@XmlElement(name = "CreateDate")
	@XmlJavaTypeAdapter(JaxbDateAdapter2.class)
	private Date createdate; // 记录登记时间

	@XmlElement(name = "UpdateFlag")
	private String updateflag; // 数据更新标识

	@XmlElement(name = "sbdqbm")
	private String sbdqbm; // 上报地区编码

	private String datastate; // datastate
	private Date cjrqsj; // cjrqsj
	private Date xgrqsj; // xgrqsj
	private Date scrqsj; // scrqsj
	private String returnresult; // returnresult
	private String updateuser; // updateuser

	public TenderInfo() {
		super();
	}

	public TenderInfo(String id) {
		super(id);
	}

	@Length(min = 1, max = 50, message = "pkid长度必须介于 1 和 50 之间")
	public String getPkid() {
		return pkid;
	}

	public void setPkid(String pkid) {
		this.pkid = pkid;
	}

	@Length(min = 1, max = 200, message = "标段名称长度必须介于 1 和 200 之间")
	public String getTendername() {
		return tendername;
	}

	public void setTendername(String tendername) {
		this.tendername = tendername;
	}

	@Length(min = 1, max = 50, message = "中标通知书编号长度必须介于 1 和 50 之间")
	public String getTendernum() {
		return tendernum;
	}

	public void setTendernum(String tendernum) {
		this.tendernum = tendernum;
	}

	@Length(min = 1, max = 50, message = "中标通知书内部编号长度必须介于 1 和 50 之间")
	public String getTenderinnernum() {
		return tenderinnernum;
	}

	public void setTenderinnernum(String tenderinnernum) {
		this.tenderinnernum = tenderinnernum;
	}

	@Length(min = 1, max = 20, message = "项目编号长度必须介于 1 和 20 之间")
	public String getPrjnum() {
		return prjnum;
	}

	public void setPrjnum(String prjnum) {
		this.prjnum = prjnum;
	}

	@Length(min = 1, max = 3, message = "招标类型长度必须介于 1 和 3 之间")
	public String getTenderclassnum() {
		return tenderclassnum;
	}

	public void setTenderclassnum(String tenderclassnum) {
		this.tenderclassnum = tenderclassnum;
	}

	@Length(min = 1, max = 3, message = "招标方式长度必须介于 1 和 3 之间")
	public String getTendertypenum() {
		return tendertypenum;
	}

	public void setTendertypenum(String tendertypenum) {
		this.tendertypenum = tendertypenum;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "中标日期不能为空")
	public Date getTenderresultdate() {
		return tenderresultdate;
	}

	public void setTenderresultdate(Date tenderresultdate) {
		this.tenderresultdate = tenderresultdate;
	}

	@NotNull(message = "中标金额不能为空")
	public Double getTendermoney() {
		return tendermoney;
	}

	public void setTendermoney(Double tendermoney) {
		this.tendermoney = tendermoney;
	}

	@Length(min = 0, max = 500, message = "建设规模长度必须介于 0 和 500 之间")
	public String getPrjsize() {
		return prjsize;
	}

	public void setPrjsize(String prjsize) {
		this.prjsize = prjsize;
	}

	@NotNull(message = "面积（平方米）不能为空")
	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	@Length(min = 1, max = 200, message = "招标代理单位名称长度必须介于 1 和 200 之间")
	public String getAgencycorpname() {
		return agencycorpname;
	}

	public void setAgencycorpname(String agencycorpname) {
		this.agencycorpname = agencycorpname;
	}

	@Length(min = 1, max = 30, message = "招标代理单位组织机构代码（社会信用代码）长度必须介于 1 和 30 之间")
	public String getAgencycorpcode() {
		return agencycorpcode;
	}

	public void setAgencycorpcode(String agencycorpcode) {
		this.agencycorpcode = agencycorpcode;
	}

	@Length(min = 1, max = 200, message = "中标单位名称长度必须介于 1 和 200 之间")
	public String getTendercorpname() {
		return tendercorpname;
	}

	public void setTendercorpname(String tendercorpname) {
		this.tendercorpname = tendercorpname;
	}

	@Length(min = 1, max = 30, message = "中标单位组织机构代码（社会信用代码）长度必须介于 1 和 30 之间")
	public String getTendercorpcode() {
		return tendercorpcode;
	}

	public void setTendercorpcode(String tendercorpcode) {
		this.tendercorpcode = tendercorpcode;
	}

	@Length(min = 0, max = 50, message = "项目经理/总监理工程师姓名长度必须介于 0 和 50 之间")
	public String getConstructorname() {
		return constructorname;
	}

	public void setConstructorname(String constructorname) {
		this.constructorname = constructorname;
	}

	@Length(min = 0, max = 50, message = "项目经理/总监理工程师电话长度必须介于 0 和 50 之间")
	public String getConstructorphone() {
		return constructorphone;
	}

	public void setConstructorphone(String constructorphone) {
		this.constructorphone = constructorphone;
	}

	@Length(min = 1, max = 1, message = "项目经理/总监理工程师证件类型长度必须介于 1 和 1 之间")
	public String getIdcardtypenum() {
		return idcardtypenum;
	}

	public void setIdcardtypenum(String idcardtypenum) {
		this.idcardtypenum = idcardtypenum;
	}

	@Length(min = 0, max = 30, message = "项目经理/总监理工程师证件号码长度必须介于 0 和 30 之间")
	public String getConstructoridcard() {
		return constructoridcard;
	}

	public void setConstructoridcard(String constructoridcard) {
		this.constructoridcard = constructoridcard;
	}

	@Length(min = 1, max = 2, message = "三合一评标法长度必须介于 1 和 2 之间")
	public String getShypbf() {
		return shypbf;
	}

	public void setShypbf(String shypbf) {
		this.shypbf = shypbf;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "记录登记时间不能为空")
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Length(min = 1, max = 1, message = "数据更新标识长度必须介于 1 和 1 之间")
	public String getUpdateflag() {
		return updateflag;
	}

	public void setUpdateflag(String updateflag) {
		this.updateflag = updateflag;
	}

	@Length(min = 1, max = 6, message = "上报地区编码长度必须介于 1 和 6 之间")
	public String getSbdqbm() {
		return sbdqbm;
	}

	public void setSbdqbm(String sbdqbm) {
		this.sbdqbm = sbdqbm;
	}

	public String getDatastate() {
		return datastate;
	}

	public void setDatastate(String datastate) {
		this.datastate = datastate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCjrqsj() {
		return cjrqsj;
	}

	public void setCjrqsj(Date cjrqsj) {
		this.cjrqsj = cjrqsj;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getXgrqsj() {
		return xgrqsj;
	}

	public void setXgrqsj(Date xgrqsj) {
		this.xgrqsj = xgrqsj;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getScrqsj() {
		return scrqsj;
	}

	public void setScrqsj(Date scrqsj) {
		this.scrqsj = scrqsj;
	}

	@Length(min = 0, max = -1, message = "returnresult长度必须介于 0 和 -1 之间")
	public String getReturnresult() {
		return returnresult;
	}

	public void setReturnresult(String returnresult) {
		this.returnresult = returnresult;
	}

	@Length(min = 0, max = 50, message = "updateuser长度必须介于 0 和 50 之间")
	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}

	public String getTenderclassnumlabel() {
		return tenderclassnumlabel;
	}

	public void setTenderclassnumlabel(String tenderclassnumlabel) {
		this.tenderclassnumlabel = tenderclassnumlabel;
	}

	public String getTendertypenumlabel() {
		return tendertypenumlabel;
	}

	public void setTendertypenumlabel(String tendertypenumlabel) {
		this.tendertypenumlabel = tendertypenumlabel;
	}

}