package com.zixuan007.admin.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author zixuan007
 */
@Data
@TableName("user")
public class User implements Serializable {
    private long id;
    private String username;
    private String password;
    private Date birthday;
    @TableField("fullName")
    private String fullName;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
