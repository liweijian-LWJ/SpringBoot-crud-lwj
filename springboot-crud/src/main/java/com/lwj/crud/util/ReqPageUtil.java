package com.lwj.crud.util;

import java.io.Serializable;

/**
 * 分页请求类
 */
public class ReqPageUtil implements Serializable {
    //开始条数
    private Integer offset = 0;
    //每页条数
    private Integer limit = 10;
    //排序字段
    private String order = "id";
    // 排序规则
    private String sort = "asc";


    public ReqPageUtil() {
    }

    public int getOffset() {
        if (this.offset <= 0 || null == this.offset) {
            this.offset = 1;
        }
        return (this.offset - 1) * this.limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
