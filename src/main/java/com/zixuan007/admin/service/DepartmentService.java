package com.zixuan007.admin.service;

import com.zixuan007.admin.mapper.DepartmentMapper;
import com.zixuan007.admin.pojo.entity.DepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zixuan007
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 创建部门
     *
     * @param departmentEntity
     * @return
     */
    public boolean insertDepartment(DepartmentEntity departmentEntity) {
        return departmentMapper.insert(departmentEntity) > 0 ? true : false;
    }

    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    public boolean deleteDepartment(int id) {
        return departmentMapper.deleteById(id) > 0 ? true : false;
    }


}
