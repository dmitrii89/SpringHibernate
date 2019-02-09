package com.spring.hibernate.app;

import com.spring.hibernate.DemoConfig;
import com.spring.hibernate.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Dmitrii on 07.02.2019.
 */
public class JoinPointAspect {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        accountDAO.addAccount("Dima", true);

        context.close();
    }
    //Method signature: void com.spring.hibernate.dao.AccountDAO.addAccount(String,Boolean)
    //Arg: Dima
    //Arg: true
    //class com.spring.hibernate.dao.AccountDAO: Doing my db work : adding empty account

}
