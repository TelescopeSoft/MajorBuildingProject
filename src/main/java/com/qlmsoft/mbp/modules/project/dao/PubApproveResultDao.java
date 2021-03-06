/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import java.util.List;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.PubApproveResult;

/**
 * 批准结果DAO接口
 * @author huangzhengyu
 * @version 2018-07-13
 */
@MyBatisDao
public interface PubApproveResultDao extends CrudDao<PubApproveResult> {
	
	//根据工程项目的pkid查询批准结果信息
	List<PubApproveResult> findListByPkid(String pkid);
	
	//根据
	PubApproveResult getByCondition(PubApproveResult entity);
	
}