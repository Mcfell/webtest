package com.yc.myproject.domain.vo;

import com.yc.myproject.domain.DO.StatisticInfoDO;

import java.io.Serializable;
import java.util.List;

/**
 * User: mcfell.yc
 * Date: 2017/10/13
 * Time: 下午8:07
 */
public class HomePageVO implements Serializable
{
    private static final long serialVersionUID = -1171949435219931125L;
    private StatisticInfoDO statisticInfoDO;
    private List<UserVO> userVOList;

    public List<UserVO> getUserVOList() {
        return userVOList;
    }

    public void setUserVOList(List<UserVO> userVOList) {
        this.userVOList = userVOList;
    }
}
