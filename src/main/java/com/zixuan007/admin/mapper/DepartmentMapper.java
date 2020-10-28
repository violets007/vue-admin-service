package com.zixuan007.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zixuan007.admin.pojo.entity.DepartmentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zixuan007
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<DepartmentEntity> {

    /**
     * 更新部门
     *
     * @param departmentEntity
     * @return
     */
    public int updateDepartment(@Param("department") DepartmentEntity departmentEntity);
}
