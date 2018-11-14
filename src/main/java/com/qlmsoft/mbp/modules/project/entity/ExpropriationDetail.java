/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import com.qlmsoft.mbp.common.persistence.MyDataEntity;
import org.hibernate.validator.constraints.Length;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 征地信息Entity
 * @author huangzhengyu
 * @version 2018-07-24
 */
public class ExpropriationDetail extends MyDataEntity<ExpropriationDetail> {
	
	private static final long serialVersionUID = 1L;
	private String prjCode;		// 项目代码
	private String prjName;		// 项目名称
	private String approveNum;		// 批准文号
	private Date approveDate;		// 批准日期
	private String address;		// 征地位置
	private String countyNum;		// 区划编码
	private String lcid;		// lcid
	private String displayFlag;		// display_flag
	private List<ExpropriationDetailInfo> expropriationDetailInfoList = Lists.newArrayList();		// 子表列表

	public ExpropriationDetail() {
		super();
	}

	public ExpropriationDetail(String id){
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
	
	@Length(min=0, max=200, message="批准文号长度必须介于 0 和 200 之间")
	public String getApproveNum() {
		return approveNum;
	}

	public void setApproveNum(String approveNum) {
		this.approveNum = approveNum;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	
	@Length(min=0, max=200, message="征地位置长度必须介于 0 和 200 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=20, message="区划编码长度必须介于 0 和 20 之间")
	public String getCountyNum() {
		return countyNum;
	}

	public void setCountyNum(String countyNum) {
		this.countyNum = countyNum;
	}
	
	@Length(min=0, max=64, message="lcid长度必须介于 0 和 64 之间")
	public String getLcid() {
		return lcid;
	}

	public void setLcid(String lcid) {
		this.lcid = lcid;
	}
	
	@Length(min=0, max=1, message="display_flag长度必须介于 0 和 1 之间")
	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}
	
	public List<ExpropriationDetailInfo> getExpropriationDetailInfoList() {
		return expropriationDetailInfoList;
	}

	public void setExpropriationDetailInfoList(List<ExpropriationDetailInfo> expropriationDetailInfoList) {
		this.expropriationDetailInfoList = expropriationDetailInfoList;
	}

	public List<ExpropriationDetailInfo> getBeforeApproveList() {
		return getDetailInfoByType(ExpropriationDetailInfo.BEFORE_APPROVE);
	}

	public List<ExpropriationDetailInfo> getInApproveList() {
		return getDetailInfoByType(ExpropriationDetailInfo.IN_APPROVE);
	}

	public List<ExpropriationDetailInfo> getAfterApproveList() {
		return getDetailInfoByType(ExpropriationDetailInfo.AFTER_APPROVE);
	}

	private List<ExpropriationDetailInfo> getDetailInfoByType(String infoType) {
		List<ExpropriationDetailInfo> result = new ArrayList<ExpropriationDetailInfo>();
		for(ExpropriationDetailInfo info : expropriationDetailInfoList){
			if(infoType.equals(info.getInfoType())){
				result.add(info);
			}
		}
		Collections.sort(result, new Comparator<ExpropriationDetailInfo>() {
			@Override
			public int compare(ExpropriationDetailInfo o1, ExpropriationDetailInfo o2) {
				return o1.getSort() - o2.getSort();
			}
		});
		return result;
	}


}