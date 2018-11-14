/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.ApAjsbbHjssjd;

/**
 * 安监申报环境交底DAO接口
 * @author huangzhengyu
 * @version 2018-08-01
 */
@MyBatisDao
public interface ApAjsbbHjssjdDao extends CrudDao<ApAjsbbHjssjd> {

    ApAjsbbHjssjd getByCondition(ApAjsbbHjssjd item);
}