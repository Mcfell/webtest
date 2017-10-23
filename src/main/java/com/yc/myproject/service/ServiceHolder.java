package com.yc.myproject.service;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * User: mcfell.yc
 * Date: 2017/10/13
 * Time: 下午7:40
 */
@Component
public class ServiceHolder{


    @Resource
    private ConnectAppService connectAppService;

    @Resource
    private UserService userService;

    @Resource
    private AppService appService;

    public AppService getAppService() {
        return appService;
    }

    public UserService getUserService() {
        return userService;
    }

    public  ConnectAppService getConnectAppService() {
        return connectAppService;
    }

    public void setConnectAppService(ConnectAppService connectAppService) {
        this.connectAppService = connectAppService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setAppService(AppService appService) {
        this.appService = appService;
    }
}
