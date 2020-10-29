package com.zixuan007.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zixuan007.admin.pojo.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zixuan007
 * @Date 2020/10/29
 */
@Mapper
public interface MenuMapper extends BaseMapper<MenuEntity> {

    /**
     * 更新菜单
     *
     * @param menuEntity
     * @return
     */
    public int updateMenu(@Param("menu") MenuEntity menuEntity);
}
