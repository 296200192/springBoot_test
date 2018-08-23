package com.yanzi.study.lession12.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
*@author yanzi
*@Date 19:13 2018/8/23
**/
@RestController
public class IndexController {
    //logback
    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**
     * 访问首页
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(){
        logger.info("访问了index方法");
        logger.debug("记录debug日志");
        logger.error("记录error日志");
        return "index";
    }
}
