package com.yc.myproject.builders;

import java.util.concurrent.Future;

/**
 * User: mcfell.yc
 * Date: 2017/11/2
 * Time: 下午4:27
 */
public class BaseFuture {

    private String key;

    private Future future;

    public BaseFuture(String key, Future future) {
        this.key = key;
        this.future = future;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Future getFuture() {
        return future;
    }

    public void setFuture(Future future) {
        this.future = future;
    }
}
