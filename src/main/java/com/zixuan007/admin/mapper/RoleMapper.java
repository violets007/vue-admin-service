package com.zixuan007.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zixuan007.admin.pojo.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zixuan007
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {

    /**
     * 更新角色数据
     *
     * @param roleEntity
     * @return
     */
    public int updateRole(@Param("role") RoleEntity roleEntity);
}
