package com.zixuan007.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zixuan007.admin.constant.Result;
import com.zixuan007.admin.pojo.PageRequest;
import com.zixuan007.admin.pojo.entity.RoleEntity;
import com.zixuan007.admin.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色控制层
 *
 * @author zixuan2020
 * @date 2020/10/18
 */
@Api(value = "角色管理 - 角色信息管理api", tags = "角色管理 - 角色信息管理api")
@RequestMapping("/role")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询角色列表
     *
     * @param pageRequest
     * @return
     */
    @ApiOperation(value = "查询角色列表", notes = "查询角色列表")
    @GetMapping(value = "/list")
    public Result<IPage<RoleEntity>> getList(PageRequest pageRequest) {
        return Result.success(roleService.getRoleByName(pageRequest, null));
    }

    /**
     * 查询角色名称
     *
     * @param pageRequest
     * @return
     */
    @ApiOperation(value = "根据角色名称查询", notes = "根据角色名称查询")
    @GetMapping(value = "/roleNameList")
    public Result<IPage<RoleEntity>> getRoleByName(PageRequest pageRequest,String roleName) {
        return Result.success(roleService.getRoleByName(pageRequest, roleName));
    }

    /**
     * 更新角色数据
     *
     * @param roleEntity
     * @return
     */
    @ApiOperation(value = "更新角色数据", notes = "更新角色数据")
    @PostMapping(value = "/updateRole")
    public Result updateRole(@RequestBody RoleEntity roleEntity) {
        return roleService.updateRole(roleEntity) ? Result.success() : Result.failure();
    }

    /**
     * 插入角色数据
     *
     * @param roleEntity
     * @return
     */
    @ApiOperation(value = "插入角色数据", notes = "插入角色数据")
    @PostMapping(value = "/insertRole")
    public Result insertRole(@RequestBody RoleEntity roleEntity) {
        return roleService.insertRole(roleEntity) ? Result.success() : Result.failure();
    }

    /**
     * 删除角色数据
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "插入角色数据", notes = "插入角色数据")
    @GetMapping(value = "/deleteRole")
    public Result deleteRoleById(int id) {
        return roleService.deleteRole(id) ? Result.success() : Result.failure();
    }
}
