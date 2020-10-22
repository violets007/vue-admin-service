package com.zixuan007.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


import java.util.List;

/**
 * 角色权限实体
 *
 * @author zixuan007
 * @date 2020/10/18
 */
@Data
@TableName("t_role_privilege")
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
