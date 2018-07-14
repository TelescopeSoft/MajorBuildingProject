/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.entity.ContractRecord;
import com.qlmsoft.mbp.modules.project.dao.ContractRecordDao;

/**
 * 合同备案Service
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Service
@Transactional(readOnly = true)
public class ContractRecordService extends CrudService<ContractRecordDao, ContractRecord> {

	public ContractRecord get(String id) {
		return super.get(id);
	}
	
	public List<ContractRecord> findList(ContractRecord contractRecord) {
		return super.findList(contractRecord);
	}
	
	public List<ContractRecord> findListByProjectPkid(String pkid) {
		return this.dao.findListByProjectPkid(pkid);
	}
	
	public Page<ContractRecord> findPage(Page<ContractRecord> page, ContractRecord contractRecord) {
		return super.findPage(page, contractRecord);
	}
	
	@Transactional(readOnly = false)
	public void save(ContractRecord contractRecord) {
		super.save(contractRecord);
	}
	
	@Transactional(readOnly = false)
	public void delete(ContractRecord contractRecord) {
		super.delete(contractRecord);
	}
	
}