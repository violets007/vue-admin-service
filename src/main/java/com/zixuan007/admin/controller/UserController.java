package com.zixuan007.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;

import com.zixuan007.admin.common.utils.TokenUtil;
import com.zixuan007.admin.pojo.PageRequest;
import com.zixuan007.admin.constant.Result;
import com.zixuan007.admin.constant.ResultStatus;
import com.zixuan007.admin.pojo.entity.UserEntity;
import com.zixuan007.admin.service.UserService;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author zixuan007
 */
@Api(value = "用户管理 - 用户信息管理api", tags = "用户管理 - 用户信息管理api")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 校验当前账号密码是否登录
     *
     * @param map
     * @return
     */
    @ApiOperation(value = "用户登录验证", notes = "用户登录验证")
    @PostMapping("/login")
    public Result<HashMap<String, Object>> login(@RequestBody HashMap<String, String> map, HttpServletRequest request) {
        //验证当前token是否可用
        String token = request.getHeader("small-admin-token");

        Claims claims = TokenUtil.parseToken(token);
        UserEntity verifyUser = userService.login(new UserEntity(map.get("username"), map.get("password")));
        if (claims == null && verifyUser == null) {
            return Result.failure(ResultStatus.UNAUTHORIZED);
        }


        UserEntity resultUser = new UserEntity();
        if (claims != null) {
            Integer id = (Integer) claims.get("uid");
            String username = (String) claims.get("username");
            resultUser.setId(id.longValue());
            resultUser.setUsername(username);
        }


        if (verifyUser != null) {
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
     * 更新当前用户数据
     *
     * @param user
     * @return
     */
    @PostMapping("/saveUser")
    public Result updateUser(@RequestBody UserEntity user, HttpServletRequest request) {
        user.setRemoteIp(request.getRemoteAddr());
        return userService.updateUser(user) ? Result.success() : Result.failure(ResultStatus.NOT_MODIFIED);
    }

    @ApiOperation(value = "删除用户信息", notes = "删除用户信息")
    @PostMapping("/delUser")
    public Result delUser(@RequestBody HashMap<String, Integer> map) {
        return userService.delUser(map.get("id")) ? Result.success() : Result.failure();
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
    public Result<IPage<UserEntity>> getList(PageRequest pageRequest) {
        return Result.success(userService.getList(pageRequest));
    }


    @ApiOperation(value = "查询用户信息", notes = "查询用户信息")
    @GetMapping("/query/{id}")
    public UserEntity findByUid(@RequestParam("id") long id) {
        return userService.findUserById(id);
    }
}
