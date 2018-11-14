/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import java.util.List;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.TenderInfo;

/**
 * 招标投标DAO接口
 *
 * @author huangzhengyu
 * @version 2018-07-14
 */
@MyBatisDao
public interface TenderInfoDao extends CrudDao<TenderInfo> {

    List<TenderInfo> findListByProjectPkid(String pkid);

    String getByTenderInnerNum(String tenderInnerNum);

    TenderInfo getByCondition(TenderInfo tenderInfo);

}