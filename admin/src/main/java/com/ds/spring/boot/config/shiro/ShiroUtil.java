package com.ds.spring.boot.config.shiro;

import cn.hutool.core.util.StrUtil;
import com.ds.spring.boot.constants.ShiroConstants;
import com.ds.spring.boot.domain.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * @Author ds
 * @Date 2020/7/23 17:46
 * @Version 1.0
 * @Description
 */

public class ShiroUtil {

  /**获取当前登录用户Id*/
  public static Long getCurrentUserId(){
    Session session = SecurityUtils.getSubject().getSession();
    Long userId = (Long) session.getAttribute(ShiroConstants.SESSION_USER_ID);
    return userId;
  }

  /**获取当前登录用户名*/
  public static String getCurrentUsername(){
    Session session = SecurityUtils.getSubject().getSession();
    String username = (String) session.getAttribute(ShiroConstants.SESSION_USER_NAME);
    if(StrUtil.isEmpty(username)){
      return "";
    }else{
      return username;
    }
  }

  /**获取当前登录用户信息*/
  public static SysUser getCurrentUserInfo(){
    Session session = SecurityUtils.getSubject().getSession();
    SysUser user = (SysUser) session.getAttribute(ShiroConstants.SESSION_USER_INFO);
    return user;
  }


}
