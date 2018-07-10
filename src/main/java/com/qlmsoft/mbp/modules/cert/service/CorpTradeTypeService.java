/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.cert.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.cert.dao.CorpTradeTypeDao;
import com.qlmsoft.mbp.modules.cert.entity.CorpTradeType;

/**
 * corptradetypeService
 * @author GLQ
 * @version 2018-04-24
 */
@Service
@Transactional(readOnly = true)
public class CorpTradeTypeService extends CrudService<CorpTradeTypeDao, CorpTradeType> {

	public CorpTradeType get(String id) {
		return super.get(id);
	}
	
	public List<CorpTradeType> findList(CorpTradeType corpTradeType) {
		return super.findList(corpTradeType);
	}
	
	public Page<CorpTradeType> findPage(Page<CorpTradeType> page, CorpTradeType corpTradeType) {
		return super.findPage(page, corpTradeType);
	}
	
	@Transactional(readOnly = false)
	public void save(CorpTradeType corpTradeType) {
		super.save(corpTradeType);
	}
	
	@Transactional(readOnly = false)
	public void delete(CorpTradeType corpTradeType) {
		super.delete(corpTradeType);
	}
	
}