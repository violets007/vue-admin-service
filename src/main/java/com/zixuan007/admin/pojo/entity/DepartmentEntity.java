package com.zixuan007.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zixuan007
 */
@Data
@TableName("t_department")
public class DepartmentEntity extends BaseEntity {

    private String name;
    private int roleId;
    private int parentId;

}
