/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.qlmsoft.mbp.modules.project.entity.PubApproveResult;

public class PubApproveResultTable implements Serializable {

	private static final long serialVersionUID = 1L;

	private int totalRecord;

	private int totalPage;

	private int pageNo;

	private int pageSize;

	private List<PubApproveResult> list = new ArrayList<PubApproveResult>();

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<PubApproveResult> getList() {
		return list;
	}

	public void setList(List<PubApproveResult> list) {
		this.list = list;
	}

}
