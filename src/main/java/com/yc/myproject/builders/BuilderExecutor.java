package com.yc.myproject.builders;

import com.google.common.collect.Lists;
import com.yc.myproject.service.ThreadPoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: mcfell.yc
 * Date: 2017/11/2
 * Time: 下午3:27
 */
@Component
@Scope("prototype")
public class BuilderExecutor {

    private static final Logger logger = LoggerFactory.getLogger(BuilderExecutor.class);

    private static final int DEFAULT_TIMEOUT = 3;

    private List<BaseFuture> futureList;

    private AtomicInteger key;

    @Resource
    ThreadPoolService threadPoolService;

    public BuilderExecutor() {
        key = new AtomicInteger(0);
        this.futureList = Lists.newArrayList();
    }

    public BuilderExecutor addBuilder(IBuilder builder) {
        builder.setName(new Date().getTime()+"_" + key.incrementAndGet());
        threadPoolService.submit(futureList,builder);
        return this;
    }

    public <T> T getResult(IBuilder<T> builder, int overTime){
        for (BaseFuture baseFuture : futureList) {
            if (baseFuture.getKey().equals(builder.getName())) {
                Future future = baseFuture.getFuture();
                try {
                    return (T) future.get(overTime, TimeUnit.SECONDS);
                } catch (Exception e) {
                    future.cancel(true);
                    logger.error("并发构建失败，builderName:{}",builder.getName());
                    return null;
                }
            }
        }
        return null;
    }

    public <T> T getResult(IBuilder<T> builder){
        return getResult(builder,DEFAULT_TIMEOUT);
    }
}
