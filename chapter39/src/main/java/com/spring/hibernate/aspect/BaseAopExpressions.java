package com.spring.hibernate.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Dmitrii on 08.02.2019.
 */
@Aspect
public class BaseAopExpressions {

    @Pointcut("execution(* com.spring.hibernate.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.spring.hibernate.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.spring.hibernate.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetSet(){}

}
