package com.spring.hibernate.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Dmitrii on 07.02.2019.
 */
@Aspect
@Component
public class LoggingAspect {

    //@Before("execution(public void addAccount())")
    //@Before("execution(public void com.spring.hibernate.dao.AccountDAO.addAccount())")
    //@Before("execution(void add*())")
    //@Before("execution(* add*())")
    //@Before("execution(* add*(com.spring.hibernate.model.Account))")
    //@Before("execution(* add*(com.spring.hibernate.model.Account, java.lang.Boolean))")
    //@Before("execution(* add*(com.spring.hibernate.model.Account, ..))")
    //@Before("execution(* add*(..))")
    @Before("execution(* com.spring.hibernate.dao.*.*(..))")
    public void log(){
        System.out.println("\n======>>> Executing @Before advice on addAccount()");
    }
}
