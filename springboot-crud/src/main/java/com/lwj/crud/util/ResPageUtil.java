package com.lwj.crud.util;

import java.io.Serializable;

/**
 * 分页响应类
 */
public class ResPageUtil implements Serializable {

    //总条数
    private Long totalNum;
    //总页数
    private Long pageCount;
    // 当前页数
    private Integer page;
    //每页条数
    private Integer pageNum;

    public ResPageUtil(ReqPageUtil reqPageUtil, Long totalNum) {
        this.totalNum = totalNum;
        this.pageCount = (totalNum % reqPageUtil.getLimit() == 0) ? totalNum / reqPageUtil.getLimit() : (totalNum / reqPageUtil.getLimit()) + 1;
        this.page = (reqPageUtil.getOffset() / reqPageUtil.getLimit()) + 1;
        this.pageNum = reqPageUtil.getLimit();
    }

    public ResPageUtil() {
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
