package com.spring.hibernate.app;

import com.spring.hibernate.DemoConfig;
import com.spring.hibernate.dao.AccountDAO;
import com.spring.hibernate.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Dmitrii on 07.02.2019.
 */
public class OrderedAspectsApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        accountDAO.addAccount();

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addMemberAccount();

        context.close();
    }

    //======>>> Log analytics method
    //======>>> Secure analytics method
    //======>>> Api analytics method
    //class com.spring.hibernate.dao.AccountDAO: Doing my db work : adding empty account
    //======>>> Log analytics method
    //======>>> Secure analytics method
    //======>>> Api analytics method
    //class com.spring.hibernate.dao.MembershipDAO: adding a membership account

}
