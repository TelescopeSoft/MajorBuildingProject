/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.entity.ApplyProjectInfo;
import com.qlmsoft.mbp.modules.project.dao.ApplyProjectInfoDao;

/**
 * 发改申报项目基本信息Service
 * @author huangzhengyu
 * @version 2018-08-08
 */
@Service
@Transactional(readOnly = true)
public class ApplyProjectInfoService extends CrudService<ApplyProjectInfoDao, ApplyProjectInfo> {

	public ApplyProjectInfo get(String id) {
		return super.get(id);
	}
	
	public List<ApplyProjectInfo> findList(ApplyProjectInfo applyProjectInfo) {
		return super.findList(applyProjectInfo);
	}
	
	public Page<ApplyProjectInfo> findPage(Page<ApplyProjectInfo> page, ApplyProjectInfo applyProjectInfo) {
		return super.findPage(page, applyProjectInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(ApplyProjectInfo applyProjectInfo) {
		super.save(applyProjectInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(ApplyProjectInfo applyProjectInfo) {
		super.delete(applyProjectInfo);
	}
	
}