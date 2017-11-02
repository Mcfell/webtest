package com.yc.myproject.service.impl;

import com.yc.myproject.builders.BaseFuture;
import com.yc.myproject.builders.IBuilder;
import com.yc.myproject.service.ThreadPoolService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * User: mcfell.yc
 * Date: 2017/11/2
 * Time: 下午2:46
 */
@Component("threadPoolService")
public class ThreadPool implements ThreadPoolService {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(20);

    @Override
    public void submit(List<BaseFuture> futureList, IBuilder builder) {
        Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return builder.build();
            }
        };
        Future<Object> future = executorService.submit(callable);
        futureList.add(new BaseFuture(builder.getName(),future));
    }
}
