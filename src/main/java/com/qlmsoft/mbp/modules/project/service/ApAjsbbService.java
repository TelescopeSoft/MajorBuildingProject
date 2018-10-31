/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import com.qlmsoft.mbp.modules.project.bean.mohourd.ApAjsbbBean;
import com.qlmsoft.mbp.modules.project.dao.ApAjsbbHjssjdDao;
import com.qlmsoft.mbp.modules.project.entity.ApAjsbbHjssjd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.dao.ApAjsbbDao;
import com.qlmsoft.mbp.modules.project.entity.ApAjsbb;

/**
 * 安监申报Service
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Service
@Transactional(readOnly = true)
public class ApAjsbbService extends CrudService<ApAjsbbDao, ApAjsbb> {

	@Autowired
	private ApAjsbbHjssjdDao hjssjdDao;

	public ApAjsbb get(String id) {
		return super.get(id);
	}
	
	public List<ApAjsbb> findList(ApAjsbb apAjsbb) {
		return super.findList(apAjsbb);
	}
	
	public List<ApAjsbb> findListByProjectPkid(String pkid) {
		return this.dao.findListByProjectPkid(pkid);
	}
	
	public Page<ApAjsbb> findPage(Page<ApAjsbb> page, ApAjsbb apAjsbb) {
		return super.findPage(page, apAjsbb);
	}
	
	@Transactional(readOnly = false)
	public void save(ApAjsbb apAjsbb) {
		super.save(apAjsbb);
	}
	
	@Transactional(readOnly = false)
	public void delete(ApAjsbb apAjsbb) {
		super.delete(apAjsbb);
	}

    public void checkDuplicatedAndSave(ApAjsbbBean bean) {

		ApAjsbb ajsbb = bean.getAjsbb();

		ApAjsbb existed = this.dao.getByCondition(ajsbb);
		if (existed == null) {
			super.save(ajsbb);
		}else {
			this.dao.update(ajsbb);
		}
		List<ApAjsbbHjssjd> hjssjdList = bean.getHjssjdList();

		if(hjssjdList != null){
			for(ApAjsbbHjssjd item: hjssjdList){
				ApAjsbbHjssjd ex = this.hjssjdDao.getByCondition(item);
				if(ex == null){
					this.hjssjdDao.insert(item);
				}
			}
		}

    }
}