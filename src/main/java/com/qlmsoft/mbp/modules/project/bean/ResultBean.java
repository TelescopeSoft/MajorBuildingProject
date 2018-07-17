package com.qlmsoft.mbp.modules.project.bean;

import java.io.Serializable;

public class ResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int OK = 0;
	public static final int ERROR = 1;
	
	private int code = OK;
	private String msg;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
