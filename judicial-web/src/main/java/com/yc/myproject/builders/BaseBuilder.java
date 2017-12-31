package com.yc.myproject.builders;


import java.util.concurrent.ExecutionException;

/**
 * User: mcfell.yc
 * Date: 2017/11/2
 * Time: 下午2:37
 */
public abstract class BaseBuilder<T> implements IBuilder<T> {


    public abstract  T build() throws ExecutionException;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
