/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 项目表Entity
 * 
 * @author huangzhengyu
 * @version 2018-07-10
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectInfo extends DataEntity<ProjectInfo> {

	private static final long serialVersionUID = 1L;
	@XmlElement(name = "PKID")
	private String pkid; // pkid
	@XmlElement(name = "PrjNum")
	private String prjnum; // prjnum
	@XmlElement(name = "PrjInnerNum")
	private String prjinnernum; // prjinnernum
	@XmlElement(name = "PrjName")
	private String prjname; // prjname
	@XmlElement(name = "PrjTypeNum")
	private String prjtypenum; // prjtypenum
	@XmlElement(name = "BuildCorpName")
	private String buildcorpname; // buildcorpname
	@XmlElement(name = "BuildCorpCode")
	private String buildcorpcode; // buildcorpcode
	@XmlElement(name = "ProvinceNum")
	private String provincenum; // provincenum
	@XmlElement(name = "CityNum")
	private String citynum; // citynum
	@XmlElement(name = "CountyNum")
	private String countynum; // countynum
	@XmlElement(name = "PrjApprovalNum")
	private String prjapprovalnum; // prjapprovalnum
	@XmlElement(name = "PrjApprovalLevelNum")
	private String prjapprovallevelnum; // prjapprovallevelnum
	@XmlElement(name = "BuldPlanNum")
	private String buldplannum; // buldplannum
	@XmlElement(name = "ProjectPlanNum")
	private String projectplannum; // projectplannum
	@XmlElement(name = "AllInvest")
	private BigDecimal allinvest; // allinvest
	@XmlElement(name = "AllArea")
	private BigDecimal allarea; // allarea
	@XmlElement(name = "PrjSize")
	private String prjsize; // prjsize
	@XmlElement(name = "PrjPropertyNum")
	private String prjpropertynum; // prjpropertynum
	@XmlElement(name = "PrjFunctionNum")
	private String prjfunctionnum; // prjfunctionnum

	@XmlElement(name = "BDate")
	private Date bdate; // bdate
	@XmlElement(name = "EDate")
	private Date edate; // edate

	@XmlElement(name = "CREATEDATE")
	private Date createDate; // createdate
	@XmlElement(name = "UpdateFlag")
	private String updateflag; // updateflag
	@XmlElement(name = "sbdqbm")
	private String sbdqbm; // sbdqbm
	@XmlElement(name = "sbdqbm")
	private String datastate; // datastate
	private Date cjrqsj; // cjrqsj
	private Date xgrqsj; // xgrqsj
	private Date scrqsj; // scrqsj
	private String returnresult; // returnresult
	private BigDecimal jd; // jd
	private BigDecimal wd; // wd
	private String issgbz; // issgbz
	private String updateuser; // updateuser

	private String address;

	// 关联的项目代码-发改审批项目代码
	private String prjCode;

	private String majorFlag; // majorFlag

	private String matchPrj;

	public ProjectInfo() {
		super();
	}

	public ProjectInfo(String id) {
		super(id);
	}

	public String getPkid() {
		return pkid;
	}

	public void setPkid(String pkid) {
		this.pkid = pkid;
	}

	public String getPrjnum() {
		return prjnum;
	}

	public void setPrjnum(String prjnum) {
		this.prjnum = prjnum;
	}

	public String getPrjinnernum() {
		return prjinnernum;
	}

	public void setPrjinnernum(String prjinnernum) {
		this.prjinnernum = prjinnernum;
	}

	public String getPrjname() {
		return prjname;
	}

	public void setPrjname(String prjname) {
		this.prjname = prjname;
	}

	public String getPrjtypenum() {
		return prjtypenum;
	}

	public void setPrjtypenum(String prjtypenum) {
		this.prjtypenum = prjtypenum;
	}

	public String getBuildcorpname() {
		return buildcorpname;
	}

	public void setBuildcorpname(String buildcorpname) {
		this.buildcorpname = buildcorpname;
	}

	public String getBuildcorpcode() {
		return buildcorpcode;
	}

	public void setBuildcorpcode(String buildcorpcode) {
		this.buildcorpcode = buildcorpcode;
	}

	public String getProvincenum() {
		return provincenum;
	}

	public void setProvincenum(String provincenum) {
		this.provincenum = provincenum;
	}

	public String getCitynum() {
		return citynum;
	}

	public void setCitynum(String citynum) {
		this.citynum = citynum;
	}

	public String getCountynum() {
		return countynum;
	}

	public void setCountynum(String countynum) {
		this.countynum = countynum;
	}

	public String getPrjapprovalnum() {
		return prjapprovalnum;
	}

	public void setPrjapprovalnum(String prjapprovalnum) {
		this.prjapprovalnum = prjapprovalnum;
	}

	public String getPrjapprovallevelnum() {
		return prjapprovallevelnum;
	}

	public void setPrjapprovallevelnum(String prjapprovallevelnum) {
		this.prjapprovallevelnum = prjapprovallevelnum;
	}

	public String getBuldplannum() {
		return buldplannum;
	}

	public void setBuldplannum(String buldplannum) {
		this.buldplannum = buldplannum;
	}

	public String getProjectplannum() {
		return projectplannum;
	}

	public void setProjectplannum(String projectplannum) {
		this.projectplannum = projectplannum;
	}

	public BigDecimal getAllinvest() {
		return allinvest;
	}

	public void setAllinvest(BigDecimal allinvest) {
		this.allinvest = allinvest;
	}

	public BigDecimal getAllarea() {
		return allarea;
	}

	public void setAllarea(BigDecimal allarea) {
		this.allarea = allarea;
	}

	public String getPrjsize() {
		return prjsize;
	}

	public void setPrjsize(String prjsize) {
		this.prjsize = prjsize;
	}

	public String getPrjpropertynum() {
		return prjpropertynum;
	}

	public void setPrjpropertynum(String prjpropertynum) {
		this.prjpropertynum = prjpropertynum;
	}

	public String getPrjfunctionnum() {
		return prjfunctionnum;
	}

	public void setPrjfunctionnum(String prjfunctionnum) {
		this.prjfunctionnum = prjfunctionnum;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public String getUpdateflag() {
		return updateflag;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "createdate不能为空")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setUpdateflag(String updateflag) {
		this.updateflag = updateflag;
	}

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

	public String getReturnresult() {
		return returnresult;
	}

	public void setReturnresult(String returnresult) {
		this.returnresult = returnresult;
	}

	public BigDecimal getJd() {
		return jd;
	}

	public void setJd(BigDecimal jd) {
		this.jd = jd;
	}

	public BigDecimal getWd() {
		return wd;
	}

	public void setWd(BigDecimal wd) {
		this.wd = wd;
	}

	public String getIssgbz() {
		return issgbz;
	}

	public void setIssgbz(String issgbz) {
		this.issgbz = issgbz;
	}

	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}

	public String getMajorFlag() {
		return majorFlag;
	}

	public void setMajorFlag(String majorFlag) {
		this.majorFlag = majorFlag;
	}

	public String getPrjCode() {
		return prjCode;
	}

	public void setPrjCode(String prjCode) {
		this.prjCode = prjCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMatchPrj() {
		return matchPrj;
	}

	public void setMatchPrj(String matchPrj) {
		this.matchPrj = matchPrj;
	}


}