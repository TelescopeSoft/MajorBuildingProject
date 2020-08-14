/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.prjtrace.entity;

import com.qlmsoft.mbp.common.persistence.NewDataEntity;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 项目类型Entity
 * @author aaron
 * @version 2018-12-27
 */
public class ProjectType extends NewDataEntity<ProjectType> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// 代码
	private String name;		// 名称
	private String sort;		// 排序

	
	public ProjectType() {
		super();
	}

	public ProjectType(String id){
		super(id);
	}

	@Length(min=0, max=64, message="代码长度必须介于 0 和 64 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=200, message="名称长度必须介于 0 和 200 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}