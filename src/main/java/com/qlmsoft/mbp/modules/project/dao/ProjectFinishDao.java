/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import java.util.List;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.ProjectFinish;

/**
 * 竣工备案DAO接口
 * @author huangzhengyu
 * @version 2018-07-14
 */
@MyBatisDao
public interface ProjectFinishDao extends CrudDao<ProjectFinish> {
	List<ProjectFinish> findListByProjectPkid(String pkid);

    ProjectFinish getByCondition(ProjectFinish bean);
}