/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.dao.TenderInfoDao;
import com.qlmsoft.mbp.modules.project.entity.TenderInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

	@Transactional(readOnly = false)
	public void checkDuplicatedAndSave(TenderInfo bean) {
		TenderInfo existed = this.dao.getByCondition(bean);
		if (existed == null) {
			super.save(bean);
		}
	}
}