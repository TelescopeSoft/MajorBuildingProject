/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.entity.ProjectInfo;
import com.qlmsoft.mbp.modules.project.dao.TBProjectInfoDao;

/**
 * 项目表Service
 * @author huangzhengyu
 * @version 2018-07-10
 */
@Service
@Transactional(readOnly = true)
public class TBProjectInfoService extends CrudService<TBProjectInfoDao, ProjectInfo> {

	public ProjectInfo get(String id) {
		return super.get(id);
	}
	
	public List<ProjectInfo> findList(ProjectInfo projectInfo) {
		return super.findList(projectInfo);
	}
	
	public Page<ProjectInfo> findPage(Page<ProjectInfo> page, ProjectInfo projectInfo) {
		return super.findPage(page, projectInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(ProjectInfo projectInfo) {
		projectInfo.setId(projectInfo.getPkid());
		super.save(projectInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(ProjectInfo projectInfo) {
		super.delete(projectInfo);
	}
	
	@Transactional(readOnly = false)
	public void toggleMajor(ProjectInfo projectInfo) {
		this.dao.updateMajorFlag(projectInfo);
	}
	
}