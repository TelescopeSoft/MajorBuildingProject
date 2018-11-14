/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.PubApproveGuide;

/**
 * 办事指南DAO接口
 * @author huangzhengyu
 * @version 2018-07-12
 */
@MyBatisDao
public interface PubApproveGuideDao extends CrudDao<PubApproveGuide> {
	
}