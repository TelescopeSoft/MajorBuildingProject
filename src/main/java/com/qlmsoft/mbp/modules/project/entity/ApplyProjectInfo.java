/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qlmsoft.mbp.common.utils.StringUtils;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 发改申报项目基本信息Entity
 *
 * @author huangzhengyu
 * @version 2018-08-08
 */
public class ApplyProjectInfo extends DataEntity<ApplyProjectInfo> {

    private static final long serialVersionUID = 1L;
    private String projectCode;        // 项目代码
    private String divisionCode;        // 项目所属行政区划代码
    private String projectName;        // 项目名称
    private String projectType;        // 项目类型
    private String projectTypeLabel;
    private String projectNature;        // 建设性质
    private String projectNatureLabel;
    private String startYear;        // 拟开工时间
    private String endYear;        // 拟建成时间
    private BigDecimal totalMoney;        // 总投资额（万元）
    private String placeCode;        // 建设地点
    private String placeCodeDetail;        // 建设地点详情
    private String industry;        // 国标行业
    private String scaleContent;        // 建设规模及内容
    private String scaleContentPub;     //公示的建设规模及内容
    private Date applyDate;        // 申报时间
    private String permitItemCode;        // 投资项目目录编码
    private Date exchangeTime;        // exchange_time
    private String validityFlag;        // validity_flag
    private String nodeCode;        // node_code
    private String foreignAbroadFlag;        // foreign_abroad_flag
    private String totalMoneyExplain;        // total_money_explain
    private String theIndustry;        // the_industry
    private String isCountrySecurity;        // is_country_security
    private String securityApprovalNumber;        // security_approval_number
    private String investmentMode;        // investment_mode
    private String totalMoneyDollar;        // total_money_dollar
    private String totalMoneyDollarRate;        // total_money_dollar_rate
    private String projectCapitalMoney;        // project_capital_money
    private String projectCapitalMoneyDollar;        // project_capital_money_dollar
    private String projectCapitalMoneyDollarRate;        // project_capital_money_dollar_rate
    private String industrialPolicyType;        // industrial_policy_type
    private String industrialPolicy;        // industrial_policy
    private String otherInvestmentApplyInfo;        // other_investment_apply_info
    private String transactionBothInfo;        // transaction_both_info
    private String mergerPlan;        // merger_plan
    private String mergerManagementModeScope;        // merger_management_mode_scope
    private String getLandMode;        // get_land_mode
    private String landArea;        // land_area
    private String builtArea;        // built_area
    private String isAddDevice;        // is_add_device
    private String importDeviceNumberMoney;        // import_device_number_money
    private String projectSite;        // project_site
    private String chinaTotalMoney;        // china_total_money

    private String addressDetail;
    private String ydmj;
    private String xzydmj;
    private String nydmj;
    private String zjly;
    private String czzjly;
    private String xmzbj;
    private String enterpriseName;
    private String lerepCertType;
    private String lerepCertNo;
    private String catalogName;

    private String prjNum;
    private String notMatchPrj;

    private String majorFlag;

    private String displayFlag;

    private String applyDateStart;
    private String applyDateEnd;

    public ApplyProjectInfo() {
        super();
    }

    public ApplyProjectInfo(String id) {
        super(id);
    }

    @Length(min = 1, max = 32, message = "项目代码长度必须介于 1 和 32 之间")
    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Length(min = 1, max = 16, message = "项目所属行政区划代码长度必须介于 1 和 16 之间")
    public String getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    @Length(min = 1, max = 512, message = "项目名称长度必须介于 1 和 512 之间")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Length(min = 1, max = 6, message = "项目类型长度必须介于 1 和 6 之间")
    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    @Length(min = 1, max = 2, message = "建设性质长度必须介于 1 和 2 之间")
    public String getProjectNature() {
        return projectNature;
    }

    public void setProjectNature(String projectNature) {
        this.projectNature = projectNature;
    }

    @Length(min = 0, max = 6, message = "拟开工时间长度必须介于 0 和 6 之间")
    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    @Length(min = 0, max = 6, message = "拟建成时间长度必须介于 0 和 6 之间")
    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Length(min = 1, max = 16, message = "建设地点长度必须介于 1 和 16 之间")
    public String getPlaceCode() {
        return placeCode;
    }

