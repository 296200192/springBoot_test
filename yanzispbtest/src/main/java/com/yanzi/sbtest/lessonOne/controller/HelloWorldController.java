package com.yanzi.sbtest.lessonOne.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
*SpringBoot 启动测试hello World
*@author yanzi
*@Date 10:49 2018/8/15
**/
@RestController
@RequestMapping
public class HelloWorldController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "Hello World!";
    }
}
