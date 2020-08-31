package com.ds.spring.boot.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author ds
 * @Date 2020/7/23 15:23
 * @Version 1.0
 * @Description 后台管理员（商户） 登录
 */
@Data
@ApiModel(value = "后台管理员（商户） 登录")
public class LoginParam {

    @ApiModelProperty(value = "用户名（商户名）",required = true)
    private String username;

    @ApiModelProperty(value = "密码",required = true)
    private String password;

}
