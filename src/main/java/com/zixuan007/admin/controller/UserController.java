package com.zixuan007.admin.controller;


import com.zixuan007.admin.common.utils.TokenUtil;
import com.zixuan007.admin.pojo.Result;
import com.zixuan007.admin.pojo.ResultStatus;
import com.zixuan007.admin.pojo.User;
import com.zixuan007.admin.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

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
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Result<HashMap<String, Object>> login(@RequestBody User user, HttpServletRequest request) {
        //验证当前token是否可用
        String token = request.getHeader("small-admin-token");
        Claims claims = TokenUtil.parseToken(token);
        if (claims != null) {
            //获取当前token的用户信息
            Integer id = (Integer) claims.get("uid");
            String username = (String) claims.get("username");
            HashMap<String, Object> userMap = new HashMap<>();
            userMap.put("uid", id);
            userMap.put("username", username);
            return Result.success(userMap);
        } else {
            User resultUser = userService.login(user);
            if (resultUser != null) {
                token = TokenUtil.createJwtToken(resultUser);
                HashMap<String, Object> userMap = new HashMap<>();
                userMap.put("uid", resultUser.getId());
                userMap.put("username", resultUser.getUsername());
                userMap.put("token", token);
                return Result.success(userMap);
            }
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
    public Result<Void> verify(HttpServletRequest request) {
        String token = request.getHeader("small-admin-token");
        boolean verify = TokenUtil.parseToken(token) != null;
        if (verify) {
            return Result.success();
        }
        return Result.failure(ResultStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/getList")
    public Result<List> getList() {
        return Result.success(userService.getList());
    }

    @GetMapping("/query/{id}")
    public User findByUid(@PathVariable("id") long id) {
        return userService.findUserById(id);
    }
}
