package com.springboot.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
*spring boot 配置jsp
*@author yanzi
*@Date 10:26 2018/8/16
**/
@Controller
public class IndexController {

    /**
     * application.properties
     * 配置前缀：/WEB-INF/jsp
     * 配置后缀：.jsp
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
}