    public void setPlaceCode(String placeCode) {
        this.placeCode = placeCode;
    }

    @Length(min = 1, max = 1024, message = "建设地点详情长度必须介于 1 和 1024 之间")
    public String getPlaceCodeDetail() {
        return placeCodeDetail;
    }

    public void setPlaceCodeDetail(String placeCodeDetail) {
        this.placeCodeDetail = placeCodeDetail;
    }

    @Length(min = 1, max = 6, message = "国标行业长度必须介于 1 和 6 之间")
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Length(min = 1, max = 4000, message = "建设规模及内容长度必须介于 1 和 4000 之间")
    public String getScaleContent() {
        return scaleContent;
    }

    public void setScaleContent(String scaleContent) {
        this.scaleContent = scaleContent;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "申报时间不能为空")
    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    @Length(min = 0, max = 50, message = "投资项目目录编码长度必须介于 0 和 50 之间")
    public String getPermitItemCode() {
        return permitItemCode;
    }

    public void setPermitItemCode(String permitItemCode) {
        this.permitItemCode = permitItemCode;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "exchange_time不能为空")
    public Date getExchangeTime() {
        return exchangeTime;
    }

    public void setExchangeTime(Date exchangeTime) {
        this.exchangeTime = exchangeTime;
    }

    @Length(min = 1, max = 2, message = "validity_flag长度必须介于 1 和 2 之间")
    public String getValidityFlag() {
        return validityFlag;
    }

    public void setValidityFlag(String validityFlag) {
        this.validityFlag = validityFlag;
    }

    @Length(min = 0, max = 6, message = "node_code长度必须介于 0 和 6 之间")
    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    @Length(min = 1, max = 2, message = "foreign_abroad_flag长度必须介于 1 和 2 之间")
    public String getForeignAbroadFlag() {
        return foreignAbroadFlag;
    }

    public void setForeignAbroadFlag(String foreignAbroadFlag) {
        this.foreignAbroadFlag = foreignAbroadFlag;
    }

    @Length(min = 0, max = 1024, message = "total_money_explain长度必须介于 0 和 1024 之间")
    public String getTotalMoneyExplain() {
        return totalMoneyExplain;
    }

    public void setTotalMoneyExplain(String totalMoneyExplain) {
        this.totalMoneyExplain = totalMoneyExplain;
    }

    @Length(min = 1, max = 16, message = "the_industry长度必须介于 1 和 16 之间")
    public String getTheIndustry() {
        return theIndustry;
    }

    public void setTheIndustry(String theIndustry) {
        this.theIndustry = theIndustry;
    }

    @Length(min = 0, max = 2, message = "is_country_security长度必须介于 0 和 2 之间")
    public String getIsCountrySecurity() {
        return isCountrySecurity;
    }

    public void setIsCountrySecurity(String isCountrySecurity) {
        this.isCountrySecurity = isCountrySecurity;
    }

    @Length(min = 0, max = 64, message = "security_approval_number长度必须介于 0 和 64 之间")
    public String getSecurityApprovalNumber() {
        return securityApprovalNumber;
    }

    public void setSecurityApprovalNumber(String securityApprovalNumber) {
        this.securityApprovalNumber = securityApprovalNumber;
    }

    @Length(min = 0, max = 6, message = "investment_mode长度必须介于 0 和 6 之间")
    public String getInvestmentMode() {
        return investmentMode;
    }

    public void setInvestmentMode(String investmentMode) {
        this.investmentMode = investmentMode;
    }

    @Length(min = 0, max = 16, message = "total_money_dollar长度必须介于 0 和 16 之间")
    public String getTotalMoneyDollar() {
        return totalMoneyDollar;
    }

    public void setTotalMoneyDollar(String totalMoneyDollar) {
        this.totalMoneyDollar = totalMoneyDollar;
    }

    @Length(min = 0, max = 16, message = "total_money_dollar_rate长度必须介于 0 和 16 之间")
    public String getTotalMoneyDollarRate() {
        return totalMoneyDollarRate;
    }

