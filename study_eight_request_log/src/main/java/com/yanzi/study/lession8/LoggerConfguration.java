package com.yanzi.study.lession8;

import com.yanzi.study.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
*p配置拦截器
*@author yanzi
*@Date 14:32 2018/8/23
**/
@Configuration
public class LoggerConfguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("0------------------------>");
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
    }
}
