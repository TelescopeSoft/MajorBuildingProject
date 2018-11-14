/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import org.hibernate.validator.constraints.Length;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 项目代码表Entity
 * @author huang.zhengyu
 * @version 2018-08-29
 */
public class CodeInfo extends DataEntity<CodeInfo> {
	
	private static final long serialVersionUID = 1L;
	private String codeType;		// code_type
	private String code;		// code
	private String name;		// name
	
	public CodeInfo() {
		super();
	}

	public CodeInfo(String id){
		super(id);
	}

	@Length(min=0, max=50, message="code_type长度必须介于 0 和 50 之间")
	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	
	@Length(min=0, max=50, message="code长度必须介于 0 和 50 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=100, message="name长度必须介于 0 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}