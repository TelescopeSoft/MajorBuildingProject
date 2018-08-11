/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.ApplyProjectInfo;

import java.util.List;

/**
 * 发改申报项目基本信息DAO接口
 * @author huangzhengyu
 * @version 2018-08-08
 */
@MyBatisDao
public interface ApplyProjectInfoDao extends CrudDao<ApplyProjectInfo> {

    ApplyProjectInfo getByProjectCode(ApplyProjectInfo projectCode);

    List<ApplyProjectInfo> findNotMatchList(ApplyProjectInfo applyProjectInfo);

}