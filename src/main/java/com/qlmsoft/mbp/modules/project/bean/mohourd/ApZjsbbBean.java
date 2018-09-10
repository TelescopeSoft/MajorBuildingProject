package com.qlmsoft.mbp.modules.project.bean.mohourd;

import com.qlmsoft.mbp.modules.project.entity.ApZjsbb;
import com.qlmsoft.mbp.modules.project.entity.ApZjsbbDwry;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.util.List;

/**
 * Created by aaronhuang on 2018/8/27.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class ApZjsbbBean implements Serializable {

    @XmlElement(name = "ap_zjsbb")
    private ApZjsbb ajsbb;

    @XmlElementWrapper(name="dwryList")
    @XmlElement(name = "dwrycontent")
    private List<ApZjsbbDwry> dwryList;

    public ApZjsbb getAjsbb() {
        return ajsbb;
    }

    public void setAjsbb(ApZjsbb ajsbb) {
        this.ajsbb = ajsbb;
    }

    public List<ApZjsbbDwry> getDwryList() {
        return dwryList;
    }

    public void setDwryList(List<ApZjsbbDwry> dwryList) {
        this.dwryList = dwryList;
    }
}
