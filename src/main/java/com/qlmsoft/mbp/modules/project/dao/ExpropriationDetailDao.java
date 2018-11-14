/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.ExpropriationDetail;

/**
 * 征地信息DAO接口
 *
 * @author huangzhengyu
 * @version 2018-07-24
 */
@MyBatisDao
public interface ExpropriationDetailDao extends CrudDao<ExpropriationDetail> {
    ExpropriationDetail getByCondition(ExpropriationDetail entity);
}