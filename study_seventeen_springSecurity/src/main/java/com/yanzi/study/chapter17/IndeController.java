package com.yanzi.study.chapter17;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
*@author yanzi
*@Date 16:29 2018/9/18
**/
@RestController
public class IndeController {
    @RequestMapping(value = "/index")
    public String index(){
        return "get index success";
    }
}
