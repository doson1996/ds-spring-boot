package com.ds.spring.boot.tk.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author ds
 * @Date 2020/8/31 12:50
 * @Version 1.0
 * @Description 通用Mapper
 */
public interface MyMapper<T> extends MySqlMapper<T>, Mapper<T>{
}
