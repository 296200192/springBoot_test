package com.yanzi.study;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yanzi.study.lession8.entity.LoggerEntity;
import com.yanzi.study.lession8.jpa.LoggerJPA;
import com.yanzi.study.lession8.util.LoggerUtil;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerInterceptor implements HandlerInterceptor {

    //开始请求时间标识
    private static final String LOGGER_SEND_TIME = "_send_time";
    //请求日志实体标识
    private static final String LOGGER_ENTITY = "_logger_entity";

    /**
     * 进入SpringMVC的Controller之前开始记录日志实体
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("1 = " + 1);
        //创建日志实体
        LoggerEntity loggerEntity = new LoggerEntity();
        //获取请求sessionId
        String sessionId = request.getRequestedSessionId();
        //请求路径
        String url = request.getRequestURI();
        //获取请求参数信息
        String paramData = JSON.toJSONString(
                request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        //设置客户端ip
        loggerEntity.setClientIp(LoggerUtil.getCliectIp(request));
        //设置请求方法
        loggerEntity.setMethod(request.getMethod());
        //设置请求类型（json|普通请求）
        loggerEntity.setType(LoggerUtil.getRequestType(request));
        //设置请求参数内容json字符串
        loggerEntity.setParamData(paramData);
        //设置请求地址
        loggerEntity.setUri(url);
        //设置sessionId
        loggerEntity.setSessionId(sessionId);
        //设置请求开始时间
        request.setAttribute(LOGGER_SEND_TIME,System.currentTimeMillis());
        //设置请求实体到request内，方便afterCompletion方法调用
        request.setAttribute(LOGGER_ENTITY,loggerEntity);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //获取请求错误码
        int status = response.getStatus();
        //当前时间
        long currentTime = System.currentTimeMillis();
        //请求开始时间
        long time = Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());
        //获取本次请求的日志实体
        LoggerEntity loggerEntity = (LoggerEntity)request.getAttribute(LOGGER_ENTITY);
        //设置请求时间差
        loggerEntity.setTimeConsuming(Integer.valueOf((currentTime - time)+""));
        //设置返回时间
        loggerEntity.setReturnTime(currentTime+"");
        //设置返回错误码
        loggerEntity.setHttpStatusCode(status+"");
        //设置返回值
        loggerEntity.setReturnData(JSON.toJSONString(request.getAttribute(LoggerUtil.LOGGER_RETURN),SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        //执行将日志写入数据库
        LoggerJPA loggerJPA = getDAO(LoggerJPA.class,request);
        loggerJPA.save(loggerEntity);

    }

    /**
     * 根据传入的类型获取spring管理的对应dao
     * @param loggerJPAClass 类型
     * @param request 请求对象
     * @param <T>
     * @return
     */

    private <T>T getDAO(Class<T> loggerJPAClass, HttpServletRequest request) {
        BeanFactory factory =WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(loggerJPAClass);
    }
}
