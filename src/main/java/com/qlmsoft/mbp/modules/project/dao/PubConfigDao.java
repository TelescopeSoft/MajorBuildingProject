/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.PubConfig;

/**
 * 配置表DAO接口
 * @author huangzhengyu
 * @version 2018-08-16
 */
@MyBatisDao
public interface PubConfigDao extends CrudDao<PubConfig> {
    PubConfig getByKey(String key);
}