package com.ds.spring.boot.mapper;

import com.ds.spring.boot.domain.SysUser;
import com.ds.spring.boot.tk.mybatis.MyMapper;

/**
 * @Author ds
 * @Date 2020/8/31 14:07
 * @Version 1.0
 * @Description
 */
public interface SysUserMapper extends MyMapper<SysUser> {
    SysUser getById(Integer id);
}
