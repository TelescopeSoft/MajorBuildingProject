/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.bean.mohourd;

import com.qlmsoft.mbp.modules.project.entity.ProjectBuilderLicence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by aaronhuang on 2018/8/27.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectBuilderLicenseBean {

    @XmlElement(name = "TBBuilderLicenceManage")
    private ProjectBuilderLicence builderLicense;

    public ProjectBuilderLicence getBuilderLicense() {
        return builderLicense;
    }

    public void setBuilderLicense(ProjectBuilderLicence builderLicense) {
        this.builderLicense = builderLicense;
    }
}
