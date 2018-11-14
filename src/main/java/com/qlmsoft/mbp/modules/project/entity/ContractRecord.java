/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import com.qlmsoft.mbp.common.utils.JaxbDateAdapter;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 合同备案Entity
 * 
 * @author huangzhengyu
 * @version 2018-07-14
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ContractRecord extends DataEntity<ContractRecord> {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "PKID")
	private String pkid; // pkid

	@XmlElement(name = "RecordName")
	private String recordname; // 合同项目名称

	@XmlElement(name = "RecordNum")
	private String recordnum; // 合同备案编号

	@XmlElement(name = "RecordInnerNum")
	private String recordinnernum; // 合同备案内部编号

	@XmlElement(name = "PrjNum")
	private String prjnum; // 项目编号

	@XmlElement(name = "ContractNum")
	private String contractnum; // 合同编号

	@XmlElement(name = "ContractTypeNum")
	private String contracttypenum; // 合同类别
	private String contracttypeLabel; // 合同类别文本

	@XmlElement(name = "ContractMoney")
	private String contractmoney; // 合同金额(万元)

	@XmlElement(name = "PrjSize")
	private String prjsize; // 建设规模

	@XmlElement(name = "ContractDate")
	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	private Date contractdate; // 合同签订日期

	@XmlElement(name = "PropietorCorpName")
	private String propietorcorpname; // 发包单位名称

	@XmlElement(name = "PropietorCorpCode")
	private String propietorcorpcode; // 发包单位名称组织机构代码

	@XmlElement(name = "ContractorCorpName")
	private String contractorcorpname; // 承包单位名称

	@XmlElement(name = "ContractorCorpCode")
	private String contractorcorpcode; // 承包单位名称组织机构代码

	@XmlElement(name = "UnionCorpName")
	private String unioncorpname; // 联合体承包单位名称

	@XmlElement(name = "UnionCorpCode")
	private String unioncorpcode; // 联合体承包单位名称组织机构代码

	@XmlElement(name = "CreateDate")
	private Date createdate; // 记录登记日期

	@XmlElement(name = "UpdateFlag")
	private String updateflag; // 更新标识

	@XmlElement(name = "PrjHead")
	private String prjhead; // 项目负责人

	@XmlElement(name = "PrjHeadPhone")
	private String prjheadphone; // 项目负责人联系电话

	@XmlElement(name = "IDCard")
	private String idcard; // 项目负责人证件号码

	@XmlElement(name = "sbdqbm")
	private String sbdqbm; // sbdqbm
	private String datastate; // datastate
	private Date cjrqsj; // cjrqsj
	private Date xgrqsj; // xgrqsj
	private Date scrqsj; // scrqsj
	private String returnresult; // returnresult
	private String updateuser; // updateuser
	private String tag; // tag

	public ContractRecord() {
		super();
	}

	public ContractRecord(String id) {
		super(id);
	}

	@Length(min = 1, max = 50, message = "pkid长度必须介于 1 和 50 之间")
	public String getPkid() {
		return pkid;
	}

	public void setPkid(String pkid) {
		this.pkid = pkid;
	}

	@Length(min = 1, max = 200, message = "合同项目名称长度必须介于 1 和 200 之间")
	public String getRecordname() {
		return recordname;
	}

	public void setRecordname(String recordname) {
		this.recordname = recordname;
	}

	@Length(min = 0, max = 50, message = "合同备案编号长度必须介于 0 和 50 之间")
	public String getRecordnum() {
		return recordnum;
	}

	public void setRecordnum(String recordnum) {
		this.recordnum = recordnum;
	}

	@Length(min = 1, max = 50, message = "合同备案内部编号长度必须介于 1 和 50 之间")
	public String getRecordinnernum() {
		return recordinnernum;
	}

	public void setRecordinnernum(String recordinnernum) {
		this.recordinnernum = recordinnernum;
	}

	@Length(min = 0, max = 20, message = "项目编号长度必须介于 0 和 20 之间")
	public String getPrjnum() {
		return prjnum;
	}

	public void setPrjnum(String prjnum) {
		this.prjnum = prjnum;
	}

	@Length(min = 0, max = 50, message = "合同编号长度必须介于 0 和 50 之间")
	public String getContractnum() {
		return contractnum;
	}

	public void setContractnum(String contractnum) {
		this.contractnum = contractnum;
	}

	@Length(min = 1, max = 3, message = "合同类别长度必须介于 1 和 3 之间")
	public String getContracttypenum() {
		return contracttypenum;
	}

	public void setContracttypenum(String contracttypenum) {
		this.contracttypenum = contracttypenum;
	}

	public String getContractmoney() {
		return contractmoney;
	}

	public void setContractmoney(String contractmoney) {
		this.contractmoney = contractmoney;
	}

	@Length(min = 0, max = 1000, message = "建设规模长度必须介于 0 和 1000 之间")
	public String getPrjsize() {
		return prjsize;
	}

	public void setPrjsize(String prjsize) {
		this.prjsize = prjsize;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "合同签订日期不能为空")
	public Date getContractdate() {
		return contractdate;
	}

	public void setContractdate(Date contractdate) {
		this.contractdate = contractdate;
	}

	@Length(min = 1, max = 200, message = "发包单位名称长度必须介于 1 和 200 之间")
	public String getPropietorcorpname() {
		return propietorcorpname;
	}

	public void setPropietorcorpname(String propietorcorpname) {
		this.propietorcorpname = propietorcorpname;
	}

	@Length(min = 0, max = 18, message = "发包单位名称组织机构代码长度必须介于 0 和 18 之间")
	public String getPropietorcorpcode() {
		return propietorcorpcode;
	}

	public void setPropietorcorpcode(String propietorcorpcode) {
		this.propietorcorpcode = propietorcorpcode;
	}

	@Length(min = 1, max = 200, message = "承包单位名称长度必须介于 1 和 200 之间")
	public String getContractorcorpname() {
		return contractorcorpname;
	}

	public void setContractorcorpname(String contractorcorpname) {
		this.contractorcorpname = contractorcorpname;
	}

	@Length(min = 1, max = 18, message = "承包单位名称组织机构代码长度必须介于 1 和 18 之间")
	public String getContractorcorpcode() {
		return contractorcorpcode;
	}

	public void setContractorcorpcode(String contractorcorpcode) {
		this.contractorcorpcode = contractorcorpcode;
	}

	@Length(min = 0, max = 200, message = "联合体承包单位名称长度必须介于 0 和 200 之间")
	public String getUnioncorpname() {
		return unioncorpname;
	}

	public void setUnioncorpname(String unioncorpname) {
		this.unioncorpname = unioncorpname;
	}

	@Length(min = 0, max = 18, message = "联合体承包单位名称组织机构代码长度必须介于 0 和 18 之间")
	public String getUnioncorpcode() {
		return unioncorpcode;
	}

	public void setUnioncorpcode(String unioncorpcode) {
		this.unioncorpcode = unioncorpcode;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "记录登记日期不能为空")
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Length(min = 1, max = 1, message = "更新标识长度必须介于 1 和 1 之间")
	public String getUpdateflag() {
		return updateflag;
	}

	public void setUpdateflag(String updateflag) {
		this.updateflag = updateflag;
	}

	@Length(min = 1, max = 50, message = "项目负责人长度必须介于 1 和 50 之间")
	public String getPrjhead() {
		return prjhead;
	}

	public void setPrjhead(String prjhead) {
		this.prjhead = prjhead;
	}

	@Length(min = 0, max = 50, message = "项目负责人联系电话长度必须介于 0 和 50 之间")
	public String getPrjheadphone() {
		return prjheadphone;
	}

	public void setPrjheadphone(String prjheadphone) {
		this.prjheadphone = prjheadphone;
	}

	@Length(min = 0, max = 50, message = "项目负责人证件号码长度必须介于 0 和 50 之间")
	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@Length(min = 1, max = 6, message = "sbdqbm长度必须介于 1 和 6 之间")
	public String getSbdqbm() {
		return sbdqbm;
	}

	public void setSbdqbm(String sbdqbm) {
		this.sbdqbm = sbdqbm;
	}

	public String getDatastate() {
		return datastate;
	}

	public void setDatastate(String datastate) {
		this.datastate = datastate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCjrqsj() {
		return cjrqsj;
	}

	public void setCjrqsj(Date cjrqsj) {
		this.cjrqsj = cjrqsj;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getXgrqsj() {
		return xgrqsj;
	}

	public void setXgrqsj(Date xgrqsj) {
		this.xgrqsj = xgrqsj;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getScrqsj() {
		return scrqsj;
	}

	public void setScrqsj(Date scrqsj) {
		this.scrqsj = scrqsj;
	}

	@Length(min = 0, max = -1, message = "returnresult长度必须介于 0 和 -1 之间")
	public String getReturnresult() {
		return returnresult;
	}

	public void setReturnresult(String returnresult) {
		this.returnresult = returnresult;
	}

	@Length(min = 0, max = 50, message = "updateuser长度必须介于 0 和 50 之间")
	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}

	@Length(min = 0, max = 300, message = "tag长度必须介于 0 和 300 之间")
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getContracttypeLabel() {
		return contracttypeLabel;
	}

	public void setContracttypeLabel(String contracttypeLabel) {
		this.contracttypeLabel = contracttypeLabel;
	}

}