package com.spring.hibernate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Created by Dmitrii on 07.02.2019.
 */
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.spring.hibernate.dao.*.*(..))")
    public void log(JoinPoint joinPoint){
        System.out.println("======>>> Executing @Before advice on addAccount()");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method signature: " + signature);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("Arg: " + arg);
        }


    }
}
