/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import com.qlmsoft.mbp.modules.project.entity.Expropriation;
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

	public ProjectInfo getBaseByName(String name) {
		return this.dao.getBaseByName(name);
	}

	public ProjectInfo getBaseByApproveNum(String approveType , String approveNum) {
		ProjectInfo result = this.dao.getBaseByApproveNum(approveType, approveNum);
		if(result == null) {
			//对于有些立项文号为空的，从一号通DG_Programme_Info表里获取
			result = this.dao.getBaseByApproveNumFromYHT(approveType, approveNum);
		}
		return result;
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

	@Transactional(readOnly = false)
	public void updateProjectCode(ProjectInfo projectInfo) {
		this.dao.updateProjectCode(projectInfo);
	}
	@Transactional(readOnly = false)
	public void updateProjectCodeByPrjNum(ProjectInfo projectInfo) {
		this.dao.updateProjectCodeByPrjNum(projectInfo);
	}

	@Transactional(readOnly = false)
	public void checkDuplicatedAndSave(ProjectInfo projectInfo) {
		ProjectInfo existed = this.dao.getByCondition(projectInfo);
		if (existed == null) {
			super.save(projectInfo);
		}
	}
}