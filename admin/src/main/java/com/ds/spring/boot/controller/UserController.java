package com.ds.spring.boot.controller;

import com.ds.spring.boot.config.shiro.ShiroUtil;
import com.ds.spring.boot.domain.SysUser;
import com.ds.spring.boot.model.dto.user.SysUserAddParam;
import com.ds.spring.boot.model.dto.user.SysUserListParam;
import com.ds.spring.boot.model.dto.user.SysUserUpdateParam;
import com.ds.spring.boot.result.Result;
import com.ds.spring.boot.service.SysUserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author ds
 * @Date 2020/8/31 13:13
 * @Version 1.0
 * @Description
 *
 */
@Api("后台管理员")
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping("getById/{id}")
    @ApiOperation("根据id获取后台管理员信息")
    public Result<SysUser> getById(@PathVariable Integer id){
        return sysUserService.getById(id);
    }

    @PostMapping("list")
    @ApiOperation("获取所有后台管理员信息")
    public Result<PageInfo<SysUser>> list(@RequestBody SysUserListParam param){
        return sysUserService.list(param);
    }

    @PostMapping("insert")
    @ApiOperation("添加后台管理员")
    //@RequiresPermissions("user:insert")
    public Result insert(@RequestBody SysUserAddParam param){
        return sysUserService.insert(param);
    }

    @PostMapping("update")
    @ApiOperation("修改后台管理员信息")
    //@RequiresPermissions("user:update")
    public Result update(@RequestBody SysUserUpdateParam param){
        return sysUserService.update(param);
    }

    @GetMapping("delete/{id}")
    @ApiOperation("删除后台管理员")
    //@RequiresPermissions("user:delete")
    public Result delete(@PathVariable Integer id){
        return sysUserService.delete(id);
    }


}
