package com.yanzi.study.lession8.util;

import javax.servlet.http.HttpServletRequest;

/**
*日志工具类
*@author yanzi
*@Date 10:25 2018/8/23
**/
public final class LoggerUtil {
    public static final String LOGGER_RETURN = "_logger_return";

    private LoggerUtil() {
    }

    /**
     * 获取客户端ip地址
     *
     * @param request
     * @return
     */
    public static String getCliectIp(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("Proxy-Client-IP");
        if(ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("WL-Proxy-Client-IP");
        if(ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip))
            ip = request.getRemoteAddr();

        //多个路由时，取第一个非unknown的ip
        final String[] arr = ip.split(",");
        for (final String str :arr){
            if(!"unknown".equalsIgnoreCase(str)){
                ip = str;
                break;
            }
        }
        return ip;
    }

    /**
     * 判断是否为ajax请求
     * @param request
     * @return
     */
    public static String getRequestType(HttpServletRequest request){
        return request.getHeader("X-Requested-With");
    }
}
