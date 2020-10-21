package com.zixuan007.admin.pojo.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体模型数据Bean
 *
 * @author zixuan007
 * @date 2020/10/21
 */
@Data
@TableName("t_user")
public class UserEntity extends BaseEntity implements Serializable {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 生日
     */
    private String phone;
    /**
     * 生日
     */
    private String email;
    /**
     * 真实姓名
     */
    private String fullName;
    /**
     * 远程IP
     */
    private String remoteIp;
    /**
     * 头像
     */
    private String headPortrait;

    public UserEntity() {
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
