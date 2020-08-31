package com.ds.spring.boot.config.shiro;

import com.ds.spring.boot.constants.ShiroConstants;
import com.ds.spring.boot.domain.SysUser;
import com.ds.spring.boot.mapper.SysUserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ds
 * @Date 2020/7/23 15:46
 * @Version 1.0
 * @Description
 */
public class UserRealm extends AuthorizingRealm {
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Session session = SecurityUtils.getSubject().getSession();
        //todo 查询用户的权限
        //List<String> perMissionList =  (List<String>) session.getAttribute(ShiroConstants.SESSION_USER_PERMISSION);
        List<String> perMissionList = new ArrayList<>();
        //为当前用户设置角色和权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermissions(perMissionList);
        return authorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        //--校验业务逻辑start--//
        Example example = new Example(SysUser.class);
        example.createCriteria().andEqualTo("username",username)
                                .andEqualTo("deleteStatus",0);
        SysUser user = sysUserMapper.selectOneByExample(example);
        if(user != null ){
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, user.getPassword(),getName());
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute(ShiroConstants.SESSION_USER_NAME,username);
            session.setAttribute(ShiroConstants.SESSION_USER_ID,user.getId());
            session.setAttribute(ShiroConstants.SESSION_USER_INFO,user);
            return authenticationInfo;
        }
        return null;
    }

}
