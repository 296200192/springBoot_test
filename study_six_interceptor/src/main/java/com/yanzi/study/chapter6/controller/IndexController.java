package com.yanzi.study.chapter6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
*初始化登录、首页页面转发配置
*@author yanzi
*@Date 14:26 2018/8/20
**/
@Controller
@RequestMapping("/user")
public class IndexController {

    /**
     * 初始化登录页面
     * @return
     */
    @RequestMapping(value = "/login_view",method = RequestMethod.GET)
    public String login_view(){
        return "login";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
