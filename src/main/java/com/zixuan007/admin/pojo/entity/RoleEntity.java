package com.zixuan007.admin.pojo.entity;

import lombok.Data;

import javax.persistence.Table;

/**
 * 角色
 *
 * @author zixuan007
 * @date 2020/10/18
 */
@Data
@Table(name = "va_role")
public class RoleEntity extends BaseEntity {
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String remark;
}
