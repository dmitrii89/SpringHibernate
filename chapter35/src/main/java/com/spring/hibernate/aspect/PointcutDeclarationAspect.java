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

    @Pointcut("execution(* com.spring.hibernate.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.spring.hibernate.dao.*.get*(..))")
    private void getter(){}

    @Pointcut("execution(* com.spring.hibernate.dao.*.set*(..))")
    private void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetSet(){}

    @Before("forDaoPackage()")
    public void logCancel(){
        System.out.println("\n======>>> Cancelling account's membership");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("======>>> Performing API analytics");
    }

    @Before("forDaoPackageNoGetSet()")
    public void noGetterSetter() {
        System.out.println("======>>> Aspect for non getter or setter method");
    }

}
