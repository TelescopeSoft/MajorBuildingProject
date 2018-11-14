/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 行政处罚Entity
 * 
 * @author huangzhengyu
 * @version 2018-07-15
 */
public class PubAdminPenalty extends DataEntity<PubAdminPenalty> {

	private static final long serialVersionUID = 1L;
	private String adminRelativePerson; // 行政相对人名称
	private String letterOfDecision; // 行政处罚决定书文号
	private String name; // 处罚名称
	private Date punishmentDecisionDate; // 处罚决定日期
	private String punishDeptLabel; // 处罚机关
	private String punishCategory; // 处罚类别
	private String punishReason; // 处罚事由
	private String punishBasis; // 处罚依据
	private String adminRelativePersonCode; // 行政相对人代码 (统一社会信用代码)
	private String legalRepresentative; // 法定代表人姓名
	private String punishResult; // 处罚结果
	private String county; // 地方编码
	private Date publicDeadline; // 公示截止期
	private String displayFlag; // 显示标识

	private String prjNum; // 工程项目编号

	public PubAdminPenalty() {
		super();
	}

	public PubAdminPenalty(String id) {
		super(id);
	}

	@Length(min = 0, max = 100, message = "行政相对人名称长度必须介于 0 和 100 之间")
	public String getAdminRelativePerson() {
		return adminRelativePerson;
	}

	public void setAdminRelativePerson(String adminRelativePerson) {
		this.adminRelativePerson = adminRelativePerson;
	}

	@Length(min = 0, max = 64, message = "行政处罚决定书文号长度必须介于 0 和 64 之间")
	public String getLetterOfDecision() {
		return letterOfDecision;
	}

	public void setLetterOfDecision(String letterOfDecision) {
		this.letterOfDecision = letterOfDecision;
	}

	@Length(min = 0, max = 255, message = "处罚名称长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPunishmentDecisionDate() {
		return punishmentDecisionDate;
	}

	public void setPunishmentDecisionDate(Date punishmentDecisionDate) {
		this.punishmentDecisionDate = punishmentDecisionDate;
	}

	@Length(min = 0, max = 64, message = "处罚机关长度必须介于 0 和 64 之间")
	public String getPunishDeptLabel() {
		return punishDeptLabel;
	}

	public void setPunishDeptLabel(String punishDeptLabel) {
		this.punishDeptLabel = punishDeptLabel;
	}

	@Length(min = 0, max = 64, message = "处罚类别长度必须介于 0 和 64 之间")
	public String getPunishCategory() {
		return punishCategory;
	}

	public void setPunishCategory(String punishCategory) {
		this.punishCategory = punishCategory;
	}

	@Length(min = 0, max = 255, message = "处罚事由长度必须介于 0 和 255 之间")
	public String getPunishReason() {
		return punishReason;
	}

	public void setPunishReason(String punishReason) {
		this.punishReason = punishReason;
	}

	@Length(min = 0, max = 255, message = "处罚依据长度必须介于 0 和 255 之间")
	public String getPunishBasis() {
		return punishBasis;
	}

	public void setPunishBasis(String punishBasis) {
		this.punishBasis = punishBasis;
	}

	@Length(min = 0, max = 100, message = "行政相对人代码 (统一社会信用代码)长度必须介于 0 和 100 之间")
	public String getAdminRelativePersonCode() {
		return adminRelativePersonCode;
	}

	public void setAdminRelativePersonCode(String adminRelativePersonCode) {
		this.adminRelativePersonCode = adminRelativePersonCode;
	}

	@Length(min = 0, max = 100, message = "法定代表人姓名长度必须介于 0 和 100 之间")
	public String getLegalRepresentative() {
		return legalRepresentative;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	@Length(min = 0, max = 255, message = "处罚结果长度必须介于 0 和 255 之间")
	public String getPunishResult() {
		return punishResult;
	}

	public void setPunishResult(String punishResult) {
		this.punishResult = punishResult;
	}

	@Length(min = 0, max = 20, message = "地方编码长度必须介于 0 和 20 之间")
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPublicDeadline() {
		return publicDeadline;
	}

	public void setPublicDeadline(Date publicDeadline) {
		this.publicDeadline = publicDeadline;
	}

	@Length(min = 0, max = 1, message = "显示标识长度必须介于 0 和 1 之间")
	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

}