package com.zixuan007.admin.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zixuan007.admin.mapper.UserMapper;
import com.zixuan007.admin.pojo.PageRequest;
import com.zixuan007.admin.pojo.dto.UserDTO;
import com.zixuan007.admin.pojo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 用户业务
 *
 * @author apple
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserEntity findUserById(long userId) {
        return userMapper.selectById(userId);
    }

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
        return userMapper.updateUser(user) > 0 ? true : false;
    }

    /**
     * 查询用户列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public IPage<UserDTO> queryList(int pageNum, int pageSize) {
        return userMapper.queryList(new Page<UserDTO>(pageNum, pageSize));
    }

    /**
     * 根据用户名进行分页
     *
     * @param pageNum
     * @param pageSize
     * @param username
     * @return
     */
    public IPage<UserDTO> queryListByName(int pageNum, int pageSize, String username) {
        Page<UserDTO> page = new Page<>(pageNum, pageSize);
        return userMapper.queryListByName(page, username);
    }

    public boolean insertUser(UserEntity userEntity) {
        userEntity.setUpdateTime(new Date()); // 插入更新时间默认为当前时间
        userEntity.setCreateTime(new Date()); // 插入创建时间默认为当前时间

        return userMapper.insert(userEntity) > 0 ? true : false;
    }
}
