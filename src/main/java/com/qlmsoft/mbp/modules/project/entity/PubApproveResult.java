/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 批准结果Entity
 * 
 * @author huangzhengyu
 * @version 2018-07-13
 */
public class PubApproveResult extends DataEntity<PubApproveResult> {

	private static final long serialVersionUID = 1L;
	private String prjCode; // 项目代码
	private String prjName; // 项目名称
	private String prjNum; // 省住建厅统一项目编号

	private String approveDeptCode; // 审批部门代码
	private String approveDept; // 审批部门

	private String approveItemLabel; // approve_item_label
	private String approveItemCode; // approve_item_code
	private String approveSubitemLabel; // approve_subitem_label
	private String approveSubitemCode; // approve_subitem_code
	private String approveResult; // 审批结果
	private String approveNum; // 批复文号
	private Date approveDate; // 审批日期


	private String approveNumType; //批复文号类型
	private String approveNumYear; //批复文号年份
	private String approveNumNum; //批复文号编号

	private String county;

	private String displayFlag; // 显示标识

	private Date startDate;
	private Date endDate;

	public PubApproveResult() {
		super();
	}

	public PubApproveResult(String id) {
		super(id);
	}

	@Length(min = 0, max = 64, message = "prj_code长度必须介于 0 和 64 之间")
	public String getPrjCode() {
		return prjCode;
	}

	public void setPrjCode(String prjCode) {
		this.prjCode = prjCode;
	}

	@Length(min = 0, max = 200, message = "prj_name长度必须介于 0 和 200 之间")
	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	@Length(min = 0, max = 64, message = "prj_num长度必须介于 0 和 64 之间")
	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	@Length(min = 0, max = 200, message = "approve_item_label长度必须介于 0 和 200 之间")
	public String getApproveItemLabel() {
		return approveItemLabel;
	}

	public void setApproveItemLabel(String approveItemLabel) {
		this.approveItemLabel = approveItemLabel;
	}

	@Length(min = 0, max = 20, message = "approve_item_code长度必须介于 0 和 20 之间")
	public String getApproveItemCode() {
		return approveItemCode;
	}

	public void setApproveItemCode(String approveItemCode) {
		this.approveItemCode = approveItemCode;
	}

	@Length(min = 0, max = 200, message = "approve_subitem_label长度必须介于 0 和 200 之间")
	public String getApproveSubitemLabel() {
		return approveSubitemLabel;
	}

	public void setApproveSubitemLabel(String approveSubitemLabel) {
		this.approveSubitemLabel = approveSubitemLabel;
	}

	@Length(min = 0, max = 20, message = "approve_subitem_code长度必须介于 0 和 20 之间")
	public String getApproveSubitemCode() {
		return approveSubitemCode;
	}

	public void setApproveSubitemCode(String approveSubitemCode) {
		this.approveSubitemCode = approveSubitemCode;
	}

	@Length(min = 0, max = 200, message = "approve_result长度必须介于 0 和 200 之间")
	public String getApproveResult() {
		return approveResult;
	}

	public void setApproveResult(String approveResult) {
		this.approveResult = approveResult;
	}

	@Length(min = 0, max = 200, message = "approve_num长度必须介于 0 和 200 之间")
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

	public String getApproveDeptCode() {
		return approveDeptCode;
	}

	public void setApproveDeptCode(String approveDeptCode) {
		this.approveDeptCode = approveDeptCode;
	}

	public String getApproveDept() {
		return approveDept;
	}

	public void setApproveDept(String approveDept) {
		this.approveDept = approveDept;
	}

	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getApproveNumType() {
		return approveNumType;
	}

	public void setApproveNumType(String approveNumType) {
		this.approveNumType = approveNumType;
	}

	public String getApproveNumYear() {
		return approveNumYear;
	}

	public void setApproveNumYear(String approveNumYear) {
		this.approveNumYear = approveNumYear;
	}

	public String getApproveNumNum() {
		return approveNumNum;
	}

	public void setApproveNumNum(String approveNumNum) {
		this.approveNumNum = approveNumNum;
	}
}