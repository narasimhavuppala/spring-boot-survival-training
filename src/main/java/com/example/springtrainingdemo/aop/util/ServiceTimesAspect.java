package com.example.springtrainingdemo.aop.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Aspect
@Component
public class ServiceTimesAspect {

    @Around("execution (* com.example.springtrainingdemo.service.*.*(..))")
    public Object handleAllServices(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant start = Instant.now();
        Object op = joinPoint.proceed();
        Instant end = Instant.now();
        Duration d = Duration.between(start, end);
        log.info("time take is "+ d.getSeconds() + " seconds");
        return op;
    }

    @Around("@annotation (com.example.springtrainingdemo.aop.util.TrackTimeTaken)")
    public Object handleAllServicesTimeTaken(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant start = Instant.now();
        Object op = joinPoint.proceed();
        log.info("time taken in annotation is "+ Duration.between(start, Instant.now()) + " seconds");
        return op;
    }
}
