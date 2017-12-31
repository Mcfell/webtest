package com.yc.myproject.enums;

/**
 * User: mcfell.yc
 * Date: 2017/9/13
 * Time: 下午9:14
 */
public enum LevelEnum {
    NORMAL(0),
    ADMINISTRATOR(1);
    private Integer val;
    private LevelEnum(Integer val) {
        this.val = val;
    }

    public Integer getVal() {
        return val;
    }
}
