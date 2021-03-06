package com.yc.myproject.exception;

import com.yc.myproject.enums.ErrorEnum;

/**
 * User: mcfell.yc
 * Date: 2017/9/13
 * Time: 下午7:16
 */
public class CheckException extends Exception{
    public CheckException() {
        super();
    }

    public CheckException(String message) {
        super(message);
    }

    public CheckException(ErrorEnum errorEnum) {
        super(errorEnum.toString());
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckException(Throwable cause) {
        super(cause);
    }
}
