package com.yanzi.study;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
*SpringBoot默认给我们配置了静态资源的地址转发，我们只需要将静态文件放到/resources/static目录下，就可以直接访问了。但是这样往往会暴露给用户我们的项目结构,
 * 故自定义静态资源配置
*@author yanzi
*@Date 16:15 2018/8/23
**/
@Configuration
public class Lession9Configuration implements WebMvcConfigurer {

    /**
     * 自定义静态资源配置:http://localhost:8080//yanzi/resources/img/1.jpg
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/yanzi/resources/**").addResourceLocations("classpath:/static/");
    }
}
