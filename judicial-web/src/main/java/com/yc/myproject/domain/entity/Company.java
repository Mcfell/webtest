package com.yc.myproject.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class Company implements Serializable {
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
     * detail
     */
    private String detail;

    /**
     * logo
     */
    private String logo;

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
     * 获取detail
     *
     * @return detail - detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置detail
     *
     * @param detail detail
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * 获取logo
     *
     * @return logo - logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 设置logo
     *
     * @param logo logo
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", detail=").append(detail);
        sb.append(", logo=").append(logo);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtUpdate=").append(gmtUpdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}