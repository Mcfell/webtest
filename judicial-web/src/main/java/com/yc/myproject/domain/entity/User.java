package com.yc.myproject.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * name
     */
    private String name;

    /**
     * pwd
     */
    private String pwd;

    /**
     * status
     */
    private Integer status;

    /**
     * level
     */
    private Integer level;

    /**
     * gmtCreate
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * gmtUpdate
     */
    @Column(name = "gmt_update")
    private Date gmtUpdate;

    /**
     * lastLogin
     */
    @Column(name = "last_login")
    private Date lastLogin;

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
     * 获取name
     *
     * @return name - name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取pwd
     *
     * @return pwd - pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置pwd
     *
     * @param pwd pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * 获取status
     *
     * @return status - status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置status
     *
     * @param status status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取level
     *
     * @return level - level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置level
     *
     * @param level level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取gmtCreate
     *
     * @return gmt_create - gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置gmtCreate
     *
     * @param gmtCreate gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取gmtUpdate
     *
     * @return gmt_update - gmtUpdate
     */
    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    /**
     * 设置gmtUpdate
     *
     * @param gmtUpdate gmtUpdate
     */
    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    /**
     * 获取lastLogin
     *
     * @return last_login - lastLogin
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * 设置lastLogin
     *
     * @param lastLogin lastLogin
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", pwd=").append(pwd);
        sb.append(", status=").append(status);
        sb.append(", level=").append(level);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtUpdate=").append(gmtUpdate);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}