package com.spring.hibernate.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Dmitrii on 08.02.2019.
 */
@Aspect
@Component
@Order(1)
public class LogAnalyticsAspect {

    @Before("com.spring.hibernate.aspect.BaseAopExpressions.forDaoPackageNoGetSet()")
    public void apiAnalytics() {
        System.out.println("======>>> Log analytics method");
    }
}
