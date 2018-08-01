/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 招标投标Entity
 * @author huangzhengyu
 * @version 2018-07-31
 */
public class Trade extends DataEntity<Trade> {
	
	private static final long serialVersionUID = 1L;
	private String prjCode;		// 项目代码
	private String prjName;		// 项目名称
	private String tenderInnerNum;		// 内部标号
	private String tenderType;		// 类型
	private String title;		// 标题
	private Date writetime;		// 生成日期
	private Date opentime;		// 公开日期
	private String indexid;		// 索引号
	private String url;		// 滨湖门户链接
	private String organization;		// 单位
	private String displayFlag;		// display_flag
	
	public Trade() {
		super();
	}

	public Trade(String id){
		super(id);
	}

	@Length(min=0, max=64, message="项目代码长度必须介于 0 和 64 之间")
	public String getPrjCode() {
		return prjCode;
	}

	public void setPrjCode(String prjCode) {
		this.prjCode = prjCode;
	}
	
	@Length(min=0, max=200, message="项目名称长度必须介于 0 和 200 之间")
	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	
	@Length(min=0, max=50, message="内部标号长度必须介于 0 和 50 之间")
	public String getTenderInnerNum() {
		return tenderInnerNum;
	}

	public void setTenderInnerNum(String tenderInnerNum) {
		this.tenderInnerNum = tenderInnerNum;
	}
	
	@Length(min=0, max=100, message="类型长度必须介于 0 和 100 之间")
	public String getTenderType() {
		return tenderType;
	}

	public void setTenderType(String tenderType) {
		this.tenderType = tenderType;
	}
	
	@Length(min=0, max=200, message="标题长度必须介于 0 和 200 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getWritetime() {
		return writetime;
	}

	public void setWritetime(Date writetime) {
		this.writetime = writetime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getOpentime() {
		return opentime;
	}

	public void setOpentime(Date opentime) {
		this.opentime = opentime;
	}
	
	@Length(min=0, max=64, message="索引号长度必须介于 0 和 64 之间")
	public String getIndexid() {
		return indexid;
	}

	public void setIndexid(String indexid) {
		this.indexid = indexid;
	}
	
	@Length(min=0, max=200, message="滨湖门户链接长度必须介于 0 和 200 之间")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Length(min=0, max=100, message="单位长度必须介于 0 和 100 之间")
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	@Length(min=0, max=1, message="display_flag长度必须介于 0 和 1 之间")
	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

	@Override
	public String toString() {
		return "Trade{" +
				"prjCode='" + prjCode + '\'' +
				", prjName='" + prjName + '\'' +
				", tenderInnerNum='" + tenderInnerNum + '\'' +
				", tenderType='" + tenderType + '\'' +
				", title='" + title + '\'' +
				", writetime=" + writetime +
				", opentime=" + opentime +
				", indexid='" + indexid + '\'' +
				", url='" + url + '\'' +
				", organization='" + organization + '\'' +
				", displayFlag='" + displayFlag + '\'' +
				'}';
	}
}