package com.example.springtrainingdemo.aop.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ServiceTimesAspect {

    @Around("execution (* com.example.springtrainingdemo.service.*.*(..))")
    public Object handleAllServices(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before login");
        Object op = joinPoint.proceed();
        System.out.println("After login");

        return op;
    }
}
