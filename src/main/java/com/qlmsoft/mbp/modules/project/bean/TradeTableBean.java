package com.qlmsoft.mbp.modules.project.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaronhuang on 2018/7/31.
 */
public class TradeTableBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int pageSize;
    private int pageIndex;
    private int pageCount;
    private int totalCount;

    private List<TradeInfoBean> list = new ArrayList<TradeInfoBean>();

    public TradeTableBean() {
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<TradeInfoBean> getList() {
        return list;
    }

    public void setList(List<TradeInfoBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "TradeTableBean{" +
                "pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", pageCount=" + pageCount +
                ", totalCount=" + totalCount +
                ", list=" +
                '}';
    }
}
