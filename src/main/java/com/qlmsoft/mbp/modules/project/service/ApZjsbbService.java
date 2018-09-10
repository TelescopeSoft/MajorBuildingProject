/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import com.qlmsoft.mbp.modules.project.bean.mohourd.ApZjsbbBean;
import com.qlmsoft.mbp.modules.project.dao.ApZjsbbDwryDao;
import com.qlmsoft.mbp.modules.project.entity.ApZjsbbDwry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.dao.ApZjsbbDao;
import com.qlmsoft.mbp.modules.project.entity.ApZjsbb;

/**
 * 质监申报Service
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Service
@Transactional(readOnly = true)
public class ApZjsbbService extends CrudService<ApZjsbbDao, ApZjsbb> {

	@Autowired
	private ApZjsbbDwryDao dwryDao;

	public ApZjsbb get(String id) {
		return super.get(id);
	}
	
	public List<ApZjsbb> findList(ApZjsbb apZjsbb) {
		return super.findList(apZjsbb);
	}
	
	public List<ApZjsbb> findListByProjectPkid(String pkid) {
		return this.dao.findListByProjectPkid(pkid);
	}
	
	public Page<ApZjsbb> findPage(Page<ApZjsbb> page, ApZjsbb apZjsbb) {
		return super.findPage(page, apZjsbb);
	}
	
	@Transactional(readOnly = false)
	public void save(ApZjsbb apZjsbb) {
		super.save(apZjsbb);
	}
	
	@Transactional(readOnly = false)
	public void delete(ApZjsbb apZjsbb) {
		super.delete(apZjsbb);
	}

    public void checkDuplicatedAndSave(ApZjsbbBean bean) {
		ApZjsbb ajsbb = bean.getAjsbb();

		ApZjsbb existed = this.dao.getByCondition(ajsbb);
		if (existed == null) {
			super.save(ajsbb);
		}
		List<ApZjsbbDwry> dwryList = bean.getDwryList();

		if(dwryList != null){
			for(ApZjsbbDwry item: dwryList){
				ApZjsbbDwry ex = this.dwryDao.getByCondition(item);
				if(ex == null){
					this.dwryDao.insert(item);
				}
			}
		}
    }
}