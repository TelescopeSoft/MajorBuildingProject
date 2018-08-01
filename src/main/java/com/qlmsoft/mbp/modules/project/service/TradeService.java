/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.entity.Trade;
import com.qlmsoft.mbp.modules.project.dao.TradeDao;

/**
 * 招标投标Service
 * @author huangzhengyu
 * @version 2018-07-31
 */
@Service
@Transactional(readOnly = true)
public class TradeService extends CrudService<TradeDao, Trade> {

	public Trade get(String id) {
		return super.get(id);
	}
	
	public List<Trade> findList(Trade trade) {
		return super.findList(trade);
	}
	
	public Page<Trade> findPage(Page<Trade> page, Trade trade) {
		return super.findPage(page, trade);
	}
	
	@Transactional(readOnly = false)
	public void save(Trade trade) {
		super.save(trade);
	}

	@Transactional(readOnly = false)
	public void checkDuplicatedAndSave(Trade entity) {
		Trade existed = this.dao.getByCondition(entity);
		if (existed == null) {
			super.save(entity);
		}
	}
	@Transactional(readOnly = false)
	public void updateProjectInfo(Trade trade) {
		dao.updateProjectInfo(trade);
	}

	
	@Transactional(readOnly = false)
	public void delete(Trade trade) {
		super.delete(trade);
	}
	
}