package com.zixuan007.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;

import com.zixuan007.admin.common.utils.TokenUtil;
import com.zixuan007.admin.constant.Result;
import com.zixuan007.admin.constant.ResultStatus;
import com.zixuan007.admin.pojo.dto.UserDTO;
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
            return Result.failure(ResultStatus.LOGIN_ERROR);
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
     * 验证当前携带的token是否可用
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "验证用户Token", notes = "验证用户Token")
    @GetMapping("/verify")
    public Result<Void> verify(HttpServletRequest request) {
        String token = request.getHeader("iview-admin-token");
        boolean verify = TokenUtil.parseToken(token) != null;
        if (verify) {
            return Result.success();
        }
        return Result.success(ResultStatus.LOGIN_ERROR);
    }

    @ApiOperation(value = "用户列表", notes = "用户列表")
    @GetMapping("/queryList")
    public Result<IPage<UserDTO>> queryList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                            @RequestParam(value = "pageNum", required = false, defaultValue = "10") int pageSize) {
        return Result.success(userService.queryList(pageNum, pageSize));
    }


    /**
     * 用户名查询
     *
     * @param pageNum
     * @param pageSize
     * @param username
     * @return
     */
    @ApiOperation(value = "用户名查询", notes = "用户名查询")
    @GetMapping("/query")
    public Result<IPage<UserDTO>> queryList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                            @RequestParam(value = "pageNum", required = false, defaultValue = "10") int pageSize,
                                            @RequestParam(value = "username", required = false, defaultValue = "") String username) {
        if (username == null) return Result.failure();
        return Result.success(userService.queryListByName(pageNum, pageSize, username));
    }

    /**
     * @param userEntity
     * @return
     */
    /*@ApiOperation(value = "插入用户信息", notes = "插入用户信息")
    @PostMapping("/insertUser")
    public Result addDateUser(@RequestBody UserEntity userEntity) {
        return userService.insertUser(userEntity) ? Result.success() : Result.failure();
    }*/

    /**
     * 更新当前用户数据
     *
     * @param user
     * @return
     */
    /*@ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @PostMapping("/saveUser")
    public Result updateUser(@RequestBody UserEntity user) {
        return userService.updateUser(user) ? Result.success() : Result.failure(ResultStatus.NOT_MODIFIED);
    }*/

    /**
     * 根据ID删除用户数据
     *
     * @param id
     * @return
     */
    /*@ApiOperation(value = "删除用户信息", notes = "删除用户信息")
    @GetMapping("/delUser")
    public Result delUser(Integer id) {
        return userService.delUser(id) ? Result.success() : Result.failure();
    }*/



    /*@ApiOperation(value = "查询用户列表", notes = "查询用户列表")
    @GetMapping(value = "/list")
    public Result<IPage<UserEntity>> getList(PageRequest pageRequest) {
        return Result.success(userService.getList(pageRequest));
    }*/


    /*@ApiOperation(value = "查询用户信息", notes = "查询用户信息")
    @GetMapping("/query/{id}")
    public UserEntity findByUid(@RequestParam("id") long id) {
        return userService.findUserById(id);
    }*/
}
