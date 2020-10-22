package com.zixuan007.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * 角色
 *
 * @author zixuan007
 * @date 2020/10/18
 */
@Data
@TableName("t_role")
public class RoleEntity extends BaseEntity {
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String description;
}
