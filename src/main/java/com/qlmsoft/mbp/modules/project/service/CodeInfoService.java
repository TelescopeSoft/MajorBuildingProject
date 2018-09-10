/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlmsoft.mbp.common.persistence.Page;
import com.qlmsoft.mbp.common.service.CrudService;
import com.qlmsoft.mbp.modules.project.entity.CodeInfo;
import com.qlmsoft.mbp.modules.project.dao.CodeInfoDao;

/**
 * 项目代码表Service
 * @author huang.zhengyu
 * @version 2018-08-29
 */
@Service
@Transactional(readOnly = true)
public class CodeInfoService extends CrudService<CodeInfoDao, CodeInfo> {

	public CodeInfo get(String id) {
		return super.get(id);
	}
	
	public List<CodeInfo> findList(CodeInfo codeInfo) {
		return super.findList(codeInfo);
	}
	
	public Page<CodeInfo> findPage(Page<CodeInfo> page, CodeInfo codeInfo) {
		return super.findPage(page, codeInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(CodeInfo codeInfo) {
		super.save(codeInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(CodeInfo codeInfo) {
		super.delete(codeInfo);
	}
	
}