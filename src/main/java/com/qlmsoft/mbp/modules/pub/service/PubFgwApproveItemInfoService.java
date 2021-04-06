/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.pub.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.pub.entity.PubFgwApproveItemInfo;
import com.qlmsoft.mbp.modules.pub.dao.PubFgwApproveItemInfoDao;

/**
 * 公示项目批准结果信息Service
 * @author huanghzengu
 * @version 2020-11-11
 */
@Service
@Transactional(readOnly = true)
public class PubFgwApproveItemInfoService extends CrudService<PubFgwApproveItemInfoDao, PubFgwApproveItemInfo> {

	public PubFgwApproveItemInfo get(String id) {
		return super.get(id);
	}
	
	public List<PubFgwApproveItemInfo> findList(PubFgwApproveItemInfo pubFgwApproveItemInfo) {
		return super.findList(pubFgwApproveItemInfo);
	}
	
	public Page<PubFgwApproveItemInfo> findPage(Page<PubFgwApproveItemInfo> page, PubFgwApproveItemInfo pubFgwApproveItemInfo) {
		return super.findPage(page, pubFgwApproveItemInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(PubFgwApproveItemInfo pubFgwApproveItemInfo) {
		super.save(pubFgwApproveItemInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(PubFgwApproveItemInfo pubFgwApproveItemInfo) {
		super.delete(pubFgwApproveItemInfo);
	}
	
}