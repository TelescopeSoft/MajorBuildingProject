/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.entity.PubAdminPenalty;
import com.qlmsoft.mbp.modules.project.dao.PubAdminPenaltyDao;

/**
 * 行政处罚Service
 * @author huangzhengyu
 * @version 2018-07-15
 */
@Service
@Transactional(readOnly = true)
public class PubAdminPenaltyService extends CrudService<PubAdminPenaltyDao, PubAdminPenalty> {

	public PubAdminPenalty get(String id) {
		return super.get(id);
	}
	
	public List<PubAdminPenalty> findList(PubAdminPenalty pubAdminPenalty) {
		return super.findList(pubAdminPenalty);
	}
	
	public Page<PubAdminPenalty> findPage(Page<PubAdminPenalty> page, PubAdminPenalty pubAdminPenalty) {
		return super.findPage(page, pubAdminPenalty);
	}


	@Transactional(readOnly = false)
	public void save(PubAdminPenalty pubAdminPenalty) {
		super.save(pubAdminPenalty);
	}

	@Transactional(readOnly = false)
	public void checkDuplicatedAndSave(PubAdminPenalty entity) {
		PubAdminPenalty existed = this.dao.getByCondition(entity);
		if (existed == null) {
			super.save(entity);
		}
	}

	@Transactional(readOnly = false)
	public void delete(PubAdminPenalty pubAdminPenalty) {
		super.delete(pubAdminPenalty);
	}
	
}