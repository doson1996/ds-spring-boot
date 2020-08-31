package com.ds.spring.boot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.ds.spring.boot.constants.BusinessConstants;
import com.ds.spring.boot.domain.SysUser;
import com.ds.spring.boot.mapper.SysUserMapper;
import com.ds.spring.boot.model.dto.LoginParam;
import com.ds.spring.boot.model.dto.SysUserAddParam;
import com.ds.spring.boot.model.dto.SysUserUpdateParam;
import com.ds.spring.boot.result.Result;
import com.ds.spring.boot.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author ds
 * @Date 2020/8/31 13:12
 * @Version 1.0
 * @Description
 */

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public Result<SysUser> getById(Integer id) {
        //验证用户id
        if(id < BusinessConstants.USER_ID_MIN){
            return Result.fail("参数无效");
        }

        SysUser sysUser = getUser("id", id);
        if(sysUser != null){
            return Result.ok(sysUser);
        }
        return Result.fail("用户不存在");
    }

    @Override
    public Result insert(SysUserAddParam param) {
        String username = param.getUsername();
        String password = param.getPassword();
        //验证手机号长度
        if(param.getPhone().length() != BusinessConstants.PHONE_LENGTH){
            return Result.fail("手机号长度必须为11位!");
        }

        //验证用户名
        SysUser getByUsername = getUser("username",username);
        if(getByUsername != null){
            return Result.fail("用户名已存在!");
        }

        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(param,sysUser);
        //md5加密密码
        String encryptPassword = SecureUtil.md5(username+password);
        sysUser.setPassword(encryptPassword);
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateBy("");
        sysUser.setUpdateTime(new Date());
        int i = sysUserMapper.insertSelective(sysUser);
        if(i > 0){
            return Result.ok("添加成功",null);
        }
        return Result.fail("添加失败");
    }

    @Override
    public Result update(SysUserUpdateParam param) {
        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(param,sysUser);
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if(i > 0){
            return Result.ok("更新成功",null);
        }
        return Result.fail("更新失败");
    }

    @Override
    public Result delete(Integer id) {
        //验证用户id
        if(id < BusinessConstants.USER_ID_MIN){
            return Result.fail("参数无效");
        }

        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setDeleteStatus(1);
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if(i > 0){
            return Result.ok("删除成功",null);
        }
        return Result.fail("删除失败");
    }

    @Override
    public Result login(LoginParam param) {
        String username = param.getUsername();
        String password = param.getPassword();

        //验证用户名、密码是否为空
        if( StrUtil.isBlank(username) || StrUtil.isBlank(password) ){
            return Result.fail("账号或密码不能为空!");
        }

        String encryptPassword = SecureUtil.md5(username+password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, encryptPassword);
        try {
            subject.login(token);
            subject.getSession().setTimeout(1000*60*60*24*7);
            //todo 账号被删除状态，退出登录
           /*SysUser user = getUser("username", username);
            if(user.getDeleteStatus() == 1){
                subject.logout();
                return Result.fail("账号异常，请联系管理员!");
            }*/
            return Result.ok((subject.getSession().getId().toString()));
        } catch (Exception e) {
            return Result.fail("账号或密码错误!");
        }
    }


    /**
     * 根据字段查找用户
     * @param filed
     * @param value
     * @return
     */
    public SysUser getUser(String filed,Object value){
        Example example = new Example(SysUser.class);
        example.createCriteria().andEqualTo(filed,value)
                                .andEqualTo("deleteStatus",0);
        return sysUserMapper.selectOneByExample(example);
    }

}
