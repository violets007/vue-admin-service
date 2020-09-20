package com.zixuan007.admin.controller;

import com.zixuan007.admin.common.utils.TokenUtil;
import com.zixuan007.admin.pojo.User;
import com.zixuan007.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zixuan007
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/login")
    public Map<String, Object> login(String username, String password) {

        Map<String, Object> map = new HashMap<>();
        User user = new User(username, password);

        if (userService.login(user)) {
            String token = TokenUtil.sign(user);
            if (token != null) {
                map.put("code", "10000");
                map.put("message", "认证成功");
                map.put("token", token);
                return map;
            }
        }

        map.put("code", "0000");
        map.put("message", "认证失败");
        return map;

    }

    @GetMapping(value = "/getList")
    public List<User> getList() {

        List userList = userService.getList();
        return userList;
    }

    @GetMapping("query/{id}")
    public User findByUid(@PathVariable("id") long id) {
        return userService.findUserById(id);
    }
}
