package com.example.book.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MainAspect {
    private long numberOfRequestToServer = 0;
    @Pointcut("within(com.example.book.controller.*)")
    public void countNumberOfRequestToServer(){

    }

    @Before("countNumberOfRequestToServer()")
    public void beforeCountNumberOfClientsHandler(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
        this.numberOfRequestToServer++;
        System.out.println("The request of requests to server: " + this.numberOfRequestToServer);
    }
}
