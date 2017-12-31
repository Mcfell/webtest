package com.yc.myproject.domain.context;

import com.yc.myproject.domain.entity.User;
import com.yc.myproject.service.UserService;
import com.yc.myproject.service.sys.CacheService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * User: mcfell.yc
 * Date: 2017/10/11
 * Time: 下午6:49
 */

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession implements DisposableBean{

    @Autowired
    UserService userService;

    @Autowired
    CacheService cacheService;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void destroy() throws Exception {
        cacheService.decreaseUserOne();
        userService.logout(user);
    }
}
