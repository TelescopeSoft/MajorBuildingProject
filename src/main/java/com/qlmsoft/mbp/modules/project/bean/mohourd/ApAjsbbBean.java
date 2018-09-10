package com.qlmsoft.mbp.modules.project.bean.mohourd;

import com.qlmsoft.mbp.modules.project.entity.ApAjsbb;
import com.qlmsoft.mbp.modules.project.entity.ApAjsbbHjssjd;
import com.qlmsoft.mbp.modules.project.entity.ProjectBuilderLicence;

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
public class ApAjsbbBean implements Serializable {

    @XmlElement(name = "ap_ajsbb")
    private ApAjsbb ajsbb;

    @XmlElementWrapper(name="hjssjdList")
    @XmlElement(name = "hjssjdcontent")
    private List<ApAjsbbHjssjd> hjssjdList;


    public ApAjsbb getAjsbb() {
        return ajsbb;
    }

    public void setAjsbb(ApAjsbb ajsbb) {
        this.ajsbb = ajsbb;
    }

    public List<ApAjsbbHjssjd> getHjssjdList() {
        return hjssjdList;
    }

    public void setHjssjdList(List<ApAjsbbHjssjd> hjssjdList) {
        this.hjssjdList = hjssjdList;
    }
}
