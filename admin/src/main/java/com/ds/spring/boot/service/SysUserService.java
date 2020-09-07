package com.ds.spring.boot.service;

import com.ds.spring.boot.domain.SysUser;
import com.ds.spring.boot.model.dto.LoginParam;
import com.ds.spring.boot.model.dto.user.SysUserAddParam;
import com.ds.spring.boot.model.dto.user.SysUserListParam;
import com.ds.spring.boot.model.dto.user.SysUserParam;
import com.ds.spring.boot.model.dto.user.SysUserUpdateParam;
import com.ds.spring.boot.result.Result;
import com.github.pagehelper.PageInfo;

/**
 * @Author ds
 * @Date 2020/8/31 13:12
 * @Version 1.0
 * @Description
 */
public interface SysUserService {
    /**
     * 根据id获取后台管理员信息
     * @param id
     * @return
     */
    Result<SysUser> getById(Integer id);

    /**
     * 添加后台管理员
     * @param param
     * @return
     */
    Result insert(SysUserAddParam param);

    /**
     * 修改后台管理员信息
     * @param param
     * @return
     */
    Result update(SysUserUpdateParam param);

    /**
     * 删除后台管理员
     * @param id
     * @return
     */
    Result delete(Integer id);

    /**
     * 登录
     * @param param
     * @return
     */
    Result login(LoginParam param);

    /**
     * 分页查询后台管理员信息列表
     * @param param
     * @return
     */
    Result<PageInfo<SysUser>> list(SysUserListParam param);


}
