/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import java.util.List;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.ContractRecord;

/**
 * 合同备案DAO接口
 * @author huangzhengyu
 * @version 2018-07-14
 */
@MyBatisDao
public interface ContractRecordDao extends CrudDao<ContractRecord> {
	List<ContractRecord> findListByProjectPkid(String pkid);
}