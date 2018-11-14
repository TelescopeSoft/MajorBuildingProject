/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.PubTradeContent;

/**
 * 招标投标内容DAO接口
 * @author aaron
 * @version 2018-07-31
 */
@MyBatisDao
public interface PubTradeContentDao extends CrudDao<PubTradeContent> {
    PubTradeContent getByCondition(PubTradeContent entity);
}