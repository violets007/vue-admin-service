package com.zixuan007.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zixuan007.admin.mapper.UserMapper;
import com.zixuan007.admin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author apple
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(long userId) {
        return userMapper.selectById(userId);
    }

    public List getList() {
        return userMapper.findAll();
    }

    public User login(User user) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", user.getUsername());
        userQueryWrapper.eq("password", user.getPassword());

        return userMapper.selectOne(userQueryWrapper);
    }
}
