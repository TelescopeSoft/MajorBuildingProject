/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.entity.ProjectBuilderLicence;
import com.qlmsoft.mbp.modules.project.entity.ProjectFinish;
import com.qlmsoft.mbp.modules.project.dao.ProjectBuilderLicenceDao;

/**
 * 施工许可信息Service
 * 
 * @author huangzhengyu
 * @version 2018-07-15
 */
@Service
@Transactional(readOnly = true)
public class ProjectBuilderLicenceService extends
		CrudService<ProjectBuilderLicenceDao, ProjectBuilderLicence> {

	public ProjectBuilderLicence get(String id) {
		return super.get(id);
	}

	public List<ProjectBuilderLicence> findList(
			ProjectBuilderLicence projectBuilderLicence) {
		return super.findList(projectBuilderLicence);
	}

	public List<ProjectBuilderLicence> findListByProjectPkid(String pkid) {
		return this.dao.findListByProjectPkid(pkid);
	}

	public Page<ProjectBuilderLicence> findPage(
			Page<ProjectBuilderLicence> page,
			ProjectBuilderLicence projectBuilderLicence) {
		return super.findPage(page, projectBuilderLicence);
	}

	@Transactional(readOnly = false)
	public void save(ProjectBuilderLicence projectBuilderLicence) {
		super.save(projectBuilderLicence);
	}

	@Transactional(readOnly = false)
	public void delete(ProjectBuilderLicence projectBuilderLicence) {
		super.delete(projectBuilderLicence);
	}

	@Transactional(readOnly = false)
	public void checkDuplicatedAndSave(ProjectBuilderLicence bean) {

		logger.info("checkDuplicatedAndSave : " + bean.getPkid() + "," + bean.getPrjnum() + "," + bean.getBuilderlicencenum());
		ProjectBuilderLicence existed = this.dao.getByCondition(bean);
		if (existed == null) {
			super.save(bean);
		}
	}
}