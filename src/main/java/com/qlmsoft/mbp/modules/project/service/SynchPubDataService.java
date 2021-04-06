/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import com.qlmsoft.mbp.common.annotation.TargetDataSource;
import com.qlmsoft.mbp.common.service.BaseService;
import com.qlmsoft.mbp.common.utils.DateUtils;
import com.qlmsoft.mbp.modules.project.dao.SynPubDataDao;
import com.qlmsoft.mbp.modules.project.entity.ApplyProjectInfo;
import com.qlmsoft.mbp.modules.project.entity.ApproveItemInfo;
import com.qlmsoft.mbp.modules.project.entity.PubConfig;
import com.qlmsoft.mbp.modules.pub.dao.PubFgwProjectInfoDao;
import com.qlmsoft.mbp.modules.pub.entity.PubFgwProjectInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 同步数据给大数据局
 * @author huangzhengyu
 * @version 2020/10/29
 */
@Service
@Transactional(readOnly = true)
public class SynchPubDataService extends BaseService {

	@Autowired
	SynPubDataDao dao;

	@Autowired
	PubFgwProjectInfoDao pubFgwProjectInfoDao;

	@Transactional(readOnly = false)
	@TargetDataSource(name=TargetDataSource.SLAVE)
	public void saveProjectInfo(ApplyProjectInfo applyProjectInfo) {
		this.dao.insertProjectInfo(applyProjectInfo);
	}

	@Transactional(readOnly = false)
	@TargetDataSource(name=TargetDataSource.SLAVE)
	public void savePubFgwProjectInfo(ApplyProjectInfo applyProjectInfo) {

		PubFgwProjectInfo pubBean = getPubDataProjectInfo(applyProjectInfo);
		PubFgwProjectInfo existed = pubFgwProjectInfoDao.get(pubBean.getProjectCode());
		if(existed == null){
			pubFgwProjectInfoDao.insert(pubBean);
		} else {
			BeanUtils.copyProperties(pubBean, existed, "projectCode");
			pubFgwProjectInfoDao.update(existed);
		}


	}




	private PubFgwProjectInfo getPubDataProjectInfo(ApplyProjectInfo bean) {
		PubFgwProjectInfo result = new PubFgwProjectInfo();

		BeanUtils.copyProperties(bean, result);
		result.setProjectCode(bean.getProjectCode());
		result.setProjectName(bean.getProjectName());


		return result;
	}


}
