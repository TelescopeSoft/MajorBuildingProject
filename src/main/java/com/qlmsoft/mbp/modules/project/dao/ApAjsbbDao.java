/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import java.util.List;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.ApAjsbb;

/**
 * 安监申报DAO接口
 * @author huangzhengyu
 * @version 2018-07-14
 */
@MyBatisDao
public interface ApAjsbbDao extends CrudDao<ApAjsbb> {

	List<ApAjsbb> findListByProjectPkid(String pkid);

    ApAjsbb getByCondition(ApAjsbb ajsbb);
}