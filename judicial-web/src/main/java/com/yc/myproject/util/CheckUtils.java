package com.yc.myproject.util;

import com.yc.myproject.domain.entity.User;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * User: mcfell.yc
 * Date: 2017/9/13
 * Time: 下午9:25
 */
public class CheckUtils {

    public static void checkUser(User user) {
        Assert.isTrue(!StringUtils.isEmpty(user.getName()),"用户名为空");
        Assert.isTrue(!StringUtils.isEmpty(user.getPwd()),"密码为空");
    }

    public static void isAdminUser() {

    }
}
