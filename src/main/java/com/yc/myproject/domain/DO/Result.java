package com.yc.myproject.domain.DO;

import com.alibaba.fastjson.JSON;
import com.yc.myproject.enums.ResponseEnum;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * User: mcfell.yc
 * Date: 2017/9/13
 * Time: 上午12:31
 */
@Data
public class Result<T> {
    private static final long serialVersionUID = 1L;
    public static final int SUCCESS = 0;
    public static final int FAIL = -1;
    private String msg = "success";
    private int code = SUCCESS;
    private T data;
    public Result() {

    }
    public Result(T data) {
        if (data == null) {
            code = FAIL;
        } else if (data instanceof Integer && (Integer)data == 0
                || data instanceof List && ((List) data).size() == 0
                || data instanceof Map && ((Map) data).size() == 0){
            code = FAIL;
        } else {
            this.data = data;
        }
    }
    public Result(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.msg  = responseEnum.getMsg();
    }

    public Result(int code, String errorMsg) {
        super();
        this.code = code;
        this.msg  = errorMsg;
    }
    public Result(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = FAIL ;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
