package com.spring.hibernate.aspect;

import com.spring.hibernate.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
}
