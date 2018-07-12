/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.entity.PubApproveGuide;
import com.qlmsoft.mbp.modules.project.dao.PubApproveGuideDao;

/**
 * 办事指南Service
 * @author huangzhengyu
 * @version 2018-07-12
 */
@Service
@Transactional(readOnly = true)
public class PubApproveGuideService extends CrudService<PubApproveGuideDao, PubApproveGuide> {

	public PubApproveGuide get(String id) {
		return super.get(id);
	}
	
	public List<PubApproveGuide> findList(PubApproveGuide pubApproveGuide) {
		return super.findList(pubApproveGuide);
	}
	
	public Page<PubApproveGuide> findPage(Page<PubApproveGuide> page, PubApproveGuide pubApproveGuide) {
		return super.findPage(page, pubApproveGuide);
	}
	
	@Transactional(readOnly = false)
	public void save(PubApproveGuide pubApproveGuide) {
		super.save(pubApproveGuide);
	}
	
	@Transactional(readOnly = false)
	public void delete(PubApproveGuide pubApproveGuide) {
		super.delete(pubApproveGuide);
	}
	
}