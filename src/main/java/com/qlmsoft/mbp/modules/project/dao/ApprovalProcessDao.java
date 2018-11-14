/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.ApprovalProcess;

/**
 * 发改审批事项办理详细信息DAO接口
 * @author huangzhengyu
 * @version 2018-08-08
 */
@MyBatisDao
public interface ApprovalProcessDao extends CrudDao<ApprovalProcess> {
	
}