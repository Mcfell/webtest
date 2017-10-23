package com.yc.myproject.enums;

/**
 * User: mcfell.yc
 * Date: 2017/9/14
 * Time: 下午8:19
 */
public enum  ErrorEnum {
    NOT_LOGIN(-20,"请先登录"),
    HAS_LOGOUT(-21,"你已退出登录，请勿重复操作"),
    HAS_LOGIN(-22,"你已登录，请勿重复操作"),

    NO_PERMISSION(-10,"你没有相关权限"),
    SYSYTEM_ERROR(-1,"系统错误");


    private int code;
    private String msg;

    ErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ErrorEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
