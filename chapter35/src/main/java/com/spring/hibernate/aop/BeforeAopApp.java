package com.spring.hibernate.aop;

import com.spring.hibernate.DemoConfig;
import com.spring.hibernate.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Dmitrii on 07.02.2019.
 */
public class BeforeAopApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        accountDAO.addAccount();

        System.out.println("\nLet's call it again ");
        accountDAO.addAccount();

        context.close();
    }

    //======>>> Executing @Before advice on addAccount()
    //class com.spring.hibernate.dao.AccountDAO: Doing my db work : adding account
    //
    //Let's call it again
    //
    //======>>> Executing @Before advice on addAccount()
    //class com.spring.hibernate.dao.AccountDAO: Doing my db work : adding account
}
