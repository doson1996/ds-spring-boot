package com.ds.spring.boot.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
 * @Author ds
 * @Date 2020/8/31 12:54
 * @Version 1.0
 * @Description 角色-权限关联表
 */

@Data
@Table(name = "sys_role_permission")
public class SysRolePermission implements Serializable {

    private static final long serialVersionUID = 7745045739926542277L;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 权限id
     */
    @Column(name = "permission_id")
    private Integer permissionId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否有效 1有效     2无效
     */
    @Column(name = "delete_status")
    private String deleteStatus;
}
