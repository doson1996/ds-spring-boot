package com.ds.spring.boot.model.dto.user;

import lombok.Data;

/**
 * @Author ds
 * @Date 2020/8/31 13:44
 * @Version 1.0
 * @Description
 */
@Data
public class SysUserUpdateParam {

    private Integer id;

    private String username;

    private String nickname;

    private String phone;

}
