package com.zixuan007.admin.controller;

import com.zixuan007.admin.constant.Result;
import com.zixuan007.admin.service.DepartmentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 部门控制
 *
 * @author zixuan2020
 * @date 2020/10/18
 */
@Api(value = "部门管理 - 部门信息管理api", tags = "部门管理 - 部门信息管理api")
@RequestMapping("/department")
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    public Result queryAll(){
        return null;
    }
}
