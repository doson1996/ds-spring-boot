package com.ds.spring.boot.controller;

import com.ds.spring.boot.domain.SysUser;
import com.ds.spring.boot.model.dto.SysUserAddParam;
import com.ds.spring.boot.model.dto.SysUserParam;
import com.ds.spring.boot.model.dto.SysUserUpdateParam;
import com.ds.spring.boot.result.Result;
import com.ds.spring.boot.service.SysUserService;
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
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping("getById/{id}")
    public Result<SysUser> getById(@PathVariable Integer id){
        return sysUserService.getById(id);
    }

    @PostMapping("insert")
    public Result insert(@RequestBody SysUserAddParam param){
        return sysUserService.insert(param);
    }

    @PostMapping("update")
    public Result update(@RequestBody SysUserUpdateParam param){
        return sysUserService.update(param);
    }

    @GetMapping("delete/{id}")
    public Result delete(@PathVariable Integer id){
        return sysUserService.delete(id);
    }
}
