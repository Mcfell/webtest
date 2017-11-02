package com.yc.myproject.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * User: mcfell.yc
 * Date: 2017/10/13
 * Time: 下午7:40
 */
@Component
public class ServiceHolder implements InitializingBean,ApplicationContextAware {

    private ApplicationContext        applicationContext;
    @Resource
    private ConnectAppService connectAppService;

    @Resource
    private UserService userService;

    @Resource
    private AppService appService;

    @Resource
    private ThreadPoolService threadPoolService;

    @Resource
    private CompanyService companyService;

    private static ServiceHolder instance;

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

    public static ServiceHolder getInstance() {
        return instance;
    }

    public ThreadPoolService getThreadPoolService() {
        return threadPoolService;
    }

    public void setThreadPoolService(ThreadPoolService threadPoolService) {
        this.threadPoolService = threadPoolService;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        instance = applicationContext.getBean(ServiceHolder.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
