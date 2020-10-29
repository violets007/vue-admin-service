package com.zixuan007.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zixuan007.admin.mapper.MenuMapper;
import com.zixuan007.admin.pojo.PageRequest;
import com.zixuan007.admin.pojo.entity.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author zixuan007
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 创建菜单
     *
     * @param menuEntity
     * @return
     */
    public boolean insertMenu(MenuEntity menuEntity) {
        menuEntity.setCreateTime(new Date());
        return menuMapper.insert(menuEntity) > 0 ? true : false;
    }

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    public boolean deleteMenu(int id) {
        return menuMapper.deleteById(id) > 0 ? true : false;
    }

    /**
     * 分页展示角色权限
     *
     * @param pageRequest
     * @return
     */
    public IPage<MenuEntity> getMenuList(PageRequest pageRequest) {
        Page<MenuEntity> page = new Page<MenuEntity>(pageRequest.getPageNum(), pageRequest.getPageSize());
        return menuMapper.selectPage(page, new QueryWrapper<MenuEntity>());
    }
}
