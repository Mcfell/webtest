package com.yc.myproject.configure.aop;

import com.yc.myproject.domain.DO.Result;
import com.yc.myproject.exception.CheckException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * User: mcfell.yc
 * Date: 2017/9/13
 * Time: 下午7:03
 */
@Aspect
@Component
public class ControllerLogAop {
    private static final Logger log = LoggerFactory.getLogger(ControllerLogAop.class);
    @Pointcut("execution(public com.yc.myproject.domain.DO.Result com.yc.myproject.controller.*.*(..))")
    public void controllerLog(){}

    @Around("controllerLog()")
    public Object doAround(ProceedingJoinPoint pjp){
        long startTime = System.currentTimeMillis();
        Result<?> result;
        try {
            result = (Result<?>) pjp.proceed();
            log.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }
        return result;
    }
    private Result<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        Result<?> result = new Result();
        // 已知异常
        if (e instanceof CheckException ||
                e instanceof IllegalArgumentException) {
            result.setMsg(e.getLocalizedMessage());
            result.setCode(Result.FAIL);
        } else {
            log.error(pjp.getSignature() + " error ", e);
            result.setMsg(e.toString());
            result.setCode(Result.FAIL);
            // 未知异常是应该重点关注的，这里可以做其他操作，如通知邮件，单独写到某个文件等等。
        }
        return result;
    }
}
