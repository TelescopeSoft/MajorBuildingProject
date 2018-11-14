/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import com.qlmsoft.mbp.common.utils.JaxbDateAdapter;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.qlmsoft.mbp.common.persistence.DataEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 质量报监单位人员Entity
 * @author huangzhengyu
 * @version 2018-07-15
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class ApZjsbbDwry extends DataEntity<ApZjsbbDwry> {
	
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "uuid")
	private String uuid;		// 质监申报表编号

	@XmlElement(name = "idCard")
	private String idcard;		// 身份证号码
	private String dwlx;		// 单位类别

	@XmlElement(name = "CorpCode")
	private String corpcode;		// 单位组织机构代码

	@XmlElement(name = "CorpName")
	private String corpname;		// 单位名称
	private String zzzs;		// 资质证书编号
	private String zzlxdj;		// 资质类型和等级
	private String zzyxq;		// 资质有效期
	private String dwdz;		// 单位地址
	private String fddbr;		// 法定代表人
	private String fddbrsfz;		// 法定代表人身份证号
	private String dwlxdh;		// 单位联系电话
	private String xm;		// 姓名
	private String gw;		// 岗位
	private String lxdh;		// 联系电话
	private String zgzh;		// 资格类型及证号
	private String zgdj;		// 资格等级
	private String zy;		// 专业

	@XmlElement(name = "jhjcsj")
	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	private Date jhjcsj;		// 计划进场时间

	@XmlElement(name = "jhccsj")
	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	private Date jhccsj;		// 计划出场时间
	private String lhtsx;		// 联合体属性
	private String zyzgzsh;		// 执业资格证书号
	private String zyzgdj;		// 执业资格等级
	
	public ApZjsbbDwry() {
		super();
	}

	public ApZjsbbDwry(String id){
		super(id);
	}

	@Length(min=1, max=50, message="质监申报表编号长度必须介于 1 和 50 之间")
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@Length(min=1, max=50, message="身份证号码长度必须介于 1 和 50 之间")
	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	@Length(min=1, max=20, message="单位类别长度必须介于 1 和 20 之间")
	public String getDwlx() {
		return dwlx;
	}

	public void setDwlx(String dwlx) {
		this.dwlx = dwlx;
	}
	
	@Length(min=1, max=18, message="单位组织机构代码长度必须介于 1 和 18 之间")
	public String getCorpcode() {
		return corpcode;
	}

	public void setCorpcode(String corpcode) {
		this.corpcode = corpcode;
	}
	
	@Length(min=1, max=255, message="单位名称长度必须介于 1 和 255 之间")
	public String getCorpname() {
		return corpname;
	}

	public void setCorpname(String corpname) {
		this.corpname = corpname;
	}
	
	@Length(min=0, max=255, message="资质证书编号长度必须介于 0 和 255 之间")
	public String getZzzs() {
		return zzzs;
	}

	public void setZzzs(String zzzs) {
		this.zzzs = zzzs;
	}
	
	@Length(min=0, max=255, message="资质类型和等级长度必须介于 0 和 255 之间")
	public String getZzlxdj() {
		return zzlxdj;
	}

	public void setZzlxdj(String zzlxdj) {
		this.zzlxdj = zzlxdj;
	}
	
	@Length(min=0, max=255, message="资质有效期长度必须介于 0 和 255 之间")
	public String getZzyxq() {
		return zzyxq;
	}

	public void setZzyxq(String zzyxq) {
		this.zzyxq = zzyxq;
	}
	
	@Length(min=0, max=255, message="单位地址长度必须介于 0 和 255 之间")
	public String getDwdz() {
		return dwdz;
	}

	public void setDwdz(String dwdz) {
		this.dwdz = dwdz;
	}
	
	@Length(min=0, max=50, message="法定代表人长度必须介于 0 和 50 之间")
	public String getFddbr() {
		return fddbr;
	}

	public void setFddbr(String fddbr) {
		this.fddbr = fddbr;
	}
	
	@Length(min=0, max=50, message="法定代表人身份证号长度必须介于 0 和 50 之间")
	public String getFddbrsfz() {
		return fddbrsfz;
	}

	public void setFddbrsfz(String fddbrsfz) {
		this.fddbrsfz = fddbrsfz;
	}
	
	@Length(min=0, max=50, message="单位联系电话长度必须介于 0 和 50 之间")
	public String getDwlxdh() {
		return dwlxdh;
	}

	public void setDwlxdh(String dwlxdh) {
		this.dwlxdh = dwlxdh;
	}
	
	@Length(min=1, max=50, message="姓名长度必须介于 1 和 50 之间")
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}
	
	@Length(min=1, max=50, message="岗位长度必须介于 1 和 50 之间")
	public String getGw() {
		return gw;
	}

	public void setGw(String gw) {
		this.gw = gw;
	}
	
	@Length(min=1, max=50, message="联系电话长度必须介于 1 和 50 之间")
	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	
	@Length(min=0, max=50, message="资格类型及证号长度必须介于 0 和 50 之间")
	public String getZgzh() {
		return zgzh;
	}

	public void setZgzh(String zgzh) {
		this.zgzh = zgzh;
	}
	
	@Length(min=0, max=50, message="资格等级长度必须介于 0 和 50 之间")
	public String getZgdj() {
		return zgdj;
	}

	public void setZgdj(String zgdj) {
		this.zgdj = zgdj;
	}
	
	@Length(min=0, max=50, message="专业长度必须介于 0 和 50 之间")
	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getJhjcsj() {
		return jhjcsj;
	}

	public void setJhjcsj(Date jhjcsj) {
		this.jhjcsj = jhjcsj;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getJhccsj() {
		return jhccsj;
	}

	public void setJhccsj(Date jhccsj) {
		this.jhccsj = jhccsj;
	}
	
	@Length(min=0, max=1, message="联合体属性长度必须介于 0 和 1 之间")
	public String getLhtsx() {
		return lhtsx;
	}

	public void setLhtsx(String lhtsx) {
		this.lhtsx = lhtsx;
	}
	
	@Length(min=0, max=50, message="执业资格证书号长度必须介于 0 和 50 之间")
	public String getZyzgzsh() {
		return zyzgzsh;
	}

	public void setZyzgzsh(String zyzgzsh) {
		this.zyzgzsh = zyzgzsh;
	}
	
	@Length(min=0, max=100, message="执业资格等级长度必须介于 0 和 100 之间")
	public String getZyzgdj() {
		return zyzgdj;
	}

	public void setZyzgdj(String zyzgdj) {
		this.zyzgdj = zyzgdj;
	}
	
}