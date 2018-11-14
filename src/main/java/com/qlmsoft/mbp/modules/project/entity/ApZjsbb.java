/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import com.qlmsoft.mbp.common.persistence.ProjectDataEntity;
import com.qlmsoft.mbp.common.utils.JaxbDateAdapter;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 质监申报Entity
 * 
 * @author huangzhengyu
 * @version 2018-07-14
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ApZjsbb extends ProjectDataEntity<ApZjsbb> {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "uuid")
	private String uuid; // 质监申报表编号

	@XmlElement(name = "xmmc")
	private String xmmc; // 质监项目名称

	@XmlElement(name = "PrjNum")
	private String prjnum; // 项目编号

	@XmlElement(name = "PrjName")
	private String prjname; // 立项项目名称

	@XmlElement(name = "gcdz")
	private String gcdz; // 工程地址
	@XmlElement(name = "Zjjgmc")
	private String zjjgmc; // 质量监督机构名称

	@XmlElement(name = "ZjCorpCode")
	private String zjcorpcode; // 质量监督机构组织机构代码
	@XmlElement(name = "PrjSize")
	private String prjsize; // 建设规模
	@XmlElement(name = "EconCorpName")
	private String econcorpname; // 建设单位名称

	@XmlElement(name = "EconCorpCode")
	private String econcorpcode; // 建设单位组织机构代码

	@XmlElement(name = "PrjApprovalNum")
	private String prjapprovalnum; // 立项批准文号

	@XmlElement(name = "BuldPlanNum")
	private String buldplannum; // 建设用地规划许可证号

	@XmlElement(name = "ProjectPlanNum")
	private String projectplannum; // 建设工程规划许可证号

	@XmlElement(name = "CityNum")
	private String citynum; // 所在市州

	@XmlElement(name = "CountyNum")
	private String countynum; // 所在县区

	@XmlElement(name = "PrjTypeNum")
	private String prjtypenum; // 项目分类

	@XmlElement(name = "PrjFunctionNum")
	private String prjfunctionnum; // 工程用途

	@XmlElement(name = "sbr")
	private String sbr; // 申办人

	@XmlElement(name = "sbryddh")
	private String sbryddh; // 申办人移动电话

	@XmlElement(name = "CreateDate")
	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	private Date createdate; // 记录登记日期
	private String sfzps; // 是否是装配式

	@XmlElement(name = "UpdateFlag")
	private String updateflag; // updateflag

	@XmlElement(name = "FetchDate")
	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	private Date fetchdate; // fetchdate

	@XmlElement(name = "UpdateTime")
	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	private Date updatetime; // updatetime

	@XmlElement(name = "UpdateUser")
	private String updateuser; // updateuser

	@XmlElement(name = "updateDate")
	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	private Date updatedate; // 申报提交时间

	@XmlElement(name = "Status")
	private String status; // status
	private String jsxz; // 建设性质
	private String jsxzLabel = ""; // 建设性质
	private String tzlx = ""; // 投资类型

	public ApZjsbb() {
		super();
	}

	public ApZjsbb(String id) {
		super(id);
	}

	@Length(min = 1, max = 50, message = "质监申报表编号长度必须介于 1 和 50 之间")
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Length(min = 1, max = 500, message = "质监项目名称长度必须介于 1 和 500 之间")
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	@Length(min = 1, max = 20, message = "项目编号长度必须介于 1 和 20 之间")
	public String getPrjnum() {
		return prjnum;
	}

	public void setPrjnum(String prjnum) {
		this.prjnum = prjnum;
	}

	@Length(min = 1, max = 500, message = "立项项目名称长度必须介于 1 和 500 之间")
	public String getPrjname() {
		return prjname;
	}

	public void setPrjname(String prjname) {
		this.prjname = prjname;
	}

	@Length(min = 0, max = 255, message = "工程地址长度必须介于 0 和 255 之间")
	public String getGcdz() {
		return gcdz;
	}

	public void setGcdz(String gcdz) {
		this.gcdz = gcdz;
	}

	@Length(min = 1, max = 200, message = "质量监督机构名称长度必须介于 1 和 200 之间")
	public String getZjjgmc() {
		return zjjgmc;
	}

	public void setZjjgmc(String zjjgmc) {
		this.zjjgmc = zjjgmc;
	}

	@Length(min = 1, max = 18, message = "质量监督机构组织机构代码长度必须介于 1 和 18 之间")
	public String getZjcorpcode() {
		return zjcorpcode;
	}

	public void setZjcorpcode(String zjcorpcode) {
		this.zjcorpcode = zjcorpcode;
	}

	@Length(min = 0, max = 500, message = "建设规模长度必须介于 0 和 500 之间")
	public String getPrjsize() {
		return prjsize;
	}

	public void setPrjsize(String prjsize) {
		this.prjsize = prjsize;
	}

	@Length(min = 1, max = 200, message = "建设单位名称长度必须介于 1 和 200 之间")
	public String getEconcorpname() {
		return econcorpname;
	}

	public void setEconcorpname(String econcorpname) {
		this.econcorpname = econcorpname;
	}

	@Length(min = 1, max = 15, message = "建设单位组织机构代码长度必须介于 1 和 15 之间")
	public String getEconcorpcode() {
		return econcorpcode;
	}

	public void setEconcorpcode(String econcorpcode) {
		this.econcorpcode = econcorpcode;
	}

	@Length(min = 0, max = 255, message = "立项批准文号长度必须介于 0 和 255 之间")
	public String getPrjapprovalnum() {
		return prjapprovalnum;
	}

	public void setPrjapprovalnum(String prjapprovalnum) {
		this.prjapprovalnum = prjapprovalnum;
	}

	@Length(min = 0, max = 255, message = "建设用地规划许可证号长度必须介于 0 和 255 之间")
	public String getBuldplannum() {
		return buldplannum;
	}

	public void setBuldplannum(String buldplannum) {
		this.buldplannum = buldplannum;
	}

	@Length(min = 0, max = 255, message = "建设工程规划许可证号长度必须介于 0 和 255 之间")
	public String getProjectplannum() {
		return projectplannum;
	}

	public void setProjectplannum(String projectplannum) {
		this.projectplannum = projectplannum;
	}

	@Length(min = 1, max = 6, message = "所在市州长度必须介于 1 和 6 之间")
	public String getCitynum() {
		return citynum;
	}

	public void setCitynum(String citynum) {
		this.citynum = citynum;
	}

	@Length(min = 1, max = 6, message = "所在县区长度必须介于 1 和 6 之间")
	public String getCountynum() {
		return countynum;
	}

	public void setCountynum(String countynum) {
		this.countynum = countynum;
	}

	@Length(min = 1, max = 255, message = "项目分类长度必须介于 1 和 255 之间")
	public String getPrjtypenum() {
		return prjtypenum;
	}

	public void setPrjtypenum(String prjtypenum) {
		this.prjtypenum = prjtypenum;
	}

	@Length(min = 1, max = 10, message = "工程用途长度必须介于 1 和 10 之间")
	public String getPrjfunctionnum() {
		return prjfunctionnum;
	}

	public void setPrjfunctionnum(String prjfunctionnum) {
		this.prjfunctionnum = prjfunctionnum;
	}

	@Length(min = 1, max = 50, message = "申办人长度必须介于 1 和 50 之间")
	public String getSbr() {
		return sbr;
	}

	public void setSbr(String sbr) {
		this.sbr = sbr;
	}

	@Length(min = 1, max = 15, message = "申办人移动电话长度必须介于 1 和 15 之间")
	public String getSbryddh() {
		return sbryddh;
	}

	public void setSbryddh(String sbryddh) {
		this.sbryddh = sbryddh;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "记录登记日期不能为空")
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Length(min = 0, max = 50, message = "是否是装配式长度必须介于 0 和 50 之间")
	public String getSfzps() {
		return sfzps;
	}

	public void setSfzps(String sfzps) {
		this.sfzps = sfzps;
	}

	@Length(min = 1, max = 1, message = "updateflag长度必须介于 1 和 1 之间")
	public String getUpdateflag() {
		return updateflag;
	}

	public void setUpdateflag(String updateflag) {
		this.updateflag = updateflag;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "fetchdate不能为空")
	public Date getFetchdate() {
		return fetchdate;
	}

	public void setFetchdate(Date fetchdate) {
		this.fetchdate = fetchdate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "updatetime不能为空")
	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	@Length(min = 0, max = 50, message = "updateuser长度必须介于 0 和 50 之间")
	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Length(min = 0, max = 10, message = "建设性质长度必须介于 0 和 10 之间")
	public String getJsxz() {
		return jsxz;
	}

	public void setJsxz(String jsxz) {
		this.jsxz = jsxz;
	}

	@Length(min = 0, max = 30, message = "投资类型长度必须介于 0 和 30 之间")
	public String getTzlx() {
		return tzlx;
	}

	public void setTzlx(String tzlx) {
		this.tzlx = tzlx;
	}

	public String getJsxzLabel() {
		return jsxzLabel;
	}

	public void setJsxzLabel(String jsxzLabel) {
		this.jsxzLabel = jsxzLabel;
	}

}