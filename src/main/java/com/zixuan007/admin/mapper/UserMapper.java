package com.zixuan007.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zixuan007.admin.pojo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;


/**
 * @author zixuan007
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * 查询用户列表
     *
     * @return
     */
    List<UserEntity> queryUserList();


    /**
     * 更新用户数据
     *
     * @param user
     * @return
     */
    int updateUser(@Param("user") UserEntity user);


}
