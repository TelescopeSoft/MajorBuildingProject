/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.dao.TenderInfoDao;
import com.qlmsoft.mbp.modules.project.entity.TenderInfo;

/**
 * 招标投标Service
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Service
@Transactional(readOnly = true)
public class TenderInfoService extends CrudService<TenderInfoDao, TenderInfo> {

	public TenderInfo get(String id) {
		return super.get(id);
	}

	public String getByTenderInnerNum(String tenderInnerNum) {
		return this.dao.getByTenderInnerNum(tenderInnerNum);
	}
	
	public List<TenderInfo> findList(TenderInfo tenderInfo) {
		return super.findList(tenderInfo);
	}
	
	public List<TenderInfo> findListByProjectPkid(String pkid) {
		return this.dao.findListByProjectPkid(pkid);
	}
	
	public Page<TenderInfo> findPage(Page<TenderInfo> page, TenderInfo tenderInfo) {
		return super.findPage(page, tenderInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(TenderInfo tenderInfo) {
		super.save(tenderInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(TenderInfo tenderInfo) {
		super.delete(tenderInfo);
	}
	
}