/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.qlmsoft.mbp.modules.project.entity.ApZjsbbDwry;

public class ConstructInfoDwBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dwName;
	private String dwlx;

	private List<ApZjsbbDwry> dwRyList = new ArrayList<ApZjsbbDwry>();

	public String getDwName() {
		return dwName;
	}

	public void setDwName(String dwName) {
		this.dwName = dwName;
	}

	public String getDwlx() {
		return dwlx;
	}

	public void setDwlx(String dwlx) {
		this.dwlx = dwlx;
	}

	public List<ApZjsbbDwry> getDwRyList() {
		return dwRyList;
	}

	public void setDwRyList(List<ApZjsbbDwry> dwRyList) {
		this.dwRyList = dwRyList;
	}

}
