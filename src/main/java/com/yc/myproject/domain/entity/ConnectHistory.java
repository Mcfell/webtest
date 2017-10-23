package com.yc.myproject.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "connect_history")
public class ConnectHistory implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * userId
     */
    @Column(name = "userId")
    private Integer userid;

    /**
     * appId
     */
    @Column(name = "appId")
    private Integer appid;

    /**
     * appName
     */
    @Column(name = "appName")
    private String appname;

    /**
     * connect_start
     */
    @Column(name = "connect_start")
    private Date connectStart;

    /**
     * connect_end
     */
    @Column(name = "connect_end")
    private Date connectEnd;

    private static final long serialVersionUID = 1L;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取userId
     *
     * @return userId - userId
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置userId
     *
     * @param userid userId
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取appId
     *
     * @return appId - appId
     */
    public Integer getAppid() {
        return appid;
    }

    /**
     * 设置appId
     *
     * @param appid appId
     */
    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    /**
     * 获取appName
     *
     * @return appName - appName
     */
    public String getAppname() {
        return appname;
    }

    /**
     * 设置appName
     *
     * @param appname appName
     */
    public void setAppname(String appname) {
        this.appname = appname == null ? null : appname.trim();
    }

    /**
     * 获取connect_start
     *
     * @return connect_start - connect_start
     */
    public Date getConnectStart() {
        return connectStart;
    }

    /**
     * 设置connect_start
     *
     * @param connectStart connect_start
     */
    public void setConnectStart(Date connectStart) {
        this.connectStart = connectStart;
    }

    /**
     * 获取connect_end
     *
     * @return connect_end - connect_end
     */
    public Date getConnectEnd() {
        return connectEnd;
    }

    /**
     * 设置connect_end
     *
     * @param connectEnd connect_end
     */
    public void setConnectEnd(Date connectEnd) {
        this.connectEnd = connectEnd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", appid=").append(appid);
        sb.append(", appname=").append(appname);
        sb.append(", connectStart=").append(connectStart);
        sb.append(", connectEnd=").append(connectEnd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}