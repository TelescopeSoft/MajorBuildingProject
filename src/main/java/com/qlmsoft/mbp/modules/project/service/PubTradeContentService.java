/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import com.qlmsoft.mbp.modules.project.entity.Trade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.entity.PubTradeContent;
import com.qlmsoft.mbp.modules.project.dao.PubTradeContentDao;

/**
 * 招标投标内容Service
 * @author aaron
 * @version 2018-07-31
 */
@Service
@Transactional(readOnly = true)
public class PubTradeContentService extends CrudService<PubTradeContentDao, PubTradeContent> {

	public PubTradeContent get(String id) {
		return super.get(id);
	}

	public PubTradeContent getByIndexId(String indexId) {
		PubTradeContent entity = new PubTradeContent();
		entity.setIndexid(indexId);
		return this.dao.getByCondition(entity);
	}

	public List<PubTradeContent> findList(PubTradeContent pubTradeContent) {
		return super.findList(pubTradeContent);
	}
	
	public Page<PubTradeContent> findPage(Page<PubTradeContent> page, PubTradeContent pubTradeContent) {
		return super.findPage(page, pubTradeContent);
	}
	
	@Transactional(readOnly = false)
	public void save(PubTradeContent pubTradeContent) {
		super.save(pubTradeContent);
	}

	@Transactional(readOnly = false)
	public void checkDuplicatedAndSave(PubTradeContent entity) {
		PubTradeContent existed = this.dao.getByCondition(entity);
		if (existed == null) {
			super.save(entity);
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(PubTradeContent pubTradeContent) {
		super.delete(pubTradeContent);
	}
	
}