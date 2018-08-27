package com.qlmsoft.mbp.modules.project.bean.mohourd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by aaronhuang on 2018/8/21.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "result")
public class DataTableBuildLicense {

    @XmlElement(name = "data")
    private List<ProjectBuilderLicenseBean> rows;

    public List<ProjectBuilderLicenseBean> getRows() {
        return rows;
    }

    public void setRows(List<ProjectBuilderLicenseBean> rows) {
        this.rows = rows;
    }

}
