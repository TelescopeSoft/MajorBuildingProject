/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import com.qlmsoft.mbp.common.persistence.MyDataEntity;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 征地信息Entity
 * @author huangzhengyu
 * @version 2018-07-24
 */
public class ExpropriationDetailInfo extends MyDataEntity<ExpropriationDetailInfo> {

	private static final long serialVersionUID = 1L;

	public static final String BEFORE_APPROVE = "批前";
	public static final String IN_APPROVE = "批中";
	public static final String AFTER_APPROVE = "批后";

	private String lcid;		// lcid 父类
	private String infoType;		// 信息类型
	private String content;		// 信息内容
	private String title;		// 标题
	private String publicUnit;		// 发布单位
	private Date publicDate;		// 发布日期
	private String fileName;		// file_name
	private String filePreffix;		// file_preffix
	private String fileUrl;		// file_url
	private String filePath;		// file_path
	private String displayFlag;		// display_flag
	private int sort;
	
	public ExpropriationDetailInfo() {
		super();
	}

	public ExpropriationDetailInfo(String id){
		super(id);
	}

	public String getLcid() {
		return lcid;
	}

	public void setLcid(String lcid) {
		this.lcid = lcid;
	}

	@Length(min=0, max=20, message="信息类型长度必须介于 0 和 20 之间")
	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	
	@Length(min=0, max=100, message="信息内容长度必须介于 0 和 100 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=100, message="标题长度必须介于 0 和 100 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=100, message="发布单位长度必须介于 0 和 100 之间")
	public String getPublicUnit() {
		return publicUnit;
	}

	public void setPublicUnit(String publicUnit) {
		this.publicUnit = publicUnit;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPublicDate() {
		return publicDate;
	}

	public void setPublicDate(Date publicDate) {
		this.publicDate = publicDate;
	}
	
	@Length(min=0, max=100, message="file_name长度必须介于 0 和 100 之间")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Length(min=0, max=100, message="file_preffix长度必须介于 0 和 100 之间")
	public String getFilePreffix() {
		return filePreffix;
	}

	public void setFilePreffix(String filePreffix) {
		this.filePreffix = filePreffix;
	}
	
	@Length(min=0, max=255, message="file_url长度必须介于 0 和 255 之间")
	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	@Length(min=0, max=255, message="file_path长度必须介于 0 和 255 之间")
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Length(min=0, max=1, message="display_flag长度必须介于 0 和 1 之间")
	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
}