/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.ApZjsbbDwry;

/**
 * 质量报监单位人员DAO接口
 * @author huangzhengyu
 * @version 2018-07-15
 */
@MyBatisDao
public interface ApZjsbbDwryDao extends CrudDao<ApZjsbbDwry> {

    ApZjsbbDwry getByCondition(ApZjsbbDwry item);
}