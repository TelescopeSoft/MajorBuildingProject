/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.pub.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 公示项目批准结果信息Entity
 * @author huanghzengu
 * @version 2020-11-11
 */
public class PubFgwApproveItemInfo extends DataEntity<PubFgwApproveItemInfo> {
	
	private static final long serialVersionUID = 1L;
	private String projectCode;		// project_code
	private String projectName;		// project_name
	private String itemCode;		// item_code
	private String itemName;		// item_name
	private String deptCode;		// dept_code
	private String deptName;		// dept_name
	private String currentState;		// current_state
	private String currentStateLabel;		// current_state_label
	private Date dealTime;		// deal_time
	private String approvalNum;		// approval_num
	
	public PubFgwApproveItemInfo() {
		super();
	}

	public PubFgwApproveItemInfo(String id){
		super(id);
	}

	@Length(min=1, max=32, message="project_code长度必须介于 1 和 32 之间")
	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	@Length(min=0, max=512, message="project_name长度必须介于 0 和 512 之间")
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@Length(min=0, max=50, message="item_code长度必须介于 0 和 50 之间")
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	@Length(min=0, max=512, message="item_name长度必须介于 0 和 512 之间")
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	@Length(min=0, max=50, message="dept_code长度必须介于 0 和 50 之间")
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	
	@Length(min=0, max=50, message="dept_name长度必须介于 0 和 50 之间")
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Length(min=0, max=32, message="current_state长度必须介于 0 和 32 之间")
	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	
	@Length(min=0, max=100, message="current_state_label长度必须介于 0 和 100 之间")
	public String getCurrentStateLabel() {
		return currentStateLabel;
	}

	public void setCurrentStateLabel(String currentStateLabel) {
		this.currentStateLabel = currentStateLabel;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	
	@Length(min=0, max=128, message="approval_num长度必须介于 0 和 128 之间")
	public String getApprovalNum() {
		return approvalNum;
	}

	public void setApprovalNum(String approvalNum) {
		this.approvalNum = approvalNum;
	}
	
}