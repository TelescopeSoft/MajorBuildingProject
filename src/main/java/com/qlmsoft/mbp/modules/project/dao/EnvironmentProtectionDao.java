/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.EnvironmentProtection;
import org.apache.ibatis.annotations.Param;

/**
 * 施工期环境保护措施DAO接口
 * @author huang.zhengyu
 * @version 2018-08-20
 */
@MyBatisDao
public interface EnvironmentProtectionDao extends CrudDao<EnvironmentProtection> {
    EnvironmentProtection getByPrjCode(@Param("prjCode") String prjCode);
}