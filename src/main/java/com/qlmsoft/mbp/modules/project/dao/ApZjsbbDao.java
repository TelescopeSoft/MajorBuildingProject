/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import java.util.List;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.ApZjsbb;

/**
 * 质监申报DAO接口
 * @author huangzhengyu
 * @version 2018-07-14
 */
@MyBatisDao
public interface ApZjsbbDao extends CrudDao<ApZjsbb> {
	List<ApZjsbb> findListByProjectPkid(String pkid);

    ApZjsbb getByCondition(ApZjsbb ajsbb);
}