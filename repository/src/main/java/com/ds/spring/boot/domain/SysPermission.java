package com.ds.spring.boot.domain;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author ds
 * @Date 2020/8/31 12:54
 * @Version 1.0
 * @Description 后台权限表
 */

@Data
@Table(name = "sys_permission")
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 9031481938735019629L;

    /**
     * 自定id,主要供前端展示权限列表分类排序使用.
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 归属菜单,前端判断并展示菜单使用,
     */
    @Column(name = "menu_code")
    private String menuCode;

    /**
     * 菜单的中文释义
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 权限的代码/通配符,对应代码中@RequiresPermissions 的value
     */
    @Column(name = "permission_code")
    private String permissionCode;

    /**
     * 本权限的中文释义
     */
    @Column(name = "permission_name")
    private String permissionName;

    /**
     * 是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选
     */
    @Column(name = "required_permission")
    private Boolean requiredPermission;
}
