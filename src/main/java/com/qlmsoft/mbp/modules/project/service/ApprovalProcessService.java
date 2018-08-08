/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.entity.ApprovalProcess;
import com.qlmsoft.mbp.modules.project.dao.ApprovalProcessDao;

/**
 * 发改审批事项办理详细信息Service
 * @author huangzhengyu
 * @version 2018-08-08
 */
@Service
@Transactional(readOnly = true)
public class ApprovalProcessService extends CrudService<ApprovalProcessDao, ApprovalProcess> {

	public ApprovalProcess get(String id) {
		return super.get(id);
	}
	
	public List<ApprovalProcess> findList(ApprovalProcess approvalProcess) {
		return super.findList(approvalProcess);
	}
	
	public Page<ApprovalProcess> findPage(Page<ApprovalProcess> page, ApprovalProcess approvalProcess) {
		return super.findPage(page, approvalProcess);
	}
	
	@Transactional(readOnly = false)
	public void save(ApprovalProcess approvalProcess) {
		super.save(approvalProcess);
	}
	
	@Transactional(readOnly = false)
	public void delete(ApprovalProcess approvalProcess) {
		super.delete(approvalProcess);
	}
	
}