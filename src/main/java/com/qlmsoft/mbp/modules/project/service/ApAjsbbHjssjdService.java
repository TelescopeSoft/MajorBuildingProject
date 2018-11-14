/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.entity.ApAjsbbHjssjd;
import com.qlmsoft.mbp.modules.project.dao.ApAjsbbHjssjdDao;

/**
 * 安监申报环境交底Service
 * @author huangzhengyu
 * @version 2018-08-01
 */
@Service
@Transactional(readOnly = true)
public class ApAjsbbHjssjdService extends CrudService<ApAjsbbHjssjdDao, ApAjsbbHjssjd> {

	public ApAjsbbHjssjd get(String id) {
		return super.get(id);
	}
	
	public List<ApAjsbbHjssjd> findList(ApAjsbbHjssjd apAjsbbHjssjd) {
		return super.findList(apAjsbbHjssjd);
	}
	
	public Page<ApAjsbbHjssjd> findPage(Page<ApAjsbbHjssjd> page, ApAjsbbHjssjd apAjsbbHjssjd) {
		return super.findPage(page, apAjsbbHjssjd);
	}
	
	@Transactional(readOnly = false)
	public void save(ApAjsbbHjssjd apAjsbbHjssjd) {
		super.save(apAjsbbHjssjd);
	}
	
	@Transactional(readOnly = false)
	public void delete(ApAjsbbHjssjd apAjsbbHjssjd) {
		super.delete(apAjsbbHjssjd);
	}
	
}