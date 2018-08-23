/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.Date;
import java.util.List;

import com.qlmsoft.mbp.common.utils.StringUtils;
import com.qlmsoft.mbp.modules.project.entity.ProjectInfo;
import com.qlmsoft.mbp.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private TBProjectInfoService zjPrjService;

	public ApplyProjectInfo get(String id) {
		return super.get(id);
	}

	public ApplyProjectInfo getByProjectCode(String projectCode) {
		ApplyProjectInfo entity = new ApplyProjectInfo();
		entity.setProjectCode(projectCode);
		return this.dao.getByProjectCode(entity);
	}


	public List<ApplyProjectInfo> findNotMatchedList(ApplyProjectInfo applyProjectInfo) {
		return this.dao.findNotMatchList(applyProjectInfo);
	}

	public List<ApplyProjectInfo> findList(ApplyProjectInfo applyProjectInfo) {
		return super.findList(applyProjectInfo);
	}
	
	public Page<ApplyProjectInfo> findPage(Page<ApplyProjectInfo> page, ApplyProjectInfo applyProjectInfo) {
		return super.findPage(page, applyProjectInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(ApplyProjectInfo applyProjectInfo) {
		//super.save(applyProjectInfo);
		if(StringUtils.isNotEmpty(applyProjectInfo.getPrjNum())){
			ProjectInfo pi = new ProjectInfo();
			pi.setPrjCode(applyProjectInfo.getProjectCode());
			pi.setPrjnum(applyProjectInfo.getPrjNum());
			pi.setUpdateuser(UserUtils.getUser().getLoginName());
			pi.setXgrqsj(new Date());
			zjPrjService.updateProjectCodeByPrjNum(pi);
		}

	}

	@Transactional(readOnly = false)
	public void toggleMajor(ApplyProjectInfo projectInfo) {
		ApplyProjectInfo exist = this.dao.getMajorFlag(projectInfo.getProjectCode());
		if(exist == null){
			this.dao.insertMajorFlag(projectInfo);
		}else {
			this.dao.updateMajorFlag(projectInfo);
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(ApplyProjectInfo applyProjectInfo) {
		super.delete(applyProjectInfo);
	}
	
}