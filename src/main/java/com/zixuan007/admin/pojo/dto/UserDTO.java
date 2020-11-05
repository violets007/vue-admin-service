package com.zixuan007.admin.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 用户列表
 *
 * @author zixuan007
 * @date 2020/10/18
 */
@Data
public class UserDTO {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("头像url")
    private String headPortrait;

    @ApiModelProperty("生日")
    private String birthday;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("是否禁用")
    private boolean status;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("真实姓名")
    private String fullName;

    @ApiModelProperty("登录IP")
    private String remoteIp;


}
