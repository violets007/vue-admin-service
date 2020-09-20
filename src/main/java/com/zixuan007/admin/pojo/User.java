package com.zixuan007.admin.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author zixuan007
 */
@Data
@Table(name = "user")
public class User {
    private long id;
    private String username;
    private String password;
    private String birthday;
    @Column(name = "fullName")
    private String fullName;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
