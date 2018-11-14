/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import com.qlmsoft.mbp.modules.project.entity.PubApproveResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.entity.Expropriation;
import com.qlmsoft.mbp.modules.project.dao.ExpropriationDao;

/**
 * 征地信息Service
 * @author huangzhengyu
 * @version 2018-07-24
 */
@Service
@Transactional(readOnly = true)
public class ExpropriationService extends CrudService<ExpropriationDao, Expropriation> {

	public Expropriation get(String id) {
		return super.get(id);
	}
	
	public List<Expropriation> findList(Expropriation expropriation) {
		return super.findList(expropriation);
	}
	
	public Page<Expropriation> findPage(Page<Expropriation> page, Expropriation expropriation) {
		return super.findPage(page, expropriation);
	}
	
	@Transactional(readOnly = false)
	public void save(Expropriation expropriation) {
		super.save(expropriation);
	}

	@Transactional(readOnly = false)
	public void checkDuplicatedAndSave(Expropriation expropriation) {
		Expropriation existed = this.dao.getByCondition(expropriation);
		if (existed == null) {
			super.save(expropriation);
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(Expropriation expropriation) {
		super.delete(expropriation);
	}
	
}