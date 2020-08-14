/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.prjtrace.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.prjtrace.entity.ProjectType;
import com.qlmsoft.mbp.modules.prjtrace.dao.ProjectTypeDao;

/**
 * 项目类型Service
 * @author aaron
 * @version 2018-12-27
 */
@Service
@Transactional(readOnly = true)
public class ProjectTypeService extends CrudService<ProjectTypeDao, ProjectType> {

	public ProjectType get(String id) {
		return super.get(id);
	}
	
	public List<ProjectType> findList(ProjectType projectType) {
		return super.findList(projectType);
	}
	
	public Page<ProjectType> findPage(Page<ProjectType> page, ProjectType projectType) {
		return super.findPage(page, projectType);
	}
	
	@Transactional(readOnly = false)
	public void save(ProjectType projectType) {
		super.save(projectType);
	}
	
	@Transactional(readOnly = false)
	public void delete(ProjectType projectType) {
		super.delete(projectType);
	}
	
}