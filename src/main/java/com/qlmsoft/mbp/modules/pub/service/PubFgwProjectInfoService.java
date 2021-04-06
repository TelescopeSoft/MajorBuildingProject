/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.pub.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.pub.entity.PubFgwProjectInfo;
import com.qlmsoft.mbp.modules.pub.dao.PubFgwProjectInfoDao;

/**
 * 重大建设项目基本信息Service
 * @author huangzhengyu
 * @version 2020-11-11
 */
@Service
@Transactional(readOnly = true)
public class PubFgwProjectInfoService extends CrudService<PubFgwProjectInfoDao, PubFgwProjectInfo> {

	public PubFgwProjectInfo get(String id) {
		return super.get(id);
	}
	
	public List<PubFgwProjectInfo> findList(PubFgwProjectInfo pubFgwProjectInfo) {
		return super.findList(pubFgwProjectInfo);
	}
	
	public Page<PubFgwProjectInfo> findPage(Page<PubFgwProjectInfo> page, PubFgwProjectInfo pubFgwProjectInfo) {
		return super.findPage(page, pubFgwProjectInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(PubFgwProjectInfo pubFgwProjectInfo) {
		super.save(pubFgwProjectInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(PubFgwProjectInfo pubFgwProjectInfo) {
		super.delete(pubFgwProjectInfo);
	}
	
}