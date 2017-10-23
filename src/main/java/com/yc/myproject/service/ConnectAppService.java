package com.yc.myproject.service;

import com.yc.myproject.domain.entity.ConnectHistory;

import java.util.List;

/**
 * User: mcfell.yc
 * Date: 2017/9/12
 * Time: 下午3:22
 */
public interface ConnectAppService extends IService<ConnectHistory> {
    /**
     * 连接APP
     * @param appId
     * @return
     */
    int connect(Integer appId);

    List<ConnectHistory> getConnectHistory();
}
