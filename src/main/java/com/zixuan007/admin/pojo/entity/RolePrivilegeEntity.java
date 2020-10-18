package com.zixuan007.admin.pojo.entity;

import lombok.Data;

import javax.persistence.Table;
import java.util.List;

/**
 * 角色权限实体
 *
 * @author zixuan007
 * @date 2020/10/18
 */
@Data
@Table(name = "va_role_privilege")
public class RolePrivilegeEntity {
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 功能权限id 集合
     */
    private List<String> privilegeKeyList;
}
