package com.ds.spring.boot.controller;

import cn.hutool.core.bean.BeanUtil;

import com.ds.spring.boot.config.shiro.ShiroUtil;
import com.ds.spring.boot.domain.SysUser;
import com.ds.spring.boot.model.dto.LoginParam;
import com.ds.spring.boot.result.Result;
import com.ds.spring.boot.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author ds
 * @Date 2020/7/22 19:25
 * @Version 1.0
 * @Description 登录、注册
 */

@RequestMapping("auth")
@RestController
public class AuthController {

    @Resource
    private SysUserService sysUserService;

    @ApiOperation("登录")
    @PostMapping("login")
    public Result login(@RequestBody LoginParam param){
        return sysUserService.login(param);
    }


    @ApiOperation("注销")
    @GetMapping("logout")
    public Result logout(){
        try {
          SecurityUtils.getSubject().logout();
        } catch (Exception e) {
          Result.fail("退出失败");
        }
        return Result.ok();
    }

    @ApiOperation("获取当前用户信息")
    @GetMapping("userInfo")
    public Result<SysUser> UserInfo(){
        SysUser currentUserInfo = ShiroUtil.getCurrentUserInfo();
        return Result.ok(currentUserInfo);
    }
}
