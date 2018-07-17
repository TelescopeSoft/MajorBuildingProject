/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.entity.PubApproveResult;
import com.qlmsoft.mbp.modules.project.dao.PubApproveResultDao;

/**
 * 批准结果Service
 * 
 * @author huangzhengyu
 * @version 2018-07-13
 */
@Service
@Transactional(readOnly = true)
public class PubApproveResultService extends
		CrudService<PubApproveResultDao, PubApproveResult> {

	public PubApproveResult get(String id) {
		return super.get(id);
	}

	public PubApproveResult getByCondition(PubApproveResult entity) {
		return this.dao.getByCondition(entity);
	}

	public List<PubApproveResult> findList(PubApproveResult pubApproveResult) {
		return super.findList(pubApproveResult);
	}

	public Page<PubApproveResult> findPage(Page<PubApproveResult> page,
			PubApproveResult pubApproveResult) {
		return super.findPage(page, pubApproveResult);
	}

	public List<PubApproveResult> findListByPkid(String pkid) {
		return this.dao.findListByPkid(pkid);
	}

	@Transactional(readOnly = false)
	public void save(PubApproveResult pubApproveResult) {
		super.save(pubApproveResult);
	}

	@Transactional(readOnly = false)
	public void delete(PubApproveResult pubApproveResult) {
		super.delete(pubApproveResult);
	}

	@Transactional(readOnly = false)
	public void checkDuplicatedAndSave(PubApproveResult pubApproveResult) {
		PubApproveResult existed = this.dao.getByCondition(pubApproveResult);
		if (existed == null) {
			super.save(pubApproveResult);
		}
	}

}