/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import com.qlmsoft.mbp.common.persistence.MyDataEntity;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 征地信息Entity
 * @author huangzhengyu
 * @version 2018-07-24
 */
public class Expropriation extends MyDataEntity<Expropriation> {
	
	private static final long serialVersionUID = 1L;
	private String prjCode;		// 项目代码
	private String prjName;		// 项目名称
	private String countyNum;		// 区划编码
	private String approveDept;		// 审批部门
	private String address;		// 项目位置
	private String town;		// 所属镇
	private String village;		// 所属村
	private String approveNum;		// 批复文号
	private Date approveDate;		// 批准日期
	private String lcid;		// lcid
	private String displayFlag;		// display_flag
	
	public Expropriation() {
		super();
	}

	public Expropriation(String id){
		super(id);
	}

	@Length(min=0, max=64, message="项目代码长度必须介于 0 和 64 之间")
	public String getPrjCode() {
		return prjCode;
	}

	public void setPrjCode(String prjCode) {
		this.prjCode = prjCode;
	}
	
	@Length(min=0, max=200, message="项目名称长度必须介于 0 和 200 之间")
	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	
	@Length(min=0, max=20, message="区划编码长度必须介于 0 和 20 之间")
	public String getCountyNum() {
		return countyNum;
	}

	public void setCountyNum(String countyNum) {
		this.countyNum = countyNum;
	}
	
	@Length(min=0, max=100, message="审批部门长度必须介于 0 和 100 之间")
	public String getApproveDept() {
		return approveDept;
	}

	public void setApproveDept(String approveDept) {
		this.approveDept = approveDept;
	}
	
	@Length(min=0, max=200, message="项目位置长度必须介于 0 和 200 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=200, message="所属镇长度必须介于 0 和 200 之间")
	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	@Length(min=0, max=200, message="所属村长度必须介于 0 和 200 之间")
	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}
	
	@Length(min=0, max=200, message="批复文号长度必须介于 0 和 200 之间")
	public String getApproveNum() {
		return approveNum;
	}

	public void setApproveNum(String approveNum) {
		this.approveNum = approveNum;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	
	@Length(min=0, max=64, message="lcid长度必须介于 0 和 64 之间")
	public String getLcid() {
		return lcid;
	}

	public void setLcid(String lcid) {
		this.lcid = lcid;
	}
	
	@Length(min=0, max=1, message="display_flag长度必须介于 0 和 1 之间")
	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}
	
}