package com.yc.myproject.domain.vo;

import java.io.Serializable;

/**
 * User: mcfell.yc
 * Date: 2017/9/7
 * Time: 上午11:33
 */
public class UserVO implements Serializable{
    private static final long serialVersionUID = 2196312139651099016L;

    private Integer id;

    private String name;

    private Integer status;

    private Integer level;

    private String gmtCreate;

    private String gmtUpdate;

    private String lastLogin;

    /**
     * 最近使用的app信息
     */
    private String apps;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(String gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getApps() {
        return apps;
    }

    public void setApps(String apps) {
        this.apps = apps;
    }
}
