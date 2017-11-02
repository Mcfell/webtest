package com.yc.myproject.builders.biz;

import com.yc.myproject.builders.BaseBuilder;
import com.yc.myproject.domain.vo.UserVO;
import com.yc.myproject.service.ServiceHolder;
import com.yc.myproject.service.UserService;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * User: mcfell.yc
 * Date: 2017/11/2
 * Time: 下午5:03
 */
public class UsersBuilder extends BaseBuilder<List<UserVO>> {

    @Override
    public List<UserVO> build() throws ExecutionException {
        UserService userService = ServiceHolder.getInstance().getUserService();
        return userService.getCurrentUsers(0, 10);
    }
}
