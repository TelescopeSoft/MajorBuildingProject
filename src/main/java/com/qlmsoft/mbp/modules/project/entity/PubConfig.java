/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 配置表Entity
 * @author huangzhengyu
 * @version 2018-08-16
 */
public class PubConfig extends DataEntity<PubConfig> {
	
	private static final long serialVersionUID = 1L;

	private String ckey;		// ckey
	private String cvalue;		// cvalue
	
	public PubConfig() {
		super();
	}

	public PubConfig(String id){
		super(id);
	}

	@Length(min=0, max=50, message="ckey长度必须介于 0 和 50 之间")
	public String getCkey() {
		return ckey;
	}

	public void setCkey(String ckey) {
		this.ckey = ckey;
	}
	
	@Length(min=0, max=50, message="cvalue长度必须介于 0 和 50 之间")
	public String getCvalue() {
		return cvalue;
	}

	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}
	
}