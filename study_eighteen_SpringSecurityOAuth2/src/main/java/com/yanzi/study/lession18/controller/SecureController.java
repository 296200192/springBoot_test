package com.yanzi.study.lession18.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
*获取授权Token后使用Token才可以访问
*@author yanzi
*@Date 11:06 2018/9/19
**/
@RestController
@RequestMapping("/secure")
public class SecureController {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(){return "Secure Hello!";}
}
