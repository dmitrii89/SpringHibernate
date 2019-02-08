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
@Order(3)
public class ApiAnalyticsAspect {

    @Before("com.spring.hibernate.aspect.BaseAopExpressions.forDaoPackageNoGetSet()")
    public void apiAnalytics() {
        System.out.println("======>>> Api analytics method");
    }
}
