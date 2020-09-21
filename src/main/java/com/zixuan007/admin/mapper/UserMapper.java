package com.zixuan007.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zixuan007.admin.pojo.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;


/**
 * @author zixuan007
 */
@Mapper

public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询所有的用户数据
     *
     * @return
     */
    List<User> findAll();
}
