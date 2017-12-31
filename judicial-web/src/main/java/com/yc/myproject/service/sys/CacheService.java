package com.yc.myproject.service.sys;


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import com.yc.myproject.domain.DO.StatisticInfoDO;
import com.yc.myproject.domain.entity.ConnectHistory;
import com.yc.myproject.service.AppService;
import com.yc.myproject.service.ConnectAppService;
import com.yc.myproject.service.ServiceHolder;
import com.yc.myproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: mcfell.yc
 * Date: 2017/10/11
 * Time: 下午3:07
 */
@Service
public class CacheService{

    public static final Logger logger = LoggerFactory.getLogger(CacheService.class);
    @Autowired
    ServiceHolder serviceHolder;
    public static final String CONNECT_HISTORY_MAP = "historyMap";

    public static final String USER_TOTAL_NUM = "userTotalNum";

    public static final String APP_TOTAL_NUM = "appTotalNum";

    public static final AtomicInteger onlineUserNum = new AtomicInteger();

    private LoadingCache<String, Object> LocalHoursCache = CacheBuilder.newBuilder()
            .maximumSize(10)
            .expireAfterWrite(1, TimeUnit.MINUTES)
            .build(
                    new CacheLoader<String, Object>() {
                        public Object load(String key) throws Exception {
                            return loadKey(key);
                        }
                    });

    public void addUserOne(){
        onlineUserNum.addAndGet(1);
    }
    public void decreaseUserOne(){
        onlineUserNum.decrementAndGet();
    }

    public Integer getOnlineUserNum(){
        return onlineUserNum.get();
    }

    private Integer loadUserTotalNum(){
        UserService userService = serviceHolder.getUserService();
        return userService.countAll();
    }
    private  Integer loadAppTotalNum(){
        AppService appService = serviceHolder.getAppService();
        return appService.countAll();
    }
    private  Map<Integer, String> loadConnectHistoryMap(){
        ConnectAppService connectAppService = serviceHolder.getConnectAppService();
        List<ConnectHistory> connectHistorys = connectAppService.getConnectHistory();
        Map<Integer, String> map = getConnectHistoryMap(connectHistorys);
        return map;
    }

    private  Map<Integer, String> getConnectHistoryMap(List<ConnectHistory> connectHistorys) {
        Map<Integer,String> map = Maps.newHashMap();
        for (ConnectHistory connectHistory : connectHistorys) {
            Integer userid = connectHistory.getUserid();
            String appname = connectHistory.getAppname();
            map.put(userid,appname);
        }
        return map;
    }


    public  Object loadKey(String key) {
        if (key.equals(USER_TOTAL_NUM)) {
           return loadUserTotalNum();
        } else if (key.equals(APP_TOTAL_NUM)) {
           return loadAppTotalNum();
        } else if (key.equals(CONNECT_HISTORY_MAP)) {
           return loadConnectHistoryMap();
        } else return null;
    }

    public void buildStatisticInfo(StatisticInfoDO statisticInfoDO) throws ExecutionException {
        if (statisticInfoDO == null) {
            return;
        }
        statisticInfoDO.setAllUserNum((Integer) LocalHoursCache.get(USER_TOTAL_NUM));
        statisticInfoDO.setAllAppNum((Integer) LocalHoursCache.get(APP_TOTAL_NUM));
    }

    public Map<Integer, String> getUserAppHistory(){
        try {
            return (Map<Integer, String>) LocalHoursCache.get(CONNECT_HISTORY_MAP);
        } catch (ExecutionException e) {
            logger.error("获取用户app使用记录缓存失败",e);
        }
        return null;
    }


}
