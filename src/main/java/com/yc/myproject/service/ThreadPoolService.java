package com.yc.myproject.service;

import com.yc.myproject.builders.BaseFuture;
import com.yc.myproject.builders.IBuilder;

import java.util.List;

/**
 * User: mcfell.yc
 * Date: 2017/11/2
 * Time: 下午2:43
 */
public interface ThreadPoolService {
    /**
     * 添加任务
     * @param builder
     */
    void submit(List<BaseFuture> futureList, IBuilder builder);
}
