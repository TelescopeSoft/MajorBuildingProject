/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.ExpropriationDetailInfo;

/**
 * 征地信息DAO接口
 * @author huangzhengyu
 * @version 2018-07-24
 */
@MyBatisDao
public interface ExpropriationDetailInfoDao extends CrudDao<ExpropriationDetailInfo> {

    public ExpropriationDetailInfo getByCondition(ExpropriationDetailInfo bean);
	
}