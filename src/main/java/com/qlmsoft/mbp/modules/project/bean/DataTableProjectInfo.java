/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.bean;

import com.qlmsoft.mbp.modules.project.entity.ProjectInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by aaronhuang on 2018/8/21.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dataTable")
public class DataTableProjectInfo {

    @XmlElement(name = "row")
    private List<ProjectInfo> rows;

    public List<ProjectInfo> getRows() {
        return rows;
    }

    public void setRows(List<ProjectInfo> rows) {
        this.rows = rows;
    }
}
