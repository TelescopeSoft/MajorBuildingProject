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
 * 安监申报Entity
 * @author huangzhengyu
 * @version 2018-07-14
 */
public class ApAjsbb extends DataEntity<ApAjsbb> {
	
	private static final long serialVersionUID = 1L;
	private String uuid;		// 安监申报表编号
	private String xmmc;		// 安监项目名称
	private String prjnum;		// 项目编号
	private String prjname;		// 立项项目名称
	private String ajjgmc;		// 安监申报表编号	c5dd7ed0-1a98-4443-8c63-7a25964be842	安监项目名称	江阴市人民法院霞客人民法庭审判业务用房（装修装饰工程） 项目编号	3202811507200102	立项项目名称	江阴市人民法院霞客人民法庭审判业务用房 安全监督机构名称
	private String ajcorpcode;		// AJ320281-1
	private String prjsize;		// 建设规模
	private String econcorpname;		// 建设单位名称
	private String econcorpcode;		// 建设单位组织机构代码
	private String prjapprovalnum;		// 立项批准文号
	private String buldplannum;		// 建设用地规划许可证号
	private String projectplannum;		// 建设工程规划许可证号
	private String citynum;		// 所在市州
	private String countynum;		// 所在县区
	private String prjtypenum;		// 项目分类
	private String sprjtypenum;		// 项目分类小类
	private String prjfunctionnum;		// 工程用途
	private String sbr;		// 申办人
	private String sbryddh;		// 申办人移动电话
	private Date createdate;		// 记录登记日期
	private String sfzps;		// 是否是装配式
	private String sfbz;		// 是否是保障房
	private Double jdz;		// 坐标经度
	private Double wdz;		// 坐标纬度
	private String mj;		// 项目面积
	private String zj;		// 项目造价
	private String jgcc;		// 结构层次
	private String sbmb;		// 申报目标
	private String sfjk;		// 是否符合安装远程监控条件
	private String sgxkz;		// 施工许可证号
	private String updateflag;		// 数据更新标识
	private Date fetchdate;		// fetchdate
	private Date updatetime;		// updatetime
	private String updateuser;		// updateuser
	private Date updatedate;		// 申报提交时间
	private String status;		// status
	
	public ApAjsbb() {
		super();
	}

	public ApAjsbb(String id){
		super(id);
	}

	@Length(min=1, max=50, message="安监申报表编号长度必须介于 1 和 50 之间")
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@Length(min=1, max=500, message="安监项目名称长度必须介于 1 和 500 之间")
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	
	@Length(min=1, max=20, message="项目编号长度必须介于 1 和 20 之间")
	public String getPrjnum() {
		return prjnum;
	}

	public void setPrjnum(String prjnum) {
		this.prjnum = prjnum;
	}
	
	@Length(min=1, max=500, message="立项项目名称长度必须介于 1 和 500 之间")
	public String getPrjname() {
		return prjname;
	}

	public void setPrjname(String prjname) {
		this.prjname = prjname;
	}
	
	@Length(min=1, max=200, message="安监申报表编号	c5dd7ed0-1a98-4443-8c63-7a25964be842	安监项目名称	江阴市人民法院霞客人民法庭审判业务用房（装修装饰工程） 项目编号	3202811507200102	立项项目名称	江阴市人民法院霞客人民法庭审判业务用房 安全监督机构名称长度必须介于 1 和 200 之间")
	public String getAjjgmc() {
		return ajjgmc;
	}

	public void setAjjgmc(String ajjgmc) {
		this.ajjgmc = ajjgmc;
	}
	
	@Length(min=1, max=18, message="AJ320281-1长度必须介于 1 和 18 之间")
	public String getAjcorpcode() {
		return ajcorpcode;
	}

	public void setAjcorpcode(String ajcorpcode) {
		this.ajcorpcode = ajcorpcode;
	}
	
	@Length(min=0, max=500, message="建设规模长度必须介于 0 和 500 之间")
	public String getPrjsize() {
		return prjsize;
	}

	public void setPrjsize(String prjsize) {
		this.prjsize = prjsize;
	}
	
	@Length(min=1, max=200, message="建设单位名称长度必须介于 1 和 200 之间")
	public String getEconcorpname() {
		return econcorpname;
	}

	public void setEconcorpname(String econcorpname) {
		this.econcorpname = econcorpname;
	}
	
	@Length(min=1, max=15, message="建设单位组织机构代码长度必须介于 1 和 15 之间")
	public String getEconcorpcode() {
		return econcorpcode;
	}

	public void setEconcorpcode(String econcorpcode) {
		this.econcorpcode = econcorpcode;
	}
	
	@Length(min=0, max=255, message="立项批准文号长度必须介于 0 和 255 之间")
	public String getPrjapprovalnum() {
		return prjapprovalnum;
	}

	public void setPrjapprovalnum(String prjapprovalnum) {
		this.prjapprovalnum = prjapprovalnum;
	}
	
