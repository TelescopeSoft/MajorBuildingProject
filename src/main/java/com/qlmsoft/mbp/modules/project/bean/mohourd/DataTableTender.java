package com.qlmsoft.mbp.modules.project.bean.mohourd;

import com.qlmsoft.mbp.modules.project.entity.ProjectInfo;
import com.qlmsoft.mbp.modules.project.entity.TenderInfo;

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
public class DataTableTender {

    @XmlElement(name = "row")
    private List<TenderInfo> rows;

    public List<TenderInfo> getRows() {
        return rows;
    }

    public void setRows(List<TenderInfo> rows) {
        this.rows = rows;
    }

}
