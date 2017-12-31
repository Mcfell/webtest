package com.yc.myproject.service;

import com.yc.myproject.domain.entity.App;
import com.yc.myproject.domain.vo.AppVO;

import java.util.List;

/**
 * User: mcfell.yc
 * Date: 2017/9/12
 * Time: 下午3:22
 */
public interface AppService extends IService<App>{

    List<AppVO> selectAll(int page, int rows);

    int deleteFatherAndChild(int id);

    int countAll();
}