    public void setTotalMoneyDollarRate(String totalMoneyDollarRate) {
        this.totalMoneyDollarRate = totalMoneyDollarRate;
    }

    @Length(min = 0, max = 16, message = "project_capital_money长度必须介于 0 和 16 之间")
    public String getProjectCapitalMoney() {
        return projectCapitalMoney;
    }

    public void setProjectCapitalMoney(String projectCapitalMoney) {
        this.projectCapitalMoney = projectCapitalMoney;
    }

    @Length(min = 0, max = 16, message = "project_capital_money_dollar长度必须介于 0 和 16 之间")
    public String getProjectCapitalMoneyDollar() {
        return projectCapitalMoneyDollar;
    }

    public void setProjectCapitalMoneyDollar(String projectCapitalMoneyDollar) {
        this.projectCapitalMoneyDollar = projectCapitalMoneyDollar;
    }

    @Length(min = 0, max = 16, message = "project_capital_money_dollar_rate长度必须介于 0 和 16 之间")
    public String getProjectCapitalMoneyDollarRate() {
        return projectCapitalMoneyDollarRate;
    }

    public void setProjectCapitalMoneyDollarRate(String projectCapitalMoneyDollarRate) {
        this.projectCapitalMoneyDollarRate = projectCapitalMoneyDollarRate;
    }

    @Length(min = 0, max = 6, message = "industrial_policy_type长度必须介于 0 和 6 之间")
    public String getIndustrialPolicyType() {
        return industrialPolicyType;
    }

    public void setIndustrialPolicyType(String industrialPolicyType) {
        this.industrialPolicyType = industrialPolicyType;
    }

    @Length(min = 0, max = 16, message = "industrial_policy长度必须介于 0 和 16 之间")
    public String getIndustrialPolicy() {
        return industrialPolicy;
    }

    public void setIndustrialPolicy(String industrialPolicy) {
        this.industrialPolicy = industrialPolicy;
    }

    @Length(min = 0, max = 4000, message = "other_investment_apply_info长度必须介于 0 和 4000 之间")
    public String getOtherInvestmentApplyInfo() {
        return otherInvestmentApplyInfo;
    }

    public void setOtherInvestmentApplyInfo(String otherInvestmentApplyInfo) {
        this.otherInvestmentApplyInfo = otherInvestmentApplyInfo;
    }

    @Length(min = 0, max = 4000, message = "transaction_both_info长度必须介于 0 和 4000 之间")
    public String getTransactionBothInfo() {
        return transactionBothInfo;
    }

    public void setTransactionBothInfo(String transactionBothInfo) {
        this.transactionBothInfo = transactionBothInfo;
    }

    @Length(min = 0, max = 4000, message = "merger_plan长度必须介于 0 和 4000 之间")
    public String getMergerPlan() {
        return mergerPlan;
    }

    public void setMergerPlan(String mergerPlan) {
        this.mergerPlan = mergerPlan;
    }

    @Length(min = 0, max = 4000, message = "merger_management_mode_scope长度必须介于 0 和 4000 之间")
    public String getMergerManagementModeScope() {
        return mergerManagementModeScope;
    }

    public void setMergerManagementModeScope(String mergerManagementModeScope) {
        this.mergerManagementModeScope = mergerManagementModeScope;
    }

    @Length(min = 0, max = 6, message = "get_land_mode长度必须介于 0 和 6 之间")
    public String getGetLandMode() {
        return getLandMode;
    }

    public void setGetLandMode(String getLandMode) {
        this.getLandMode = getLandMode;
    }

