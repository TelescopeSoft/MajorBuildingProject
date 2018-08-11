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
 * 发改批准结果信息Entity
 * @author huangzhengyu
 * @version 2018-08-09
 */
public class ApproveItemInfo extends DataEntity<ApproveItemInfo> {
	
	private static final long serialVersionUID = 1L;
	private String approvalItemid;		// 审批事项ID
	private String projectCode;		// 项目代码
	private String itemCode;		// 审批事项编码
	private String currentState;		// 当前办理状态
	private String currentStateLabel; //当前办理状态Label
	private Date dealTime;		// 变更为当前状态的时间
	private Date planFinishDate;		// 按期办结时间
	private Date exchangeTime;		// exchange_time
	private String validityFlag;		// validity_flag
	private String nodeCode;		// node_code
	private String relItemFlag;		// rel_item_flag
	private String deptCode;		// dept_code
	private String divisionCode;		// division_code
	private String centralApprovalItemid;		// central_approval_itemid
	private String relCentralItemCode;		// rel_central_item_code
	private String relDeptCode;		// rel_dept_code

	private String projectName;
	private String approvalNum;
	private String itemName;
	private String deptName;
	
	public ApproveItemInfo() {
		super();
	}

	public ApproveItemInfo(String id){
		super(id);
	}

	@Length(min=1, max=50, message="审批事项ID长度必须介于 1 和 50 之间")
	public String getApprovalItemid() {
		return approvalItemid;
	}

	public void setApprovalItemid(String approvalItemid) {
		this.approvalItemid = approvalItemid;
	}
	
	@Length(min=1, max=32, message="项目代码长度必须介于 1 和 32 之间")
	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	@Length(min=0, max=50, message="审批事项编码长度必须介于 0 和 50 之间")
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	@Length(min=0, max=6, message="当前办理状态长度必须介于 0 和 6 之间")
	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPlanFinishDate() {
		return planFinishDate;
	}

	public void setPlanFinishDate(Date planFinishDate) {
		this.planFinishDate = planFinishDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="exchange_time不能为空")
	public Date getExchangeTime() {
		return exchangeTime;
	}

	public void setExchangeTime(Date exchangeTime) {
		this.exchangeTime = exchangeTime;
	}
	
	@Length(min=1, max=2, message="validity_flag长度必须介于 1 和 2 之间")
	public String getValidityFlag() {
		return validityFlag;
	}

	public void setValidityFlag(String validityFlag) {
		this.validityFlag = validityFlag;
	}
	
	@Length(min=0, max=6, message="node_code长度必须介于 0 和 6 之间")
	public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}
	
	@Length(min=0, max=2, message="rel_item_flag长度必须介于 0 和 2 之间")
	public String getRelItemFlag() {
		return relItemFlag;
	}

	public void setRelItemFlag(String relItemFlag) {
		this.relItemFlag = relItemFlag;
	}
	
	@Length(min=0, max=50, message="dept_code长度必须介于 0 和 50 之间")
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	
	@Length(min=0, max=16, message="division_code长度必须介于 0 和 16 之间")
	public String getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	
	@Length(min=0, max=50, message="central_approval_itemid长度必须介于 0 和 50 之间")
	public String getCentralApprovalItemid() {
		return centralApprovalItemid;
	}

	public void setCentralApprovalItemid(String centralApprovalItemid) {
		this.centralApprovalItemid = centralApprovalItemid;
	}
	
	@Length(min=0, max=50, message="rel_central_item_code长度必须介于 0 和 50 之间")
	public String getRelCentralItemCode() {
		return relCentralItemCode;
	}

	public void setRelCentralItemCode(String relCentralItemCode) {
		this.relCentralItemCode = relCentralItemCode;
	}
	
	@Length(min=0, max=50, message="rel_dept_code长度必须介于 0 和 50 之间")
	public String getRelDeptCode() {
		return relDeptCode;
	}

	public void setRelDeptCode(String relDeptCode) {
		this.relDeptCode = relDeptCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getApprovalNum() {
		return approvalNum;
	}

	public void setApprovalNum(String approvalNum) {
		this.approvalNum = approvalNum;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getCurrentStateLabel() {
		return currentStateLabel;
	}

	public void setCurrentStateLabel(String currentStateLabel) {
		this.currentStateLabel = currentStateLabel;
	}
}