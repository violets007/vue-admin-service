package com.zixuan007.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zixuan007.admin.constant.Result;
import com.zixuan007.admin.constant.ResultStatus;
import com.zixuan007.admin.pojo.PageRequest;
import com.zixuan007.admin.pojo.entity.MenuEntity;
import com.zixuan007.admin.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zixuan007
 * @date 2020/11
 */
@RestController
@Api(value = "菜单管理 - 菜单信息管理api", tags = "菜单管理 - 菜单信息管理api")
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 获取菜单列表
     *
     * @param pageRequest
     * @return
     */
    @ApiOperation(value = "获取菜单信息", notes = "获取菜单信息")
    @GetMapping("/getList")
    public Result<IPage<MenuEntity>> getMenuList(PageRequest pageRequest) {
        return new Result<IPage<MenuEntity>>(ResultStatus.SUCCESS, menuService.getMenuList(pageRequest));
    }

    /**
     * 插入菜单
     *
     * @param menuEntity
     */
    @ApiOperation(value = "插入菜单信息", notes = "插入菜单信息")
    @GetMapping("/insert")
    public Result insertMenu(MenuEntity menuEntity) {
        return menuService.insertMenu(menuEntity) ? new Result(ResultStatus.SUCCESS, null) : new Result(ResultStatus.NOT_MODIFIED, null);
    }

    /**
     * 更新菜单
     *
     * @param menuEntity
     * @return
     */
    @ApiOperation(value = "更新菜单信息", notes = "插入菜单信息")
    @PostMapping("/update")
    public Result updateMenu(MenuEntity menuEntity) {
        return menuService.updateMenu(menuEntity) ? new Result(ResultStatus.SUCCESS, null) : new Result(ResultStatus.NOT_MODIFIED, null);
    }

    /**
     * 更新菜单
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "更新菜单信息", notes = "插入菜单信息")
    @PostMapping("/update")
    public Result deleteById(int id) {
        return menuService.deleteMenu(id) ? new Result(ResultStatus.SUCCESS, null) : new Result(ResultStatus.NOT_MODIFIED, null);
    }
}
