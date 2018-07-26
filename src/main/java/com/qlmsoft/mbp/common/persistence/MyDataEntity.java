/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.common.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.qlmsoft.mbp.common.utils.IdGen;
import com.qlmsoft.mbp.modules.sys.entity.User;
import com.qlmsoft.mbp.modules.sys.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

/**
 * 数据Entity类
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class MyDataEntity<T> extends DataEntity<T> {

	private static final long serialVersionUID = 1L;


	public MyDataEntity() {
		super();
		this.delFlag = DEL_FLAG_NORMAL;
	}

	public MyDataEntity(String id) {
		super(id);
	}
	
	/**
	 * 插入之前执行方法，需要手动调用
	 */
	@Override
	public void preInsert(){
		// 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
		User user = UserUtils.getUser();
		if (StringUtils.isNotBlank(user.getId())){
			this.updateBy = user;
			this.createBy = user;
		}
		this.updateDate = new Date();
		this.createDate = this.updateDate;
	}
	
	/**
	 * 更新之前执行方法，需要手动调用
	 */
	@Override
	public void preUpdate(){
		User user = UserUtils.getUser();
		if (StringUtils.isNotBlank(user.getId())){
			this.updateBy = user;
		}
		this.updateDate = new Date();
	}
	


}
