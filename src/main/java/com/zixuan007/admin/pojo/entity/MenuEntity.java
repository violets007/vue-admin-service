package com.zixuan007.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zixuan007
 */
@Data
@TableName("t_menu")
public class MenuEntity extends BaseEntity {

    /**
     * 父级ID
     */
    private int parentId;


    /**
     * 菜单名称
     */
    private String name;

    /**
     * url
     */
    private String url;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private int sort;

    /**
     * 菜单类型 1菜单 2页面 3按钮
     */
    private int type;

    /**
     * 菜单状态
     */
    private boolean status;
}
