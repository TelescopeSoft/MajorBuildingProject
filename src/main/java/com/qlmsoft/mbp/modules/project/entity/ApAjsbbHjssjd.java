
package com.qlmsoft.mbp.modules.project.entity;

import org.hibernate.validator.constraints.Length;

import com.qlmsoft.mbp.common.persistence.DataEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 安监申报环境交底Entity
 * @author huangzhengyu
 * @version 2018-08-01
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ApAjsbbHjssjd extends DataEntity<ApAjsbbHjssjd> {
	
	private static final long serialVersionUID = 1L;

	private String uuid;		// uuid
	private String xh;		// xh
	private String jdxm;		// jdxm
	private String jdqk;		// jdqk
	
	public ApAjsbbHjssjd() {
		super();
	}

	public ApAjsbbHjssjd(String id){
		super(id);
	}

	@Length(min=1, max=50, message="uuid长度必须介于 1 和 50 之间")
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}
	
	@Length(min=1, max=255, message="jdxm长度必须介于 1 和 255 之间")
	public String getJdxm() {
		return jdxm;
	}

	public void setJdxm(String jdxm) {
		this.jdxm = jdxm;
	}
	
	@Length(min=1, max=255, message="jdqk长度必须介于 1 和 255 之间")
	public String getJdqk() {
		return jdqk;
	}

	public void setJdqk(String jdqk) {
		this.jdqk = jdqk;
	}
	
}