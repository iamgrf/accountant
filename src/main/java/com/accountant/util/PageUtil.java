package com.accountant.util;

import java.util.List;
import java.util.Map;

public class PageUtil {

    private Integer page;
    private Integer pageSize;
    private Integer pages;
    private Integer total;
    private List<Map<String, Object>> data;

    public PageUtil() {
    }

    public PageUtil(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.pages = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        this.total = total;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }
}
