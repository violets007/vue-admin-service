package com.zixuan007.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;

import com.zixuan007.admin.common.utils.TokenUtil;
import com.zixuan007.admin.pojo.PageRequest;
import com.zixuan007.admin.pojo.Result;
import com.zixuan007.admin.pojo.ResultStatus;
import com.zixuan007.admin.pojo.User;
import com.zixuan007.admin.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

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
    public Result<HashMap<String, Object>> login(@RequestBody(required = false) User user, HttpServletRequest request) {
        //验证当前token是否可用
        String token = request.getHeader("small-admin-token");

        Claims claims = TokenUtil.parseToken(token);
        User verifyUser = userService.login(user);
        if (claims == null && verifyUser == null) {
            return Result.failure(ResultStatus.UNAUTHORIZED);
        }

        User resultUser = new User();
        if (claims != null) {
            Integer id = (Integer) claims.get("uid");
            String username = (String) claims.get("username");
            resultUser.setId(id);
            resultUser.setUsername(username);
        }


        if (userService.login(user) != null) {
            resultUser = verifyUser;
        }

        //生成token
        String jwtToken = TokenUtil.createJwtToken(resultUser);
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("id", resultUser.getId());
        resultMap.put("username", resultUser.getUsername());
        resultMap.put("token", jwtToken);

        return Result.success(resultMap);
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
    public Result<IPage<User>> getList(PageRequest pageRequest) {
        return Result.success(userService.getList(pageRequest));
    }

    @GetMapping("/query/{id}")
    public User findByUid(@PathVariable("id") long id) {
        return userService.findUserById(id);
    }
}
