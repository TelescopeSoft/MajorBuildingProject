package com.qlmsoft.mbp.modules.project.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.qlmsoft.mbp.modules.project.entity.ApAjsbbHjssjd;
import com.qlmsoft.mbp.modules.project.entity.ApZjsbbDwry;

public class ConstructInfoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String xmmc; // 报监工程名称

	private String prjNum; // 项目编码
	private String uuid; // 安监质监申报编号

	private String jsdwName;
	private List<ApZjsbbDwry> jsdwRyList = new ArrayList<ApZjsbbDwry>();

	private List<ConstructInfoDwBean> dwList = new ArrayList<ConstructInfoDwBean>();

	private List<ApAjsbbHjssjd> hjList = new ArrayList<ApAjsbbHjssjd>();

	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getJsdwName() {
		return jsdwName;
	}

	public void setJsdwName(String jsdwName) {
		this.jsdwName = jsdwName;
	}

	public List<ApZjsbbDwry> getJsdwRyList() {
		return jsdwRyList;
	}

	public void setJsdwRyList(List<ApZjsbbDwry> jsdwRyList) {
		this.jsdwRyList = jsdwRyList;
	}

	public List<ConstructInfoDwBean> getDwList() {
		return dwList;
	}

	public void setDwList(List<ConstructInfoDwBean> dwList) {
		this.dwList = dwList;
	}

	public List<ApAjsbbHjssjd> getHjList() {
		return hjList;
	}

	public void setHjList(List<ApAjsbbHjssjd> hjList) {
		this.hjList = hjList;
	}
}
