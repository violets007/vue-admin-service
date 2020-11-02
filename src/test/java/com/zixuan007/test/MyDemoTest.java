package com.zixuan007.test;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zixuan007.admin.VueAdminApplication;
import com.zixuan007.admin.mapper.MenuMapper;
import com.zixuan007.admin.mapper.RoleUserMapper;
import com.zixuan007.admin.pojo.PageRequest;
import com.zixuan007.admin.pojo.entity.MenuEntity;
import com.zixuan007.admin.service.MenuService;
import com.zixuan007.admin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VueAdminApplication.class)
public class MyDemoTest {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    /**
     * 测试获取指定用户数据
     */
    @Test
    public void testQueryUserByID() {
        System.out.println(userService.findUserById(1));
    }

    /**
     * 查询菜单
     */
    @Test
    public void testQueryMenu() {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNum(1);
        pageRequest.setPageSize(10);
        IPage<MenuEntity> page = menuService.getMenuList(pageRequest);
        System.out.println(page.getRecords());
    }

    @Test
    public void testInsertMenu() {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setParentId(1);
        menuEntity.setName("菜单管理");
        menuEntity.setUrl("/menu");
        menuEntity.setIcon("custom-menu iconfont");
        menuEntity.setSort(3);
        menuEntity.setType(2);
        menuEntity.setStatus(true);
        menuEntity.setCreateTime(new Date());
        menuEntity.setUpdateTime(new Date());

        menuMapper.insert(menuEntity);
    }

    @Test
    public void testInsertRoleUser() {
        System.out.println(roleUserMapper.insertRoleUser(13, 1));
    }

    @Test
    public void testqueryRoleIdByUid() {
        System.out.println(roleUserMapper.deleteByUidAndRid(13, 2));
    }
}
