/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import com.qlmsoft.mbp.common.persistence.MyDataEntity;
import org.hibernate.validator.constraints.Length;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 招标投标内容Entity
 * @author aaron
 * @version 2018-07-31
 */
public class PubTradeContent extends MyDataEntity<PubTradeContent> {
	
	private static final long serialVersionUID = 1L;
	private String indexid;		// 索引号
	private String content;		// 内容
	
	public PubTradeContent() {
		super();
	}

	public PubTradeContent(String id){
		super(id);
	}

	@Length(min=0, max=64, message="索引号长度必须介于 0 和 64 之间")
	public String getIndexid() {
		return indexid;
	}

	public void setIndexid(String indexid) {
		this.indexid = indexid;
	}
	
	@Length(min=0, max=-1, message="内容长度必须介于 0 和 -1 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}