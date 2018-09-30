package com.yanzi.study.lession18.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
*SpringSecurity不去管理的配置
*@author yanzi
*@Date 11:03 2018/9/19
**/
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(){
        return "Hello User!";
    }
}
