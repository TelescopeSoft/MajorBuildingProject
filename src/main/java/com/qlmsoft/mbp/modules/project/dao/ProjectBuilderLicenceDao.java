/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import java.util.List;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.ProjectBuilderLicence;

/**
 * 施工许可信息DAO接口
 * @author huangzhengyu
 * @version 2018-07-15
 */
@MyBatisDao
public interface ProjectBuilderLicenceDao extends CrudDao<ProjectBuilderLicence> {
	List<ProjectBuilderLicence> findListByProjectPkid(String pkid);

    ProjectBuilderLicence getByCondition(ProjectBuilderLicence bean);
}