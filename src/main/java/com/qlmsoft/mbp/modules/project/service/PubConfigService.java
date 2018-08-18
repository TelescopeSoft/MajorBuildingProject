/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.entity.PubConfig;
import com.qlmsoft.mbp.modules.project.dao.PubConfigDao;

/**
 * 配置表Service
 * @author huangzhengyu
 * @version 2018-08-16
 */
@Service
@Transactional(readOnly = true)
public class PubConfigService extends CrudService<PubConfigDao, PubConfig> {

	public PubConfig get(String id) {
		return super.get(id);
	}

	public PubConfig getByKey(String key) {
		return this.dao.getByKey(key);
	}

	
	public List<PubConfig> findList(PubConfig pubConfig) {
		return super.findList(pubConfig);
	}

	public Page<PubConfig> findPage(Page<PubConfig> page, PubConfig pubConfig) {
		return super.findPage(page, pubConfig);
	}
	
	@Transactional(readOnly = false)
	public void save(PubConfig pubConfig) {
		super.save(pubConfig);
	}
	
	@Transactional(readOnly = false)
	public void delete(PubConfig pubConfig) {
		super.delete(pubConfig);
	}


	
}