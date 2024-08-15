package com.neueda.payments.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ServiceLoggingAspect {


    Logger logger = LoggerFactory.getLogger(ServiceLoggingAspect.class);

    @Pointcut("execution(* com.neueda.payments.service.*.* (..))")
    public void logServiceMethods() {

    }

    @Before("logServiceMethods()")
    public void beforeServiceMethodLog(JoinPoint joinPoint) {
        logger.info("Starting - {} method with args - {}", joinPoint.getSignature(), Arrays.toString(joinPoint.getArgs()));
    }

    @After("logServiceMethods()")
    public void afterServiceMethodLog() {
        logger.info("After Service");
    }

    private String getArgsAsString(Object[] args) {
        try {
            String[] stringArgs = Arrays.copyOf(args, args.length, String[].class);
            return String.join(",", stringArgs);
        }
        catch (Exception e) {
            return "[unknown]";
        }
    }
}
