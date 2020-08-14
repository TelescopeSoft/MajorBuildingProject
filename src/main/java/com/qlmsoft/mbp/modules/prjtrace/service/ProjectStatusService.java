/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.prjtrace.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.prjtrace.entity.ProjectStatus;
import com.qlmsoft.mbp.modules.prjtrace.dao.ProjectStatusDao;

/**
 * 项目状态Service
 * @author aaron
 * @version 2018-12-27
 */
@Service
@Transactional(readOnly = true)
public class ProjectStatusService extends CrudService<ProjectStatusDao, ProjectStatus> {

	public ProjectStatus get(String id) {
		return super.get(id);
	}
	
	public List<ProjectStatus> findList(ProjectStatus projectStatus) {
		return super.findList(projectStatus);
	}
	
	public Page<ProjectStatus> findPage(Page<ProjectStatus> page, ProjectStatus projectStatus) {
		return super.findPage(page, projectStatus);
	}
	
	@Transactional(readOnly = false)
	public void save(ProjectStatus projectStatus) {
		super.save(projectStatus);
	}
	
	@Transactional(readOnly = false)
	public void delete(ProjectStatus projectStatus) {
		super.delete(projectStatus);
	}
	
}