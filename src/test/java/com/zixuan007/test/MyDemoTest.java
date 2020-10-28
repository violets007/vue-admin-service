package com.zixuan007.test;

import com.zixuan007.admin.VueAdminApplication;
import com.zixuan007.admin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VueAdminApplication.class)
public class MyDemoTest {

    @Autowired
    private UserService userService;

    /**
     * 测试获取指定用户数据
     */
    @Test
    public void testQueryUserByID() {
        System.out.println(userService.findUserById(1));
    }


}
