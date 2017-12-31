package com.yc.myproject.domain.vo;

import java.io.Serializable;
import java.util.List;

/**
 * User: mcfell.yc
 * Date: 2017/9/7
 * Time: 上午11:37
 */
public class AppVO implements Serializable{

    private static final long serialVersionUID = -5416494851136614418L;
    private Integer id;
    private Integer parentId;
    private String icon;
    private String name;
    private String host;
    private String port;
    private List<AppVO> softWares;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public List<AppVO> getSoftWares() {
        return softWares;
    }

    public void setSoftWares(List<AppVO> softWares) {
        this.softWares = softWares;
    }
}
