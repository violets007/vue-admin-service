package com.zixuan007.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zixuan007
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.zixuan007.admin.mapper")
public class VueAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueAdminApplication.class);
    }
}
