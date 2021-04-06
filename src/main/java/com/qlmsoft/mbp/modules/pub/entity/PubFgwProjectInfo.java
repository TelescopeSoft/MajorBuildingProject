/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.pub.entity;

import org.hibernate.validator.constraints.Length;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 重大建设项目基本信息Entity
 * @author huangzhengyu
 * @version 2020-11-11
 */
public class PubFgwProjectInfo extends DataEntity<PubFgwProjectInfo> {
	
	private static final long serialVersionUID = 1L;
	private String projectCode;		// project_code
	private String projectName;		// project_name
	private String projectType;		// project_type
	private String projectTypeLable;		// project_type_lable
	private String catalogName;		// catalog_name
	private String enterpriseName;		// enterprise_name
	private String lerepCerttype;		// lerep_certtype
	private String lerepCertno;		// lerep_certno
	private String projectNature;		// project_nature
	private String projectNatureLabel;		// project_nature_label
	private String totalMoney;		// total_money
	private String ydmj;		// ydmj
	private String zjly;		// zjly
	private String startYear;		// start_year
	private String endYear;		// end_year
	private String addressDetail;		// address_detail
	private String scaleContent;		// scale_content
	
	public PubFgwProjectInfo() {
		super();
	}

	public PubFgwProjectInfo(String id){
		super(id);
	}

	@Length(min=1, max=32, message="project_code长度必须介于 1 和 32 之间")
	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	@Length(min=1, max=512, message="project_name长度必须介于 1 和 512 之间")
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@Length(min=0, max=6, message="project_type长度必须介于 0 和 6 之间")
	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
	@Length(min=0, max=6, message="project_type_lable长度必须介于 0 和 6 之间")
	public String getProjectTypeLable() {
		return projectTypeLable;
	}

	public void setProjectTypeLable(String projectTypeLable) {
		this.projectTypeLable = projectTypeLable;
	}
	
	@Length(min=0, max=1024, message="catalog_name长度必须介于 0 和 1024 之间")
	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	
	@Length(min=0, max=256, message="enterprise_name长度必须介于 0 和 256 之间")
	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	
	@Length(min=0, max=6, message="lerep_certtype长度必须介于 0 和 6 之间")
	public String getLerepCerttype() {
		return lerepCerttype;
	}

	public void setLerepCerttype(String lerepCerttype) {
		this.lerepCerttype = lerepCerttype;
	}
	
	@Length(min=0, max=50, message="lerep_certno长度必须介于 0 和 50 之间")
	public String getLerepCertno() {
		return lerepCertno;
	}

	public void setLerepCertno(String lerepCertno) {
		this.lerepCertno = lerepCertno;
	}
	
	@Length(min=0, max=2, message="project_nature长度必须介于 0 和 2 之间")
	public String getProjectNature() {
		return projectNature;
	}

	public void setProjectNature(String projectNature) {
		this.projectNature = projectNature;
	}
	
	@Length(min=0, max=6, message="project_nature_label长度必须介于 0 和 6 之间")
	public String getProjectNatureLabel() {
		return projectNatureLabel;
	}

	public void setProjectNatureLabel(String projectNatureLabel) {
		this.projectNatureLabel = projectNatureLabel;
	}
	
	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	public String getYdmj() {
		return ydmj;
	}

	public void setYdmj(String ydmj) {
		this.ydmj = ydmj;
	}
	
	@Length(min=0, max=12, message="zjly长度必须介于 0 和 12 之间")
	public String getZjly() {
		return zjly;
	}

	public void setZjly(String zjly) {
		this.zjly = zjly;
	}
	
	@Length(min=0, max=6, message="start_year长度必须介于 0 和 6 之间")
	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	
	@Length(min=0, max=6, message="end_year长度必须介于 0 和 6 之间")
	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	
	@Length(min=0, max=2014, message="address_detail长度必须介于 0 和 2014 之间")
	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	
	@Length(min=0, max=4000, message="scale_content长度必须介于 0 和 4000 之间")
	public String getScaleContent() {
		return scaleContent;
	}

	public void setScaleContent(String scaleContent) {
		this.scaleContent = scaleContent;
	}
	
}