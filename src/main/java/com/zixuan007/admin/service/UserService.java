package com.zixuan007.admin.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zixuan007.admin.mapper.UserMapper;
import com.zixuan007.admin.pojo.PageRequest;
import com.zixuan007.admin.pojo.bo.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author apple
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserBO findUserById(long userId) {
        return userMapper.selectById(userId);
    }

    /**
     * 分页用户数据
     *
     * @return
     */
    public IPage<UserBO> getList(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();

        IPage<UserBO> page = new Page<>(pageNum, pageSize);
        QueryWrapper<UserBO> wrapper = new QueryWrapper<>();

        return userMapper.selectPage(page, wrapper);
    }

    public UserBO login(UserBO user) {
        QueryWrapper<UserBO> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", user.getUsername());
        userQueryWrapper.eq("password", user.getPassword());

        return userMapper.selectOne(userQueryWrapper);
    }

    public boolean delUser(int uid) {
        return userMapper.deleteById(uid) > 0 ? true : false;
    }

    public boolean updateUser(UserBO user) {
        return userMapper.updateById(user) > 0 ? true : false;
    }
}
