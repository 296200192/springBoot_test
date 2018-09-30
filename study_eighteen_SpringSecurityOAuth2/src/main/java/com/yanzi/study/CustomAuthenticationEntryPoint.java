package com.yanzi.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
*自定义401错误内容
*@author yanzi
*@Date 17:31 2018/9/19
**/
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final Logger logger = LoggerFactory.getLogger(CustomAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.info("Pre-authenticated entry point called. Rejecting access");
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");

    }
}
