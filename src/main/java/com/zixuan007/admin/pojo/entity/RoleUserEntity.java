package com.zixuan007.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;



/**
 * 角色用户关联对象
 *
 * @author zixuan007
 * @date 2020/10/18
 */
@Data
@TableName("t_role_user")
public class RoleUserEntity extends BaseEntity {

    private long roleId;
    private long userId;
}
