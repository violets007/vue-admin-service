package com.zixuan007.admin.pojo.bo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体模型数据Bean
 *
 * @author zixuan007
 */
@Data
@TableName("user")
public class UserBO implements Serializable {

    @TableId
    private long id;
    private String username;
    @JsonIgnore
    private String password;
    private Date birthday;
    private String fullName;
    private String remoteIp;
    private Date updateTime;
    private Date createTime;

    public UserBO() {
    }

    public UserBO(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
