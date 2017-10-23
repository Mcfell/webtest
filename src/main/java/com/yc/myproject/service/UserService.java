package com.yc.myproject.service;

import com.yc.myproject.domain.entity.User;
import com.yc.myproject.domain.vo.UserVO;
import com.yc.myproject.exception.CheckException;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * User: mcfell.yc
 * Date: 2017/9/12
 * Time: 下午3:22
 */
public interface UserService extends IService<User>{
    List<User> selectAll(int page, int rows);

    User login(User user) throws CheckException;

    int logout(User user) throws CheckException;

    int countAll();

    List<UserVO> getCurrentUsers(int page, int rows) throws ExecutionException;
}
