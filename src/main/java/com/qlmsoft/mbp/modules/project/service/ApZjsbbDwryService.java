/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.entity.ApZjsbbDwry;
import com.qlmsoft.mbp.modules.project.dao.ApZjsbbDwryDao;

/**
 * 质量报监单位人员Service
 * @author huangzhengyu
 * @version 2018-07-15
 */
@Service
@Transactional(readOnly = true)
public class ApZjsbbDwryService extends CrudService<ApZjsbbDwryDao, ApZjsbbDwry> {

	public ApZjsbbDwry get(String id) {
		return super.get(id);
	}
	
	public List<ApZjsbbDwry> findList(ApZjsbbDwry apZjsbbDwry) {
		return super.findList(apZjsbbDwry);
	}
	
	public Page<ApZjsbbDwry> findPage(Page<ApZjsbbDwry> page, ApZjsbbDwry apZjsbbDwry) {
		return super.findPage(page, apZjsbbDwry);
	}
	
	@Transactional(readOnly = false)
	public void save(ApZjsbbDwry apZjsbbDwry) {
		super.save(apZjsbbDwry);
	}
	
	@Transactional(readOnly = false)
	public void delete(ApZjsbbDwry apZjsbbDwry) {
		super.delete(apZjsbbDwry);
	}
	
}