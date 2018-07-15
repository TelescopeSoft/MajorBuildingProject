/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 施工许可信息Entity
 * @author huangzhengyu
 * @version 2018-07-15
 */
public class ProjectBuilderLicence extends DataEntity<ProjectBuilderLicence> {
	
	private static final long serialVersionUID = 1L;
	private String pkid;		// pkid
	private String builderlicencename;		// 施工许可项目名称
	private String builderlicencenum;		// 施工许可证编号
	private String builderlicenceinnernum;		// 施工许可证内部编号
	private String recordinnernum;		// 合同备案编码
	private String prjnum;		// 项目编号
	private String buldplannum;		// 建设用地规划许可证编号
	private String projectplannum;		// 建设工程规划许可证编号
	private String censornum;		// 施工图审查合格书编号
	private String contractmoney;		// 合同金额(万元)
	private String area;		// 面积（平方米）
	private String prjsize;		// 建设规模
	private Date issuecertdate;		// 发证日期
	private String econcorpname;		// 勘察单位名称
	private String econcorpcode;		// 勘察单位组织机构代码（社会信用代码
	private String designcorpname;		// 设计单位名称
	private String designcorpcode;		// 设计单位组织机构代码（社会信用代码）
	private String conscorpname;		// 施工单位名称
	private String conscorpcode;		// 施工单位组织机构代码（社会信用代码
	private String safetycerid;		// 施工单位安全生产许可证编号
	private String supercorpname;		// 监理单位名称
	private String supercorpcode;		// 监理单位组织机构代码（社会信用代码）
	private String constructorname;		// 项目经理姓名
	private String cidcardtypenum;		// 项目经理证件类型
	private String constructoridcard;		// 项目经理证件号码
	private String constructorphone;		// 项目经理电话号码
	private String supervisionname;		// 总监理工程师姓名
	private String sidcardtypenum;		// 总监理工程师证件类型
	private String supervisionidcard;		// 总监理工程师证件号码
	private String supervisionphone;		// 总监理工程师电话
	private Date createdate;		// 记录登记时间
	private String updateflag;		// 数据更新标识
	private String sbdqbm;		// 上报地区编码
	private String datastate;		// datastate
	private Date cjrqsj;		// cjrqsj
	private Date xgrqsj;		// xgrqsj
	private Date scrqsj;		// scrqsj
	private String returnresult;		// returnresult
	private String updateuser;		// updateuser
	private String xzspSgxk;		// xzsp_sgxk
	
	public ProjectBuilderLicence() {
		super();
	}

	public ProjectBuilderLicence(String id){
		super(id);
	}

	@Length(min=1, max=50, message="pkid长度必须介于 1 和 50 之间")
	public String getPkid() {
		return pkid;
	}

	public void setPkid(String pkid) {
		this.pkid = pkid;
	}
	
	@Length(min=1, max=200, message="施工许可项目名称长度必须介于 1 和 200 之间")
	public String getBuilderlicencename() {
		return builderlicencename;
	}

	public void setBuilderlicencename(String builderlicencename) {
		this.builderlicencename = builderlicencename;
	}
	
	@Length(min=1, max=50, message="施工许可证编号长度必须介于 1 和 50 之间")
	public String getBuilderlicencenum() {
		return builderlicencenum;
	}

	public void setBuilderlicencenum(String builderlicencenum) {
		this.builderlicencenum = builderlicencenum;
	}
	
	@Length(min=1, max=50, message="施工许可证内部编号长度必须介于 1 和 50 之间")
	public String getBuilderlicenceinnernum() {
		return builderlicenceinnernum;
	}

	public void setBuilderlicenceinnernum(String builderlicenceinnernum) {
		this.builderlicenceinnernum = builderlicenceinnernum;
	}
	
	@Length(min=0, max=50, message="合同备案编码长度必须介于 0 和 50 之间")
	public String getRecordinnernum() {
		return recordinnernum;
	}

	public void setRecordinnernum(String recordinnernum) {
		this.recordinnernum = recordinnernum;
	}
	
	@Length(min=1, max=20, message="项目编号长度必须介于 1 和 20 之间")
	public String getPrjnum() {
		return prjnum;
	}

	public void setPrjnum(String prjnum) {
		this.prjnum = prjnum;
	}
	
	@Length(min=0, max=100, message="建设用地规划许可证编号长度必须介于 0 和 100 之间")
	public String getBuldplannum() {
		return buldplannum;
	}

	public void setBuldplannum(String buldplannum) {
		this.buldplannum = buldplannum;
	}
	
	@Length(min=0, max=100, message="建设工程规划许可证编号长度必须介于 0 和 100 之间")
	public String getProjectplannum() {
		return projectplannum;
	}

	public void setProjectplannum(String projectplannum) {
		this.projectplannum = projectplannum;
	}
	
	@Length(min=0, max=50, message="施工图审查合格书编号长度必须介于 0 和 50 之间")
	public String getCensornum() {
		return censornum;
	}

	public void setCensornum(String censornum) {
		this.censornum = censornum;
	}
	
	public String getContractmoney() {
		return contractmoney;
	}

