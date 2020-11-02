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
public interface RoleUserMapper extends BaseMapper<UserEntity> {


    /**
     * 绑定一条用户与角色
     *
     * @param uid
     * @param rid
     * @return
     */
    int insertRoleUser(@Param("uid") int uid, @Param("rid") int rid);


    /**
     * 根据用户ID查询用户所拥有的的角色ID
     *
     * @param uid
     * @return
     */
    List<Integer> queryRoleIdByUid(@Param("uid") int uid);

    /**
     * 移除当前用户的所有角色
     *
     * @param uid
     * @return
     */
    int deleteByUid(@Param("uid") int uid);

    /**
     * 删除当前角色所绑定的所有用户
     *
     * @param rid
     * @return
     */
    int deleteByRid(@Param("rid") int rid);

    /**
     * 根据用户ID和角色ID删除当前关系
     *
     * @param uid
     * @param rid
     * @return
     */
    int deleteByUidAndRid(@Param("uid") int uid, @Param("rid") int rid);

    /**
     * 根据用户id查询角色id名称
     *
     * @param uid
     * @return
     */
    List<String> queryRoleNameByUid(@Param("uid") int uid);


}
