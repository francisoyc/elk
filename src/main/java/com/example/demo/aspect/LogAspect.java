package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 日志切面类，拦截所有controller，打印输入和输出内容
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    private void controllerMethodAspect() {
    }

    @Before("controllerMethodAspect()")
    public void doBefore(JoinPoint joinPoint) {
        // 请求参数可以打印更详细的内容，这里只是测试代码
        log.info("{} 请求开始，请求参数：{}", getTarget(joinPoint), joinPoint.getArgs());
    }

    @AfterReturning(returning="obj", pointcut = "controllerMethodAspect()")
    public void doAfter(JoinPoint joinPoint, Object obj) {
        log.info("{} 请求结束，返回内容={}", getTarget(joinPoint), obj);
    }

    @AfterThrowing(throwing = "throwable", pointcut = "controllerMethodAspect()")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable throwable) {
        log.error("{} 请求异常，原因：", getTarget(joinPoint), throwable);
    }

    private String getTarget(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return joinPoint.getTarget().getClass().getName() + "." + signature.getName();
    }
}