	public void setContractmoney(String contractmoney) {
		this.contractmoney = contractmoney;
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Length(min=0, max=500, message="建设规模长度必须介于 0 和 500 之间")
	public String getPrjsize() {
		return prjsize;
	}

	public void setPrjsize(String prjsize) {
		this.prjsize = prjsize;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="发证日期不能为空")
	public Date getIssuecertdate() {
		return issuecertdate;
	}

	public void setIssuecertdate(Date issuecertdate) {
		this.issuecertdate = issuecertdate;
	}
	
	@Length(min=1, max=200, message="勘察单位名称长度必须介于 1 和 200 之间")
	public String getEconcorpname() {
		return econcorpname;
	}

	public void setEconcorpname(String econcorpname) {
		this.econcorpname = econcorpname;
	}
	
	@Length(min=0, max=50, message="勘察单位组织机构代码（社会信用代码长度必须介于 0 和 50 之间")
	public String getEconcorpcode() {
		return econcorpcode;
	}

	public void setEconcorpcode(String econcorpcode) {
		this.econcorpcode = econcorpcode;
	}
	
	@Length(min=1, max=200, message="设计单位名称长度必须介于 1 和 200 之间")
	public String getDesigncorpname() {
		return designcorpname;
	}

	public void setDesigncorpname(String designcorpname) {
		this.designcorpname = designcorpname;
	}
	
	@Length(min=0, max=50, message="设计单位组织机构代码（社会信用代码）长度必须介于 0 和 50 之间")
	public String getDesigncorpcode() {
		return designcorpcode;
	}

	public void setDesigncorpcode(String designcorpcode) {
		this.designcorpcode = designcorpcode;
	}
	
	@Length(min=1, max=200, message="施工单位名称长度必须介于 1 和 200 之间")
	public String getConscorpname() {
		return conscorpname;
	}

	public void setConscorpname(String conscorpname) {
		this.conscorpname = conscorpname;
	}
	
	@Length(min=0, max=50, message="施工单位组织机构代码（社会信用代码长度必须介于 0 和 50 之间")
	public String getConscorpcode() {
		return conscorpcode;
	}

	public void setConscorpcode(String conscorpcode) {
		this.conscorpcode = conscorpcode;
	}
	
	@Length(min=0, max=100, message="施工单位安全生产许可证编号长度必须介于 0 和 100 之间")
	public String getSafetycerid() {
		return safetycerid;
	}

	public void setSafetycerid(String safetycerid) {
		this.safetycerid = safetycerid;
	}
	
	@Length(min=1, max=200, message="监理单位名称长度必须介于 1 和 200 之间")
	public String getSupercorpname() {
		return supercorpname;
	}

	public void setSupercorpname(String supercorpname) {
		this.supercorpname = supercorpname;
	}
	
	@Length(min=0, max=50, message="监理单位组织机构代码（社会信用代码）长度必须介于 0 和 50 之间")
	public String getSupercorpcode() {
		return supercorpcode;
	}

	public void setSupercorpcode(String supercorpcode) {
		this.supercorpcode = supercorpcode;
	}
	
	@Length(min=1, max=50, message="项目经理姓名长度必须介于 1 和 50 之间")
	public String getConstructorname() {
		return constructorname;
	}

	public void setConstructorname(String constructorname) {
		this.constructorname = constructorname;
	}
	
	@Length(min=1, max=1, message="项目经理证件类型长度必须介于 1 和 1 之间")
	public String getCidcardtypenum() {
		return cidcardtypenum;
	}

	public void setCidcardtypenum(String cidcardtypenum) {
		this.cidcardtypenum = cidcardtypenum;
	}
	
	@Length(min=1, max=30, message="项目经理证件号码长度必须介于 1 和 30 之间")
	public String getConstructoridcard() {
		return constructoridcard;
	}

	public void setConstructoridcard(String constructoridcard) {
		this.constructoridcard = constructoridcard;
	}
	
	@Length(min=0, max=50, message="项目经理电话号码长度必须介于 0 和 50 之间")
	public String getConstructorphone() {
		return constructorphone;
	}

	public void setConstructorphone(String constructorphone) {
		this.constructorphone = constructorphone;
	}
	
	@Length(min=1, max=50, message="总监理工程师姓名长度必须介于 1 和 50 之间")
	public String getSupervisionname() {
		return supervisionname;
	}

	public void setSupervisionname(String supervisionname) {
		this.supervisionname = supervisionname;
	}
	
	@Length(min=1, max=1, message="总监理工程师证件类型长度必须介于 1 和 1 之间")
	public String getSidcardtypenum() {
		return sidcardtypenum;
	}

	public void setSidcardtypenum(String sidcardtypenum) {
		this.sidcardtypenum = sidcardtypenum;
	}
	
	@Length(min=1, max=30, message="总监理工程师证件号码长度必须介于 1 和 30 之间")
	public String getSupervisionidcard() {
		return supervisionidcard;
	}

	public void setSupervisionidcard(String supervisionidcard) {
		this.supervisionidcard = supervisionidcard;
	}
	
	@Length(min=0, max=50, message="总监理工程师电话长度必须介于 0 和 50 之间")
	public String getSupervisionphone() {
		return supervisionphone;
	}

	public void setSupervisionphone(String supervisionphone) {
		this.supervisionphone = supervisionphone;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="记录登记时间不能为空")
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	@Length(min=1, max=1, message="数据更新标识长度必须介于 1 和 1 之间")
	public String getUpdateflag() {
		return updateflag;
	}

	public void setUpdateflag(String updateflag) {
		this.updateflag = updateflag;
	}
	
	@Length(min=1, max=6, message="上报地区编码长度必须介于 1 和 6 之间")
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
	
	@Length(min=0, max=-1, message="returnresult长度必须介于 0 和 -1 之间")
	public String getReturnresult() {
		return returnresult;
	}

	public void setReturnresult(String returnresult) {
		this.returnresult = returnresult;
	}
	
	@Length(min=0, max=50, message="updateuser长度必须介于 0 和 50 之间")
	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}
	
	@Length(min=0, max=20, message="xzsp_sgxk长度必须介于 0 和 20 之间")
	public String getXzspSgxk() {
		return xzspSgxk;
	}

	public void setXzspSgxk(String xzspSgxk) {
		this.xzspSgxk = xzspSgxk;
	}
	
}