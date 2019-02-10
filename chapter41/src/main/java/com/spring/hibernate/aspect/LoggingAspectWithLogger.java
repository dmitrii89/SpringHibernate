package com.spring.hibernate.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by Dmitrii on 07.02.2019.
 */
@Aspect
@Component
public class LoggingAspectWithLogger {

    Logger logger = Logger.getLogger(LoggingAspectWithLogger.class.getName());

    @Around("execution(* getFortune(..))")
    public Object aroundGetFortuneLogger(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().toShortString();
        logger.info("======>>> Executing @Around on method: " + method);

        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        logger.info("Duration: " + (end - begin)/1000.0 + " seconds");

         return result;
    }
}
