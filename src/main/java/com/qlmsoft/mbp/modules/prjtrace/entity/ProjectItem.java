
package com.qlmsoft.mbp.modules.prjtrace.entity;

import com.qlmsoft.mbp.common.persistence.NewDataEntity;
import com.qlmsoft.mbp.common.persistence.NewTreeEntity;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

import com.google.common.collect.Lists;

import com.qlmsoft.mbp.common.persistence.DataEntity;

/**
 * 跟踪项目表Entity
 *
 * @author aaron
 * @version 2018-12-27
 */
public class ProjectItem extends NewTreeEntity<ProjectItem> {

    private static final long serialVersionUID = 1L;
    public static final String LEVEL_ROOT = "1";
    public static final String LEVEL_SUB = "2";

    private String prjCode;        // 项目代码
    private ProjectType prjType;        // 项目类型
    private String name;        // 名称
    private String ofyear;        // 年份
    private String sort;        // 排序
    private String level ;        // 层级
//    private ProjectItem parent;        // 父项目ID
    private String goal;        //年度目标

    private ProjectStatus prjStatus;        // 项目状态
    private List<ProjectProcess> projectProcessList = Lists.newArrayList();        // 子表列表

    public ProjectItem() {
        super();
    }

    public ProjectItem(String id) {
        super(id);
    }

    @Length(min = 0, max = 64, message = "项目代码长度必须介于 0 和 64 之间")
    public String getPrjCode() {
        return prjCode;
    }

    public void setPrjCode(String prjCode) {
        this.prjCode = prjCode;
    }

    @Length(min = 0, max = 200, message = "名称长度必须介于 0 和 200 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

//    @JsonBackReference
    public ProjectItem getParent() {
        return parent;
    }

    public void setParent(ProjectItem parent) {
        this.parent = parent;
    }

    public List<ProjectProcess> getProjectProcessList() {
        return projectProcessList;
    }

    public void setProjectProcessList(List<ProjectProcess> projectProcessList) {
        this.projectProcessList = projectProcessList;
    }

    public ProjectType getPrjType() {
        return prjType;
    }

    public void setPrjType(ProjectType prjType) {
        this.prjType = prjType;
    }

    public String getOfyear() {
        return ofyear;
    }

    public void setOfyear(String ofyear) {
        this.ofyear = ofyear;
    }

    public ProjectStatus getPrjStatus() {
        return prjStatus;
    }

    public void setPrjStatus(ProjectStatus prjStatus) {
        this.prjStatus = prjStatus;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}