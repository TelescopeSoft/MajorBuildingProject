/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.bean;

import java.io.Serializable;

/**
 * Created by aaronhuang on 2018/7/24.
 */
public class ExpropriationData implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String msg;
    private ExpropriationTableBean<ExpropriationBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ExpropriationTableBean<ExpropriationBean> getData() {
        return data;
    }

    public void setData(ExpropriationTableBean<ExpropriationBean> data) {
        this.data = data;
    }
}
