/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.ProjectInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目表DAO接口
 * @author huangzhengyu
 * @version 2018-07-10
 */
@MyBatisDao
public interface TBProjectInfoDao extends CrudDao<ProjectInfo> {
	void updateMajorFlag(ProjectInfo info);

	List<ProjectInfo> getCrawlerProjectList();

	void updateProjectCode(ProjectInfo info);

	void updateProjectCodeByPrjNum(ProjectInfo info);

	ProjectInfo getBaseByName(@Param("prjname") String prjname);

	ProjectInfo getBaseByApproveNum(@Param("approvetype") String approvetype,@Param("approvenum") String approvenum);

	ProjectInfo getBaseByApproveNumFromYHT(@Param("approvetype") String approvetype,@Param("approvenum") String approvenum);

	ProjectInfo getByCondition(ProjectInfo info);

}