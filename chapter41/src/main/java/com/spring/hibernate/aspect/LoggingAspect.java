package com.spring.hibernate.aspect;

import com.spring.hibernate.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Dmitrii on 07.02.2019.
 */
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.spring.hibernate.dao.*.*(..))")
    public void log(JoinPoint joinPoint){
        System.out.println("======>>> Executing @Before advice");
    }

    @AfterReturning(
            pointcut = "execution(* findAccounts(..))",
            returning = "result"
    )
    public void afterReturningAdvice(JoinPoint joinPoint,
                                     List<Account> result) {
        String method = joinPoint.getSignature().toShortString();

        System.out.println("======>>> Executing @AfterReturning on method: " + method);
        System.out.println("======>>> result is: " + result);

        if(result != null && !result.isEmpty()) {
            result.forEach(r ->
                    r.setName(r.getName() + " Ch.")
            );
        }
    }

    @AfterThrowing(
            pointcut = "execution(* findAccountsException(..))",
            throwing = "exception"
    )
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("======>>> Executing @AfterThrowing on method: " + method);

        System.out.println("======>>> AfterThrowing caught the exception: " + exception);
    }

    @After("execution(* findAccounts*(..))")
    public void afterFinally(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("======>>> Executing @After (finally) on method: " + method);
    }

    @Around("execution(* getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("======>>> Executing @Around on method: " + method);

        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        System.out.println("Duration: " + (end - begin)/1000.0 + " seconds");

         return result;
    }
}
