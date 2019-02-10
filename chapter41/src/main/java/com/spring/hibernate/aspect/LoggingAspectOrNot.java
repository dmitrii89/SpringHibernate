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
public class LoggingAspectOrNot {

    Logger logger = Logger.getLogger(LoggingAspectOrNot.class.getName());

    @Around("execution(* getFortuneOrNot(..))")
    public Object aroundGetFortuneLogger(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().toShortString();
        logger.info("======>>> Executing @Around on method: " + method);

        long begin = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception e){
            logger.warning("======>>> Alarm!!! Something went wrong!");
            throw e;
        }
        long end = System.currentTimeMillis();

        logger.info("Duration: " + (end - begin)/1000.0 + " seconds");

        return result;
    }
}
