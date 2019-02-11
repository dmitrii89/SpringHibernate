package com.spring.hibernate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    //setup pointcut declarations

    @Pointcut("execution(* com.spring.hibernate.controllers.*.*(..))")
    public void forControllerPackage() {}

    @Pointcut("execution(* com.spring.hibernate.service.*.*(..))")
    public void forServicePackage() {}

    @Pointcut("execution(* com.spring.hibernate.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("====>> in @Before: calling method: " + methodName);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logger.info("====>> argument: " + arg);
        }

    }

    // add @AfterReturning advice

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("====>> in @AfterReturning: from method: " + methodName);

        logger.info("====>> result: " + result);
    }
}
