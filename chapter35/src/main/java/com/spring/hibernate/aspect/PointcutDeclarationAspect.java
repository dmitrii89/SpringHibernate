package com.spring.hibernate.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Dmitrii on 08.02.2019.
 */
@Aspect
@Component
public class PointcutDeclarationAspect {

    @Pointcut("execution(* com.spring.hibernate.dao.*.cancelMembership(..))")
    private void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void logCancel(){
        System.out.println("\n======>>> Cancelling account's membership");
    }

}
