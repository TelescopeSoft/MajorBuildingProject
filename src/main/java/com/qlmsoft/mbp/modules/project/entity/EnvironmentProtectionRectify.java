/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import org.hibernate.validator.constraints.Length;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 施工期环境保护措施Entity
 * @author huang.zhengyu
 * @version 2018-08-20
 */
public class EnvironmentProtectionRectify extends DataEntity<EnvironmentProtectionRectify> {
	
	private static final long serialVersionUID = 1L;
	private String environmentProtectionId;		// 施工期环境保护措施外键
	private EnvironmentProtection envProtect;		// 发改项目代码 父类
	private String rectify;		// 整改情况
	private String rectifyNotice;		// 整改通知
	
	public EnvironmentProtectionRectify() {
		super();
	}

	public EnvironmentProtectionRectify(String id){
		super(id);
	}

	public EnvironmentProtectionRectify(EnvironmentProtection envProtect){
		this.envProtect = envProtect;
	}

	public String getEnvironmentProtectionId() {
		return environmentProtectionId;
	}

	public void setEnvironmentProtectionId(String environmentProtectionId) {
		this.environmentProtectionId = environmentProtectionId;
	}

	public EnvironmentProtection getEnvProtect() {
		return envProtect;
	}

	public void setEnvProtect(EnvironmentProtection envProtect) {
		this.envProtect = envProtect;
	}

	@Length(min=0, max=255, message="整改情况长度必须介于 0 和 255 之间")
	public String getRectify() {
		return rectify;
	}

	public void setRectify(String rectify) {
		this.rectify = rectify;
	}
	
	@Length(min=0, max=255, message="整改通知长度必须介于 0 和 255 之间")
	public String getRectifyNotice() {
		return rectifyNotice;
	}

	public void setRectifyNotice(String rectifyNotice) {
		this.rectifyNotice = rectifyNotice;
	}
	
}