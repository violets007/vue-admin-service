package com.zixuan007.admin.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2配置类
 * 在与spring boot集成时，放在与Application.java同级的目录下。
 *
 * @author zixuan2020
 * @date 2020/10/18
 */
@Configuration

public class Swagger2 {

    @Value("${swagger2.enable}")
    private boolean enable;

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zixuan007.admin.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .enable(enable);
    }

    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeyList = new ArrayList();
        apiKeyList.add(new ApiKey("iview-admin-token", "x-auth-token", "header"));
        return apiKeyList;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("后台管理系统接口")
                .description("基础接口")
                .termsOfServiceUrl("localhost:8081/iview-admin/swagger-ui.html")
                .version("1.0")
                .build();
    }

}
