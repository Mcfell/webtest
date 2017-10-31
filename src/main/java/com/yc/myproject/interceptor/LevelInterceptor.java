package com.yc.myproject.interceptor;

import com.yc.myproject.domain.context.MainContext;
import com.yc.myproject.enums.ResponseEnum;
import com.yc.myproject.util.PrintWriterUtils;
import com.yc.myproject.util.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户权限拦截器
 * User: mcfell.yc
 * Date: 2017/9/13
 * Time: 下午11:29
 */
public class LevelInterceptor implements HandlerInterceptor{
    private static final Logger log = LoggerFactory.getLogger(LevelInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("==============执行顺序: 1、preHandle================");
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());
        log.info("requestUri:"+requestUri);
        log.info("contextPath:"+contextPath);
        log.info("url:"+url);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        //用户未登录
        if (MainContext.isLogOut()) {
            PrintWriterUtils.print(response, ResponseEnum.NOT_LOGIN);
            return false;
        }
        //权限控制
        if (!SecurityUtil.hasPermission(url, MainContext.getLevel())) {
            PrintWriterUtils.print(response, ResponseEnum.NO_PERMISSION);
            return false;
        }
        return true;
    }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
