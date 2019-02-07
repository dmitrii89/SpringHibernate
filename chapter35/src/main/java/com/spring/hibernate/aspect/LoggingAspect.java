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

    @Before("execution(public void addAccount())")
    public void logg(){
        System.out.println("\n======>>> Executing @Before advice on addAccount()");
    }
}
