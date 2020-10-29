package com.zixuan007.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zixuan007
 */
@Data
@TableName("t_menu")
public class MenuEntity extends BaseEntity {

    private int parentId;
    private String name;
    private String url;
    private String accredit;
    private int type;
    private String menuIcon;
    private int sort;
}
