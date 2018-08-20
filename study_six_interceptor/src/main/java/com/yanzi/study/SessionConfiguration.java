package com.yanzi.study;

import com.yanzi.study.chapter6.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
*配置拦截器配置和路径，将拦截器添加到SpringBoot中
*@author yanzi
*@Date 14:21 2018/8/20
**/
@Configuration
public class SessionConfiguration implements WebMvcConfigurer
{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
    }
}
