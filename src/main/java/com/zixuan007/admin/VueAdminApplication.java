package com.zixuan007.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zixuan007
 */
@SpringBootApplication
@MapperScan("com.zixuan007.admin.mapper")
public class VueAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueAdminApplication.class);
    }
}
