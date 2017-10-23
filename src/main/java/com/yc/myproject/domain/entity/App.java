package com.yc.myproject.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class App implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * parentId
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * icon
     */
    private String icon;

    /**
     * name
     */
    private String name;

    /**
     * host
     */
    private String host;

    /**
     * port
     */
    private String port;

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
     * 获取parentId
     *
     * @return parent_id - parentId
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置parentId
     *
     * @param parentId parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取icon
     *
     * @return icon - icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置icon
     *
     * @param icon icon
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
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
     * 获取host
     *
     * @return host - host
     */
    public String getHost() {
        return host;
    }

    /**
     * 设置host
     *
     * @param host host
     */
    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    /**
     * 获取port
     *
     * @return port - port
     */
    public String getPort() {
        return port;
    }

    /**
     * 设置port
     *
     * @param port port
     */
    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", icon=").append(icon);
        sb.append(", name=").append(name);
        sb.append(", host=").append(host);
        sb.append(", port=").append(port);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}