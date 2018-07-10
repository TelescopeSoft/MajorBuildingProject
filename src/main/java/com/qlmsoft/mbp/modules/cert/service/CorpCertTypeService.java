/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.cert.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.cert.dao.CorpCertTypeDao;
import com.qlmsoft.mbp.modules.cert.entity.CorpCertType;

/**
 * corpcerttypeService
 * @author GLQ
 * @version 2018-04-24
 */
@Service
@Transactional(readOnly = true)
public class CorpCertTypeService extends CrudService<CorpCertTypeDao, CorpCertType> {

	public CorpCertType get(String id) {
		return super.get(id);
	}
	
	public List<CorpCertType> findList(CorpCertType corpCertType) {
		return super.findList(corpCertType);
	}
	
	public Page<CorpCertType> findPage(Page<CorpCertType> page, CorpCertType corpCertType) {
		return super.findPage(page, corpCertType);
	}
	
	@Transactional(readOnly = false)
	public void save(CorpCertType corpCertType) {
		super.save(corpCertType);
	}
	
	@Transactional(readOnly = false)
	public void delete(CorpCertType corpCertType) {
		super.delete(corpCertType);
	}
	
}