	@Length(min=0, max=255, message="建设用地规划许可证号长度必须介于 0 和 255 之间")
	public String getBuldplannum() {
		return buldplannum;
	}

	public void setBuldplannum(String buldplannum) {
		this.buldplannum = buldplannum;
	}
	
	@Length(min=0, max=255, message="建设工程规划许可证号长度必须介于 0 和 255 之间")
	public String getProjectplannum() {
		return projectplannum;
	}

	public void setProjectplannum(String projectplannum) {
		this.projectplannum = projectplannum;
	}
	
	@Length(min=1, max=6, message="所在市州长度必须介于 1 和 6 之间")
	public String getCitynum() {
		return citynum;
	}

	public void setCitynum(String citynum) {
		this.citynum = citynum;
	}
	
	@Length(min=1, max=6, message="所在县区长度必须介于 1 和 6 之间")
	public String getCountynum() {
		return countynum;
	}

	public void setCountynum(String countynum) {
		this.countynum = countynum;
	}
	
	@Length(min=1, max=255, message="项目分类长度必须介于 1 和 255 之间")
	public String getPrjtypenum() {
		return prjtypenum;
	}

	public void setPrjtypenum(String prjtypenum) {
		this.prjtypenum = prjtypenum;
	}
	
	@Length(min=0, max=100, message="项目分类小类长度必须介于 0 和 100 之间")
	public String getSprjtypenum() {
		return sprjtypenum;
	}

	public void setSprjtypenum(String sprjtypenum) {
		this.sprjtypenum = sprjtypenum;
	}
	
	@Length(min=1, max=10, message="工程用途长度必须介于 1 和 10 之间")
	public String getPrjfunctionnum() {
		return prjfunctionnum;
	}

	public void setPrjfunctionnum(String prjfunctionnum) {
		this.prjfunctionnum = prjfunctionnum;
	}
	
	@Length(min=1, max=50, message="申办人长度必须介于 1 和 50 之间")
	public String getSbr() {
		return sbr;
	}

	public void setSbr(String sbr) {
		this.sbr = sbr;
	}
	
	@Length(min=1, max=15, message="申办人移动电话长度必须介于 1 和 15 之间")
	public String getSbryddh() {
		return sbryddh;
	}

	public void setSbryddh(String sbryddh) {
		this.sbryddh = sbryddh;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="记录登记日期不能为空")
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	@Length(min=0, max=50, message="是否是装配式长度必须介于 0 和 50 之间")
	public String getSfzps() {
		return sfzps;
	}

	public void setSfzps(String sfzps) {
		this.sfzps = sfzps;
	}
	
	@Length(min=0, max=50, message="是否是保障房长度必须介于 0 和 50 之间")
	public String getSfbz() {
		return sfbz;
	}

	public void setSfbz(String sfbz) {
		this.sfbz = sfbz;
	}
	
	public Double getJdz() {
		return jdz;
	}

	public void setJdz(Double jdz) {
		this.jdz = jdz;
	}
	
	public Double getWdz() {
		return wdz;
	}

	public void setWdz(Double wdz) {
		this.wdz = wdz;
	}
	
	public String getMj() {
		return mj;
	}

	public void setMj(String mj) {
		this.mj = mj;
	}
	
	public String getZj() {
		return zj;
	}

	public void setZj(String zj) {
		this.zj = zj;
	}
	
	@Length(min=0, max=200, message="结构层次长度必须介于 0 和 200 之间")
	public String getJgcc() {
		return jgcc;
	}

	public void setJgcc(String jgcc) {
		this.jgcc = jgcc;
	}
	
	@Length(min=0, max=100, message="申报目标长度必须介于 0 和 100 之间")
	public String getSbmb() {
		return sbmb;
	}

	public void setSbmb(String sbmb) {
		this.sbmb = sbmb;
	}
	
	@Length(min=0, max=50, message="是否符合安装远程监控条件长度必须介于 0 和 50 之间")
	public String getSfjk() {
		return sfjk;
	}

	public void setSfjk(String sfjk) {
		this.sfjk = sfjk;
	}
	
	@Length(min=0, max=50, message="施工许可证号长度必须介于 0 和 50 之间")
	public String getSgxkz() {
		return sgxkz;
	}

	public void setSgxkz(String sgxkz) {
		this.sgxkz = sgxkz;
	}
	
	@Length(min=1, max=1, message="数据更新标识长度必须介于 1 和 1 之间")
	public String getUpdateflag() {
		return updateflag;
	}

	public void setUpdateflag(String updateflag) {
		this.updateflag = updateflag;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="fetchdate不能为空")
	public Date getFetchdate() {
		return fetchdate;
	}

	public void setFetchdate(Date fetchdate) {
		this.fetchdate = fetchdate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="updatetime不能为空")
	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
	@Length(min=0, max=50, message="updateuser长度必须介于 0 和 50 之间")
	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}