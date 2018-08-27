/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.dao.ProjectFinishDao;
import com.qlmsoft.mbp.modules.project.entity.ProjectFinish;

/**
 * 竣工备案Service
 * @author huangzhengyu
 * @version 2018-07-14
 */
@Service
@Transactional(readOnly = true)
public class ProjectFinishService extends CrudService<ProjectFinishDao, ProjectFinish> {

	public ProjectFinish get(String id) {
		return super.get(id);
	}
	
	public List<ProjectFinish> findList(ProjectFinish projectFinish) {
		return super.findList(projectFinish);
	}
	
	public List<ProjectFinish> findListByProjectPkid(String pkid) {
		return this.dao.findListByProjectPkid(pkid);
	}
	
	public Page<ProjectFinish> findPage(Page<ProjectFinish> page, ProjectFinish projectFinish) {
		return super.findPage(page, projectFinish);
	}
	
	@Transactional(readOnly = false)
	public void save(ProjectFinish projectFinish) {
		super.save(projectFinish);
	}
	
	@Transactional(readOnly = false)
	public void delete(ProjectFinish projectFinish) {
		super.delete(projectFinish);
	}

    public void checkDuplicatedAndSave(ProjectFinish bean) {
		ProjectFinish existed = this.dao.getByCondition(bean);
		if (existed == null) {
			super.save(bean);
		}
    }
}