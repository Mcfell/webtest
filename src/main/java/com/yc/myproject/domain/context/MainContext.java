package com.yc.myproject.domain.context;

import com.yc.myproject.domain.entity.User;
import com.yc.myproject.enums.LevelEnum;
import com.yc.myproject.service.sys.CacheService;
import com.yc.myproject.util.SpringUtil;

/**
 * User: mcfell.yc
 * Date: 2017/10/11
 * Time: 下午4:34
 */
public class MainContext {

    public static boolean isAdmin(){
        if (getLevel() == LevelEnum.ADMINISTRATOR.getVal()) {
            return true;
        }
        return false;
    }

    public static boolean isLogIn(String name) {
        return CacheService.hasLogin(name);
    }

    public static boolean isLogIn() {
        return !isLogOut();
    }

    public static boolean isLogOut() {
        if (getUser() == null) {
            return true;
        }
        return false;
    }

    public static User getUser(){
        UserSession userSession = SpringUtil.getBean(UserSession.class);
        if (userSession == null) {
            return null;
        }
        return userSession.getUser();
    }

    public static Integer getUserId() {
        return getUser().getId();
    }

    public static String getName() {
        User user = getUser();
        if (user == null) {
            return null;
        }
        return user.getName();
    }

    public static Integer getStatus() {
        User user = getUser();
        if (user == null) {
            return null;
        }
        return user.getStatus();
    }

    public static Integer getLevel() {
        User user = getUser();
        if (user == null) {
            return null;
        }
        return user.getLevel();
    }


}
