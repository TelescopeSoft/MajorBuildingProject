/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.prjtrace.dao;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.prjtrace.entity.ProjectType;

/**
 * 项目类型DAO接口
 * @author aaron
 * @version 2018-12-27
 */
@MyBatisDao
public interface ProjectTypeDao extends CrudDao<ProjectType> {
	
}