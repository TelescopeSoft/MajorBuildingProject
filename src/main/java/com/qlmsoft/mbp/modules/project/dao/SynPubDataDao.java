/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.dao;

import com.qlmsoft.mbp.common.persistence.BaseDao;
import com.qlmsoft.mbp.common.persistence.CrudDao;
import com.qlmsoft.mbp.common.persistence.annotation.MyBatisDao;
import com.qlmsoft.mbp.modules.project.entity.ApplyProjectInfo;
import com.qlmsoft.mbp.modules.project.entity.ApproveItemInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 公共开发数据dao
 * @author huangzhengyu
 * @version 2018-08-08
 */
@MyBatisDao
public interface SynPubDataDao extends BaseDao {

    public int insertProjectInfo(ApplyProjectInfo entity);

//    public int insertApproveItemInfo(ApproveItemInfo entity);

}
