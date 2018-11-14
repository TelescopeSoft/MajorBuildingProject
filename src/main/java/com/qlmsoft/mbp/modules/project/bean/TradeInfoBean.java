/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.bean;

import java.io.Serializable;

/**
 * Created by aaronhuang on 2018/7/31.
 */
public class TradeInfoBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String writeTime;
    private String openTime;
    private String indexId;
    private String url;
    private String cruser;
    private String writeTimeString;
    private String organization;
    private String accessory;

    public TradeInfoBean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(String writeTime) {
        this.writeTime = writeTime;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCruser() {
        return cruser;
    }

    public void setCruser(String cruser) {
        this.cruser = cruser;
    }

    public String getWriteTimeString() {
        return writeTimeString;
    }

    public void setWriteTimeString(String writeTimeString) {
        this.writeTimeString = writeTimeString;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    @Override
    public String toString() {
        return "TradeInfoBean{" +
                "title='" + title + '\'' +
                ", writeTime='" + writeTime + '\'' +
                ", openTime='" + openTime + '\'' +
                ", indexId='" + indexId + '\'' +
                ", url='" + url + '\'' +
                ", cruser='" + cruser + '\'' +
                ", writeTimeString='" + writeTimeString + '\'' +
                ", organization='" + organization + '\'' +
                ", accessory='" + accessory + '\'' +
                '}';
    }
}
