/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import org.hibernate.validator.constraints.Length;
import java.util.List;
import com.google.common.collect.Lists;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 施工期环境保护措施Entity
 * @author huang.zhengyu
 * @version 2018-08-20
 */
public class EnvironmentProtection extends DataEntity<EnvironmentProtection> {
	
	private static final long serialVersionUID = 1L;
	private String prjCode;		// 发改项目代码
	private Integer closeFlag;		// 设置施工现场封闭围挡
	private Integer washFlag;		// 设置冲洗设施、道路硬化等扬尘措施
	private String displayFlag;		// display_flag
	private List<EnvironmentProtectionRectify> environmentProtectionRectifyList = Lists.newArrayList();		// 子表列表

	private String projectCode;
	private String projectName;
	private String totalMoney;

	public EnvironmentProtection() {
		super();
	}

	public EnvironmentProtection(String id){
		super(id);
	}

	@Length(min=0, max=64, message="发改项目代码长度必须介于 0 和 64 之间")
	public String getPrjCode() {
		return prjCode;
	}

	public void setPrjCode(String prjCode) {
		this.prjCode = prjCode;
	}
	
	public Integer getCloseFlag() {
		return closeFlag;
	}

	public void setCloseFlag(Integer closeFlag) {
		this.closeFlag = closeFlag;
	}
	
	public Integer getWashFlag() {
		return washFlag;
	}

	public void setWashFlag(Integer washFlag) {
		this.washFlag = washFlag;
	}
	
	@Length(min=0, max=1, message="display_flag长度必须介于 0 和 1 之间")
	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	public List<EnvironmentProtectionRectify> getEnvironmentProtectionRectifyList() {
		return environmentProtectionRectifyList;
	}

	public void setEnvironmentProtectionRectifyList(List<EnvironmentProtectionRectify> environmentProtectionRectifyList) {
		this.environmentProtectionRectifyList = environmentProtectionRectifyList;
	}
}