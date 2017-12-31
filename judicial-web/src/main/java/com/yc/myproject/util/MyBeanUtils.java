package com.yc.myproject.util;

import com.google.common.collect.Lists;
import com.yc.myproject.domain.entity.App;
import com.yc.myproject.domain.entity.User;
import com.yc.myproject.domain.vo.AppVO;
import com.yc.myproject.domain.vo.UserVO;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * User: mcfell.yc
 * Date: 2017/9/13
 * Time: 上午10:28
 */
public class MyBeanUtils {

    public static final String DATE_FORMATE = "yyyy-MM-dd HH:mm:ss";

    public static <T,S> S convertBean(T source,Class<S> objClass) {
        if (source == null) {
            return null;
        }
        try {
            S s = objClass.newInstance();
            BeanUtils.copyProperties(source,s);
            return s;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static List<UserVO> covert2UserVOList(List<User> users) {
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        List<UserVO> userVOS = Lists.newArrayList();
        for (User user : users) {
            userVOS.add(convert2UserVO(user));
        }
        return userVOS;
    }

    public static List<UserVO> covert2UserVOList(List<User> users,Map<Integer, String> connectMap) {
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        List<UserVO> userVOS = Lists.newArrayList();
        for (User user : users) {
            UserVO userVO = convert2UserVO(user);
            if (connectMap !=null && connectMap.containsKey(user.getId())) {
                userVO.setApps(connectMap.get(user.getId()));
            }
            userVOS.add(userVO);
        }
        return userVOS;
    }


    public static UserVO convert2UserVO(User user) {
        if (user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setName(user.getName());
        userVO.setLevel(user.getLevel());
        userVO.setStatus(user.getStatus());
        if (user.getLastLogin() != null) {
            userVO.setLastLogin(DateFormatUtils.format(user.getLastLogin(), DATE_FORMATE));
        }
        if (user.getGmtUpdate() != null) {
            userVO.setGmtUpdate(DateFormatUtils.format(user.getGmtUpdate(), DATE_FORMATE));
        }
        if (user.getGmtCreate() != null) {
            userVO.setGmtCreate(DateFormatUtils.format(user.getGmtCreate(), DATE_FORMATE));
        }
        return userVO;
    }

    public static AppVO convert2AppVO(App app) {
        if (app == null) {
            return null;
        }
        AppVO appVO = new AppVO();
        appVO.setId(app.getId());
        appVO.setName(app.getName());
        appVO.setIcon(app.getIcon());
        appVO.setParentId(app.getParentId());
        appVO.setHost(app.getHost());
        appVO.setPort(app.getPort());
        return appVO;
    }
}
