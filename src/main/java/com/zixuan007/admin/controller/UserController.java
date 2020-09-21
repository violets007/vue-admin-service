package com.zixuan007.admin.controller;

import com.zixuan007.admin.common.utils.TokenUtil;
import com.zixuan007.admin.pojo.Result;
import com.zixuan007.admin.pojo.ResultStatus;
import com.zixuan007.admin.pojo.User;
import com.zixuan007.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zixuan007
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 校验当前账号密码是否登录
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public Result<String> login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        User user = new User(username, password);
        if (userService.login(user)) {
            String token = TokenUtil.sign(user);
            return Result.success(token);
        }
        return Result.failure(ResultStatus.UNAUTHORIZED);
    }

    /**
     * 验证当前携带的token是否可用
     *
     * @param request
     * @return
     */
    @GetMapping("/verify")
    public Result<String> verify(HttpServletRequest request) {

        return null;
    }

    @GetMapping(value = "/getList")
    public List<User> getList() {

        List userList = userService.getList();
        return userList;
    }

    @GetMapping("/query/{id}")
    public User findByUid(@PathVariable("id") long id) {
        return userService.findUserById(id);
    }
}
