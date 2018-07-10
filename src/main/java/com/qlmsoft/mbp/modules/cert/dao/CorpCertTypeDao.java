/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.cert.dao;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.cert.entity.CorpCertType;

/**
 * corpcerttypeDAO接口
 * @author GLQ
 * @version 2018-04-24
 */
@MyBatisDao
public interface CorpCertTypeDao extends CrudDao<CorpCertType> {
	
}