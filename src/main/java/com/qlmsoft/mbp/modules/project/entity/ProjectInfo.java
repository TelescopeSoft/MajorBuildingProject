/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 项目表Entity
 * @author huangzhengyu
 * @version 2018-07-10
 */
public class ProjectInfo extends DataEntity<ProjectInfo> {

	private static final long serialVersionUID = 1L;
	private String pkid; // pkid
	private String prjnum; // prjnum
	private String prjinnernum; // prjinnernum
	private String prjname; // prjname
	private String prjtypenum; // prjtypenum
	private String buildcorpname; // buildcorpname
	private String buildcorpcode; // buildcorpcode
	private String provincenum; // provincenum
	private String citynum; // citynum
	private String countynum; // countynum
	private String prjapprovalnum; // prjapprovalnum
	private String prjapprovallevelnum; // prjapprovallevelnum
	private String buldplannum; // buldplannum
	private String projectplannum; // projectplannum
	private String allinvest; // allinvest
	private String allarea; // allarea
	private String prjsize; // prjsize
	private String prjpropertynum; // prjpropertynum
	private String prjfunctionnum; // prjfunctionnum
	private Date bdate; // bdate
	private Date edate; // edate
	private Date createdate; // createdate
	private String updateflag; // updateflag
	private String sbdqbm; // sbdqbm
	private String datastate; // datastate
	private Date cjrqsj; // cjrqsj
	private Date xgrqsj; // xgrqsj
	private Date scrqsj; // scrqsj
	private String returnresult; // returnresult
	private String jd; // jd
	private String wd; // wd
	private String issgbz; // issgbz
	private String updateuser; // updateuser

	private String majorFlag; // majorFlag

	public ProjectInfo() {
		super();
	}

	public ProjectInfo(String id) {
		super(id);
	}

	@Length(min = 1, max = 50, message = "pkid长度必须介于 1 和 50 之间")
	public String getPkid() {
		return pkid;
	}

	public void setPkid(String pkid) {
		this.pkid = pkid;
	}

	@Length(min = 1, max = 20, message = "prjnum长度必须介于 1 和 20 之间")
	public String getPrjnum() {
		return prjnum;
	}

	public void setPrjnum(String prjnum) {
		this.prjnum = prjnum;
	}

	@Length(min = 1, max = 50, message = "prjinnernum长度必须介于 1 和 50 之间")
	public String getPrjinnernum() {
		return prjinnernum;
	}

	public void setPrjinnernum(String prjinnernum) {
		this.prjinnernum = prjinnernum;
	}

	@Length(min = 1, max = 300, message = "prjname长度必须介于 1 和 300 之间")
	public String getPrjname() {
		return prjname;
	}

	public void setPrjname(String prjname) {
		this.prjname = prjname;
	}

	@Length(min = 1, max = 2, message = "prjtypenum长度必须介于 1 和 2 之间")
	public String getPrjtypenum() {
		return prjtypenum;
	}

	public void setPrjtypenum(String prjtypenum) {
		this.prjtypenum = prjtypenum;
	}

	@Length(min = 1, max = 200, message = "buildcorpname长度必须介于 1 和 200 之间")
	public String getBuildcorpname() {
		return buildcorpname;
	}

	public void setBuildcorpname(String buildcorpname) {
		this.buildcorpname = buildcorpname;
	}

	@Length(min = 1, max = 18, message = "buildcorpcode长度必须介于 1 和 18 之间")
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

	@Length(min = 0, max = 200, message = "prjapprovalnum长度必须介于 0 和 200 之间")
	public String getPrjapprovalnum() {
		return prjapprovalnum;
	}

	public void setPrjapprovalnum(String prjapprovalnum) {
		this.prjapprovalnum = prjapprovalnum;
	}

	@Length(min = 0, max = 3, message = "prjapprovallevelnum长度必须介于 0 和 3 之间")
	public String getPrjapprovallevelnum() {
		return prjapprovallevelnum;
	}

	public void setPrjapprovallevelnum(String prjapprovallevelnum) {
		this.prjapprovallevelnum = prjapprovallevelnum;
	}

	@Length(min = 0, max = 100, message = "buldplannum长度必须介于 0 和 100 之间")
	public String getBuldplannum() {
		return buldplannum;
	}

	public void setBuldplannum(String buldplannum) {
		this.buldplannum = buldplannum;
	}

	@Length(min = 0, max = 100, message = "projectplannum长度必须介于 0 和 100 之间")
	public String getProjectplannum() {
		return projectplannum;
	}

	public void setProjectplannum(String projectplannum) {
		this.projectplannum = projectplannum;
	}

	public String getAllinvest() {
		return allinvest;
	}

	public void setAllinvest(String allinvest) {
		this.allinvest = allinvest;
	}

	public String getAllarea() {
		return allarea;
	}

	public void setAllarea(String allarea) {
		this.allarea = allarea;
	}

	@Length(min = 0, max = 500, message = "prjsize长度必须介于 0 和 500 之间")
	public String getPrjsize() {
		return prjsize;
	}

	public void setPrjsize(String prjsize) {
		this.prjsize = prjsize;
	}

	@Length(min = 1, max = 3, message = "prjpropertynum长度必须介于 1 和 3 之间")
	public String getPrjpropertynum() {
		return prjpropertynum;
	}

	public void setPrjpropertynum(String prjpropertynum) {
		this.prjpropertynum = prjpropertynum;
	}

	@Length(min = 1, max = 3, message = "prjfunctionnum长度必须介于 1 和 3 之间")
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

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "createdate不能为空")
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Length(min = 1, max = 1, message = "updateflag长度必须介于 1 和 1 之间")
	public String getUpdateflag() {
		return updateflag;
	}

	public void setUpdateflag(String updateflag) {
		this.updateflag = updateflag;
	}

	@Length(min = 1, max = 6, message = "sbdqbm长度必须介于 1 和 6 之间")
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

	public String getJd() {
		return jd;
	}

	public void setJd(String jd) {
		this.jd = jd;
	}

	public String getWd() {
		return wd;
	}

	public void setWd(String wd) {
		this.wd = wd;
	}

	public String getIssgbz() {
		return issgbz;
	}

	public void setIssgbz(String issgbz) {
		this.issgbz = issgbz;
	}

	@Length(min = 0, max = 50, message = "updateuser长度必须介于 0 和 50 之间")
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

}