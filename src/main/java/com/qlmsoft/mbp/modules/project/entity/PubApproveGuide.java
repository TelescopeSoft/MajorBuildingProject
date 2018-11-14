/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import com.qlmsoft.mbp.modules.sys.entity.Office;
import org.hibernate.validator.constraints.Length;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 办事指南Entity
 * @author huangzhengyu
 * @version 2018-07-12
 */
public class PubApproveGuide extends DataEntity<PubApproveGuide> {
	
	private static final long serialVersionUID = 1L;
	private Office office;		// office_id
	private String approveItemLabel;		// 批准事项
	private String approveItemCode;		// 批准事项代码
	private String approveGuideUrl;		// 办事指南链接
	private String approveAppUrl;		// 办事应用链接
	
	public PubApproveGuide() {
		super();
	}

	public PubApproveGuide(String id){
		super(id);
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	@Length(min=0, max=200, message="批准事项长度必须介于 0 和 200 之间")
	public String getApproveItemLabel() {
		return approveItemLabel;
	}

	public void setApproveItemLabel(String approveItemLabel) {
		this.approveItemLabel = approveItemLabel;
	}
	
	@Length(min=0, max=20, message="批准事项代码长度必须介于 0 和 20 之间")
	public String getApproveItemCode() {
		return approveItemCode;
	}

	public void setApproveItemCode(String approveItemCode) {
		this.approveItemCode = approveItemCode;
	}
	
	@Length(min=0, max=200, message="办事指南链接长度必须介于 0 和 200 之间")
	public String getApproveGuideUrl() {
		return approveGuideUrl;
	}

	public void setApproveGuideUrl(String approveGuideUrl) {
		this.approveGuideUrl = approveGuideUrl;
	}
	
	@Length(min=0, max=200, message="办事应用链接长度必须介于 0 和 200 之间")
	public String getApproveAppUrl() {
		return approveAppUrl;
	}

	public void setApproveAppUrl(String approveAppUrl) {
		this.approveAppUrl = approveAppUrl;
	}
	
}