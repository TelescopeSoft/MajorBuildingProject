/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.ApproveItemInfo;

/**
 * 发改批准结果信息DAO接口
 * @author huangzhengyu
 * @version 2018-08-09
 */
@MyBatisDao
public interface ApproveItemInfoDao extends CrudDao<ApproveItemInfo> {
	
}