/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.entity.ApproveItemInfo;
import com.qlmsoft.mbp.modules.project.dao.ApproveItemInfoDao;

/**
 * 发改批准结果信息Service
 * @author huangzhengyu
 * @version 2018-08-09
 */
@Service
@Transactional(readOnly = true)
public class ApproveItemInfoService extends CrudService<ApproveItemInfoDao, ApproveItemInfo> {

	public ApproveItemInfo get(String id) {
		return super.get(id);
	}
	
	public List<ApproveItemInfo> findList(ApproveItemInfo approveItemInfo) {
		return super.findList(approveItemInfo);
	}
	
	public Page<ApproveItemInfo> findPage(Page<ApproveItemInfo> page, ApproveItemInfo approveItemInfo) {
		return super.findPage(page, approveItemInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(ApproveItemInfo approveItemInfo) {
		super.save(approveItemInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(ApproveItemInfo approveItemInfo) {
		super.delete(approveItemInfo);
	}
	
}