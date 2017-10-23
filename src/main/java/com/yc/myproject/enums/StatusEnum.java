package com.yc.myproject.enums;

/**
 * User: mcfell.yc
 * Date: 2017/9/13
 * Time: 下午9:11
 */
public enum StatusEnum {
    OFFLINE(-1),ONLINE(1);
    private Integer val;
    private StatusEnum(Integer val){
        this.val = val;
    }

    public Integer getVal() {
        return val;
    }
}
