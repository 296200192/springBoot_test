package com.yanzi.study.lession12;

import com.yanzi.study.lession12.controller.IndexController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    //logback
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * 访问首页
     * @return
     */
    @RequestMapping(value = "/test")
    public String index(){
        logger.info("test---->访问了index方法");
        logger.debug("test---->记录debug日志");
        logger.error("test---->记录error日志");
        return "test";
    }
}