    @Length(min = 0, max = 16, message = "land_area长度必须介于 0 和 16 之间")
    public String getLandArea() {
        return landArea;
    }

    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }

    @Length(min = 0, max = 16, message = "built_area长度必须介于 0 和 16 之间")
    public String getBuiltArea() {
        return builtArea;
    }

    public void setBuiltArea(String builtArea) {
        this.builtArea = builtArea;
    }

    @Length(min = 0, max = 6, message = "is_add_device长度必须介于 0 和 6 之间")
    public String getIsAddDevice() {
        return isAddDevice;
    }

    public void setIsAddDevice(String isAddDevice) {
        this.isAddDevice = isAddDevice;
    }

    @Length(min = 0, max = 128, message = "import_device_number_money长度必须介于 0 和 128 之间")
    public String getImportDeviceNumberMoney() {
        return importDeviceNumberMoney;
    }

    public void setImportDeviceNumberMoney(String importDeviceNumberMoney) {
        this.importDeviceNumberMoney = importDeviceNumberMoney;
    }

    @Length(min = 0, max = 256, message = "project_site长度必须介于 0 和 256 之间")
    public String getProjectSite() {
        return projectSite;
    }

    public void setProjectSite(String projectSite) {
        this.projectSite = projectSite;
    }

    @Length(min = 0, max = 6, message = "china_total_money长度必须介于 0 和 6 之间")
    public String getChinaTotalMoney() {
        return chinaTotalMoney;
    }

    public void setChinaTotalMoney(String chinaTotalMoney) {
        this.chinaTotalMoney = chinaTotalMoney;
    }

    public String getProjectTypeLabel() {
        return projectTypeLabel;
    }

    public void setProjectTypeLabel(String projectTypeLabel) {
        this.projectTypeLabel = projectTypeLabel;
    }

    public String getProjectNatureLabel() {
        return projectNatureLabel;
    }

    public void setProjectNatureLabel(String projectNatureLabel) {
        this.projectNatureLabel = projectNatureLabel;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getYdmj() {
        return ydmj;
    }

    public void setYdmj(String ydmj) {
        this.ydmj = ydmj;
    }

    public String getXzydmj() {
        return xzydmj;
    }

    public void setXzydmj(String xzydmj) {
        this.xzydmj = xzydmj;
    }

    public String getNydmj() {
        return nydmj;
    }

    public void setNydmj(String nydmj) {
        this.nydmj = nydmj;
    }

    public String getZjly() {
        return zjly;
    }

    public void setZjly(String zjly) {
        this.zjly = zjly;
    }

    public String getCzzjly() {
        return czzjly;
    }

    public void setCzzjly(String czzjly) {
        this.czzjly = czzjly;
    }

    public String getXmzbj() {
        return xmzbj;
    }

    public void setXmzbj(String xmzbj) {
        this.xmzbj = xmzbj;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getLerepCertType() {
        return lerepCertType;
    }

    public void setLerepCertType(String lerepCertType) {
        this.lerepCertType = lerepCertType;
    }

    public String getLerepCertNo() {
        return lerepCertNo;
    }

    public void setLerepCertNo(String lerepCertNo) {
        this.lerepCertNo = lerepCertNo;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getPrjNum() {
        return prjNum;
    }

    public void setPrjNum(String prjNum) {
        this.prjNum = prjNum;
    }

    public String getNotMatchPrj() {
        return notMatchPrj;
    }

    public void setNotMatchPrj(String notMatchPrj) {
        this.notMatchPrj = notMatchPrj;
    }

    public String getMajorFlag() {
        return majorFlag;
    }

    public void setMajorFlag(String majorFlag) {
        this.majorFlag = majorFlag;
    }

    @JsonIgnore
    public String getDisplayFlag() {
        return displayFlag;
    }

    public void setDisplayFlag(String displayFlag) {
        this.displayFlag = displayFlag;
    }

    public String getApplyDateStart() {
        return applyDateStart;
    }

    public void setApplyDateStart(String applyDateStart) {
        this.applyDateStart = applyDateStart;
    }

    public String getApplyDateEnd() {
        return applyDateEnd;
    }

    public void setApplyDateEnd(String applyDateEnd) {
        this.applyDateEnd = applyDateEnd;
    }

    public String getScaleContentPub() {
        return scaleContentPub;
    }

    public void setScaleContentPub(String scaleContentPub) {
        this.scaleContentPub = scaleContentPub;
    }

    public List<String> getProjectTypeList() {
        List<String> result = new ArrayList<String>();
        if(StringUtils.isNotEmpty(this.getProjectType())){
            String[] types = this.getProjectType().split(",");
            for(String t : types){
                result.add(t);
            }
        }
        return result;
    }
}
