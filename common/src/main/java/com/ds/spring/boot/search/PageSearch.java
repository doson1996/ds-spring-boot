package com.ds.spring.boot.search;

import lombok.Data;

/**
 * @Author ds
 * @Date 2020/9/1 10:05
 * @Version 1.0
 * @Description 分页查询
 */

@Data
public class PageSearch {
    //当前页
    private Integer pageNum;
    //每页的数量
    private Integer pageSize;

    public PageSearch() {
        this.pageNum = 1;
        this.pageSize = 10;
    }
}
