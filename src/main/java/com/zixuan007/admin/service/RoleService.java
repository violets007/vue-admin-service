package com.zixuan007.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zixuan007.admin.mapper.RoleMapper;
import com.zixuan007.admin.pojo.PageRequest;
import com.zixuan007.admin.pojo.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author apple
 */
@Service

public class RoleService {

    @Autowired
    private RoleMapper roleMapper;


    public IPage<RoleEntity> getRoleByName(PageRequest pageRequest, String roleName) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();

        IPage<RoleEntity> page = new Page<>(pageNum, pageSize);
        QueryWrapper<RoleEntity> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(roleName)) wrapper.like("role_name", roleName);
        return roleMapper.selectPage(page, wrapper);
    }

    public boolean updateRole(RoleEntity roleEntity) {
        return roleMapper.updateRole(roleEntity) > 0;
    }

    public boolean insertRole(RoleEntity roleEntity) {
        roleEntity.setCreateTime(new Date());
        roleEntity.setUpdateTime(new Date());
        return roleMapper.insert(roleEntity) > 0;
    }

    public boolean deleteRole(int id) {
        return roleMapper.deleteById(id) > 0;
    }
}
