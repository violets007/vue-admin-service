package com.zixuan007.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
