package com.yanzi.study.lession10.servlet;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
*@author yanzi
*@Date 16:33 2018/8/23
**/
@Configuration
@ServletComponentScan//方法2：@ServletComponentScan标签自动装配
public class ServletConfiguration {

    /**
     *方法一：使用bean注册servlet
     * http://localhost:8080/test
     * @return
     */
   /* @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new TestServlet(),"/test");
    }*/
}
