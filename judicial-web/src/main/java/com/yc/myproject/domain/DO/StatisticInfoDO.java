package com.yc.myproject.domain.DO;

import java.io.Serializable;

/**
 *
 * User: mcfell.yc
 * Date: 2017/10/13
 * Time: 下午2:49
 */
public class StatisticInfoDO implements Serializable {

    private static final long serialVersionUID = -7597418351600762791L;
    private Integer allUserNum;
    private Integer allAppNum;
    private Integer onlineNum;
    private Integer offlineNum;
    public Integer getAllUserNum() {
        return allUserNum;
    }

    public void setAllUserNum(Integer allUserNum) {
        this.allUserNum = allUserNum;
    }

    public Integer getAllAppNum() {
        return allAppNum;
    }

    public void setAllAppNum(Integer allAppNum) {
        this.allAppNum = allAppNum;
    }

    public Integer getOnlineNum() {
        return onlineNum;
    }

    public void setOnlineNum(Integer onlineNum) {
        this.onlineNum = onlineNum;
    }

    public Integer getOfflineNum() {
        return offlineNum;
    }

    public void setOfflineNum(Integer offlineNum) {
        this.offlineNum = offlineNum;
    }
}
