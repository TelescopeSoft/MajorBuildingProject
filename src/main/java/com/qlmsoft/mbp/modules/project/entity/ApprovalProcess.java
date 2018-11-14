/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 发改审批事项办理详细信息Entity
 * @author huangzhengyu
 * @version 2018-08-08
 */
public class ApprovalProcess extends DataEntity<ApprovalProcess> {
	
	private static final long serialVersionUID = 1L;
	private String approvalProcessid;		// 办理详细信息ID
	private String projectCode;		// 项目代码
	private String approvalItemid;		// 项目审批事项ID
	private String handleDeptName;		// 办理处（科）室
	private String handleState;		// 办理状态
	private String handleOpinion;		// 办理意见
	private Date handleDate;		// 办理时间
	private Date exchangeTime;		// exchange_time
	private String validityFlag;		// 有效标识
	private String nodeCode;		// node_code
	
	public ApprovalProcess() {
		super();
	}

	public ApprovalProcess(String id){
		super(id);
	}

	@Length(min=1, max=50, message="办理详细信息ID长度必须介于 1 和 50 之间")
	public String getApprovalProcessid() {
		return approvalProcessid;
	}

	public void setApprovalProcessid(String approvalProcessid) {
		this.approvalProcessid = approvalProcessid;
	}
	
	@Length(min=1, max=32, message="项目代码长度必须介于 1 和 32 之间")
	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	@Length(min=1, max=50, message="项目审批事项ID长度必须介于 1 和 50 之间")
	public String getApprovalItemid() {
		return approvalItemid;
	}

	public void setApprovalItemid(String approvalItemid) {
		this.approvalItemid = approvalItemid;
	}
	
	@Length(min=0, max=256, message="办理处（科）室长度必须介于 0 和 256 之间")
	public String getHandleDeptName() {
		return handleDeptName;
	}

	public void setHandleDeptName(String handleDeptName) {
		this.handleDeptName = handleDeptName;
	}
	
	@Length(min=1, max=6, message="办理状态长度必须介于 1 和 6 之间")
	public String getHandleState() {
		return handleState;
	}

	public void setHandleState(String handleState) {
		this.handleState = handleState;
	}
	
	@Length(min=0, max=1024, message="办理意见长度必须介于 0 和 1024 之间")
	public String getHandleOpinion() {
		return handleOpinion;
	}

	public void setHandleOpinion(String handleOpinion) {
		this.handleOpinion = handleOpinion;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="办理时间不能为空")
	public Date getHandleDate() {
		return handleDate;
	}

	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="exchange_time不能为空")
	public Date getExchangeTime() {
		return exchangeTime;
	}

	public void setExchangeTime(Date exchangeTime) {
		this.exchangeTime = exchangeTime;
	}
	
	@Length(min=1, max=2, message="有效标识长度必须介于 1 和 2 之间")
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
	
}