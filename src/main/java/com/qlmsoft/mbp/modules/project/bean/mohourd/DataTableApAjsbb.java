package com.qlmsoft.mbp.modules.project.bean.mohourd;

import com.qlmsoft.mbp.modules.project.entity.ProjectFinish;

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
public class DataTableApAjsbb {

    @XmlElement(name = "data")
    private List<ApAjsbbBean> rows;

    public List<ApAjsbbBean> getRows() {
        return rows;
    }

    public void setRows(List<ApAjsbbBean> rows) {
        this.rows = rows;
    }
}
