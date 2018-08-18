/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlmsoft.mbp.common.persistence;

import com.qlmsoft.mbp.modules.sys.entity.User;
import com.qlmsoft.mbp.modules.sys.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 发改项目数据Entity类
 *
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class ProjectDataEntity<T> extends DataEntity<T> {

    private static final long serialVersionUID = 1L;

    private String projectCode;

    protected BigDecimal totalMoney;

    public ProjectDataEntity() {
        super();
        this.delFlag = DEL_FLAG_NORMAL;
    }

    public ProjectDataEntity(String id) {
        super(id);
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }
}
