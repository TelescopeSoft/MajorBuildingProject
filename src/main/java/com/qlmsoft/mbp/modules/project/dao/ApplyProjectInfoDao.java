/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.ApplyProjectInfo;
import org.apache.ibatis.annotations.Param;

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

    void updateMajorFlag(ApplyProjectInfo info);

    void insertMajorFlag(ApplyProjectInfo info);

    ApplyProjectInfo getMajorFlag(@Param("projectCode") String projectCode);

}