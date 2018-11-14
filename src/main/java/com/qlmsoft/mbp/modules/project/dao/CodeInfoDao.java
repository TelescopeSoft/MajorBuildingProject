/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.CodeInfo;

/**
 * 项目代码表DAO接口
 * @author huang.zhengyu
 * @version 2018-08-29
 */
@MyBatisDao
public interface CodeInfoDao extends CrudDao<CodeInfo> {
	
}