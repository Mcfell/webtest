package com.yc.myproject.service.impl;

import com.yc.myproject.domain.context.MainContext;
import com.yc.myproject.domain.entity.App;
import com.yc.myproject.domain.entity.ConnectHistory;
import com.yc.myproject.mapper.AppMapper;
import com.yc.myproject.mapper.ConnectHistoryMapper;
import com.yc.myproject.service.ConnectAppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * User: mcfell.yc
 * Date: 2017/10/13
 * Time: 下午3:21
 */
@Service("ConnectAppService")
public class ConnectAppServiceImpl extends BaseService<ConnectHistory> implements ConnectAppService {

    public static final Logger log = LoggerFactory.getLogger(ConnectAppService.class);

    @Autowired
    AppMapper appMapper;

    @Autowired
    ConnectHistoryMapper connectHistoryMapper;


    @Override
    public int connect(Integer appId) {
        App app = appMapper.selectByPrimaryKey(appId);
        if (app != null) {
            ConnectHistory connectHistory = new ConnectHistory();
            connectHistory.setUserid(MainContext.getUserId());
            connectHistory.setAppid(appId);
            connectHistory.setAppname(app.getName());
            connectHistory.setConnectStart(new Date());
            return mapper.insert(connectHistory);
        } else {
            log.error("ConnectAppServiceImpl connect failed: appId is wrong {}", appId);
            return 0;
        }
    }

    /**
     * @return 获取所有用户最近连接的3个app
     */
    @Override
    public List<ConnectHistory> getConnectHistory() {
        return connectHistoryMapper.getRecentConnectHistory();
    }


}
