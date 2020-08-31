package com.ds.spring.boot.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
 * @Author ds
 * @Date 2020/8/31 12:54
 * @Version 1.0
 * @Description 后台角色表
 */

@Data
@Table(name = "sys_role")
public class SysRole implements Serializable {

    private static final long serialVersionUID = -4444240069435459832L;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 角色名
     */
    @Column(name = "role_name")
    private String roleName;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否有效  1有效  2无效
     */
    @Column(name = "delete_status")
    private String deleteStatus;
}
