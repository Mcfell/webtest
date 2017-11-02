package com.yc.myproject.builders;

import java.util.concurrent.ExecutionException;

/**
 * User: mcfell.yc
 * Date: 2017/11/2
 * Time: 下午2:35
 */
public interface IBuilder<T> {

    T build() throws ExecutionException;

    String getName();

    void setName(String s);
}
