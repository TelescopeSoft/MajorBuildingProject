/**
 * Copyright &copy; 2017-2018 千里目软件 All rights reserved.
 */
package com.qlmsoft.mbp.modules.project.bean;

import com.qlmsoft.mbp.modules.project.entity.PubApproveResult;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaronhuang on 2018/7/24.
 */
public class ExpropriationTableBean<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int pageCount;

    private int pageIndex;

    private int pageSize;

    private List<ExpropriationBean> rows = new ArrayList<ExpropriationBean>();

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<ExpropriationBean> getRows() {
        return rows;
    }

    public void setRows(List<ExpropriationBean> rows) {
        this.rows = rows;
    }
}
