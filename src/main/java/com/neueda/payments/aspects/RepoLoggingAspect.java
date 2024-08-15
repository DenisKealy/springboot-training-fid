package com.neueda.payments.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class RepoLoggingAspect {

    Logger logger = LoggerFactory.getLogger(RepoLoggingAspect.class);

    @Pointcut("execution (* com.neueda.payments.repositories.*.* (..))")
    public void logRepoMethods() {

    }

    @Around("logRepoMethods()")
    public  Object aroundRepoMethods(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("Starting - {} method with args - {}", pjp.getSignature(), Arrays.toString(pjp.getArgs()));
        Object result = pjp.proceed();
        logger.info("Ending - {} method with result - {}", pjp.getSignature(), result.toString());
        return result;
    }
}
