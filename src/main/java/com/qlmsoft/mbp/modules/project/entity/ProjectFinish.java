
package com.qlmsoft.mbp.modules.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qlmsoft.mbp.common.persistence.ProjectDataEntity;
import com.qlmsoft.mbp.common.utils.JaxbDateAdapter;
import com.qlmsoft.mbp.common.utils.JaxbDateAdapter2;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * 竣工备案Entity
 * 
 * @author huangzhengyu
 * @version 2018-07-14
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectFinish extends ProjectDataEntity<ProjectFinish> {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "PKID")
	private String pkid; // pkid

	@XmlElement(name = "PrjFinishName")
	private String prjfinishname; // 备案项目名称

	@XmlElement(name = "PrjFinishNum")
	private String prjfinishnum; // 竣工备案编号

	@XmlElement(name = "PrjFinishInnerNum")
	private String prjfinishinnernum; // 竣工备案内部编号

	@XmlElement(name = "PrjNum")
	private String prjnum; // 项目编号

	@XmlElement(name = "BuilderLicenceNum")
	private String builderlicencenum; // 施工许可证编号

	@XmlElement(name = "QCCorpName")
	private String qccorpname; // 质量检测机构名称

	@XmlElement(name = "QCCorpCode")
	private String qccorpcode; // 质量检测机构组织机构代码（社会信用代码）

	@XmlElement(name = "FactCost")
	private Double factcost; // 实际造价（万元）

	@XmlElement(name = "FactArea")
	private Double factarea; // 实际面积（平方米）

	@XmlElement(name = "FactSize")
	private String factsize; // 实际建设规模

	@XmlElement(name = "PrjStructureTypeNum")
	private String prjstructuretypenum; // 结构体系

	private String prjstructuretypenumLabel; // 结构体系文字

	@XmlElement(name = "BDate")
	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	private Date bdate; // 实际开工日期

	@XmlElement(name = "EDate")
	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	private Date edate; // 实际竣工验收日期

	@XmlElement(name = "Mark")
	private String mark; // 备注

	@XmlElement(name = "CreateDate")
	@XmlJavaTypeAdapter(JaxbDateAdapter2.class)
	private Date createdate; // 记录登记时间

	@XmlElement(name = "UpdateFlag")
	private String updateflag; // 数据更新标识
	private String sbdqbm; // 上报地区编码
	private String datastate; // datastate
	private Date cjrqsj; // cjrqsj
	private Date xgrqsj; // xgrqsj
	private Date scrqsj; // scrqsj
	private String returnresult; // returnresult
	private String updateuser; // updateuser
	private String tag; // tag

	public ProjectFinish() {
		super();
	}

	public ProjectFinish(String id) {
		super(id);
	}

	@Length(min = 1, max = 50, message = "pkid长度必须介于 1 和 50 之间")
	public String getPkid() {
		return pkid;
	}

	public void setPkid(String pkid) {
		this.pkid = pkid;
	}

	@Length(min = 1, max = 200, message = "备案项目名称长度必须介于 1 和 200 之间")
	public String getPrjfinishname() {
		return prjfinishname;
	}

	public void setPrjfinishname(String prjfinishname) {
		this.prjfinishname = prjfinishname;
	}

	@Length(min = 1, max = 50, message = "竣工备案编号长度必须介于 1 和 50 之间")
	public String getPrjfinishnum() {
		return prjfinishnum;
	}

	public void setPrjfinishnum(String prjfinishnum) {
		this.prjfinishnum = prjfinishnum;
	}

	@Length(min = 1, max = 50, message = "竣工备案内部编号长度必须介于 1 和 50 之间")
	public String getPrjfinishinnernum() {
		return prjfinishinnernum;
	}

	public void setPrjfinishinnernum(String prjfinishinnernum) {
		this.prjfinishinnernum = prjfinishinnernum;
	}

	@Length(min = 1, max = 20, message = "项目编号长度必须介于 1 和 20 之间")
	public String getPrjnum() {
		return prjnum;
	}

	public void setPrjnum(String prjnum) {
		this.prjnum = prjnum;
	}

	@Length(min = 1, max = 50, message = "施工许可证编号长度必须介于 1 和 50 之间")
	public String getBuilderlicencenum() {
		return builderlicencenum;
	}

	public void setBuilderlicencenum(String builderlicencenum) {
		this.builderlicencenum = builderlicencenum;
	}

	@Length(min = 0, max = 200, message = "质量检测机构名称长度必须介于 0 和 200 之间")
	public String getQccorpname() {
		return qccorpname;
	}

	public void setQccorpname(String qccorpname) {
		this.qccorpname = qccorpname;
	}

	@Length(min = 0, max = 18, message = "质量检测机构组织机构代码（社会信用代码）长度必须介于 0 和 18 之间")
	public String getQccorpcode() {
		return qccorpcode;
	}

	public void setQccorpcode(String qccorpcode) {
		this.qccorpcode = qccorpcode;
	}

	@NotNull(message = "实际造价（万元）不能为空")
	public Double getFactcost() {
		return factcost;
	}

	public void setFactcost(Double factcost) {
		this.factcost = factcost;
	}

	@NotNull(message = "实际面积（平方米）不能为空")
	public Double getFactarea() {
		return factarea;
	}

	public void setFactarea(Double factarea) {
		this.factarea = factarea;
	}

	@Length(min = 0, max = 500, message = "实际建设规模长度必须介于 0 和 500 之间")
	public String getFactsize() {
		return factsize;
	}

	public void setFactsize(String factsize) {
		this.factsize = factsize;
	}

	@Length(min = 0, max = 3, message = "结构体系长度必须介于 0 和 3 之间")
	public String getPrjstructuretypenum() {
		return prjstructuretypenum;
	}

	public void setPrjstructuretypenum(String prjstructuretypenum) {
		this.prjstructuretypenum = prjstructuretypenum;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "实际开工日期不能为空")
	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "实际竣工验收日期不能为空")
	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	@Length(min = 0, max = 500, message = "备注长度必须介于 0 和 500 之间")
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "记录登记时间不能为空")
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Length(min = 1, max = 1, message = "数据更新标识长度必须介于 1 和 1 之间")
	public String getUpdateflag() {
		return updateflag;
	}

	public void setUpdateflag(String updateflag) {
		this.updateflag = updateflag;
	}

	@Length(min = 1, max = 6, message = "上报地区编码长度必须介于 1 和 6 之间")
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

	@Length(min = 0, max = 100, message = "tag长度必须介于 0 和 100 之间")
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getPrjstructuretypenumLabel() {
		return prjstructuretypenumLabel;
	}

	public void setPrjstructuretypenumLabel(String prjstructuretypenumLabel) {
		this.prjstructuretypenumLabel = prjstructuretypenumLabel;
	}

}