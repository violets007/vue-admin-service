package com.zixuan007.admin.pojo.entity;

import lombok.Data;

import javax.persistence.Table;
import java.util.List;

/**
 * 权限实体
 *
 * @author zixuan007
 * @date 2020/10/18
 */
@Data
@Table(name = "va_privilege")
public class PrivilegeEntity {

    private String parentKey;
    /**
     * 功能名称
     */
    private String name;

    /**
     * 1.菜单 2.功能点
     */
    private Integer type;

    /**
     * 路由name 英文关键字
     */
    private String key;

    /**
     * 路由path/type=3为API接口
     */
    private String url;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 父级的key
     */
    private List<PrivilegeEntity> children;
}
