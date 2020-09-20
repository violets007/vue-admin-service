package com.zixuan007.admin.config;

import com.zixuan007.admin.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 拦截器配置
 *
 * @author zixuan007
 */
@Configuration
public class InterceptConfiguration implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    //构造方法
    public InterceptConfiguration(TokenInterceptor tokenInterceptor) {
        this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //排除拦截器的列表
        List<String> excludePath = new ArrayList<>();
        excludePath.add("/user_register");  //注册
        excludePath.add("/login");          //登录
        excludePath.add("/logout");         //登出
        excludePath.add("/static/**");      //静态资源
        excludePath.add("/assets/**");      //静态资源

        System.out.println(excludePath);
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath);
        WebMvcConfigurer.super.addInterceptors(registry);

    }

    /* *
     * @Author lsc
     * <p>跨域支持 </p>
     * @Param [registry]
     * @Return void
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS", "HEAD")
                .maxAge(3600 * 24);
    }
}