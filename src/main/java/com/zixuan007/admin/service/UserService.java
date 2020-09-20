package com.zixuan007.admin.service;

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
        return userMapper.selectByPrimaryKey(userId);
    }

    public List getList() {
        return userMapper.selectAll();
    }

    public boolean login(User user) {
        return userMapper.select(user) != null;
    }
}
