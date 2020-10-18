package com.zixuan007.admin.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zixuan007.admin.mapper.UserMapper;
import com.zixuan007.admin.pojo.PageRequest;
import com.zixuan007.admin.pojo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author apple
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserEntity findUserById(long userId) {
        return userMapper.selectById(userId);
    }

    /**
     * 分页用户数据
     *
     * @return
     */
    public IPage<UserEntity> getList(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();

        IPage<UserEntity> page = new Page<>(pageNum, pageSize);
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();

        return userMapper.selectPage(page, wrapper);
    }

    public UserEntity login(UserEntity user) {
        QueryWrapper<UserEntity> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", user.getUsername());
        userQueryWrapper.eq("password", user.getPassword());

        return userMapper.selectOne(userQueryWrapper);
    }

    public boolean delUser(int uid) {
        return userMapper.deleteById(uid) > 0 ? true : false;
    }

    public boolean updateUser(UserEntity user) {
        return userMapper.updateById(user) > 0 ? true : false;
    }
}
