package com.yanzi.study.lession8.controller;

import com.alibaba.fastjson.JSONObject;
import com.yanzi.study.lession8.util.LoggerUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
*登录测试
*@author yanzi
*@Date 14:29 2018/8/23
**/
@RestController
@RequestMapping(value = "/index")
public class IndexController {

    /**
     * 测试请求日志记录
     * @param request
     * @param name
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public JSONObject login(HttpServletRequest request,String name){
        System.out.println("2--------------------------->");
        System.out.println("name = " + name);
        JSONObject obj = new JSONObject();
        obj.put("msg","用户："+name+",登录成功。");
        //将返回值写入到请求对象中
        request.setAttribute(LoggerUtil.LOGGER_RETURN,obj);
        return obj;
    }
}
