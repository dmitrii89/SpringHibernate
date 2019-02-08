package com.spring.hibernate.app;

import com.spring.hibernate.DemoConfig;
import com.spring.hibernate.dao.AccountDAO;
import com.spring.hibernate.dao.MembershipDAO;
import com.spring.hibernate.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Dmitrii on 07.02.2019.
 */
public class BeforeAopApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        accountDAO.addAccount();
        accountDAO.addAccount(new Account());
        accountDAO.addAccount(new Account(), true);

        accountDAO.setName("Account dao");
        accountDAO.setServiceCode("golden");
        accountDAO.getName();
        accountDAO.getServiceCode();

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addMemberAccount();
        membershipDAO.cancelMembership(new Account());
        membershipDAO.setMembership(new Account());
        membershipDAO.getMembership(new Account());

        context.close();
    }

    //======>>> Executing @Before advice on addAccount()
    //
    //======>>> Cancelling account's membership
    //======>>> Aspect for non getter or setter method
    //======>>> Performing API analytics
    //class com.spring.hibernate.dao.AccountDAO: Doing my db work : adding empty account
    //
    //======>>> Executing @Before advice on addAccount()
    //
    //======>>> Cancelling account's membership
    //======>>> Aspect for non getter or setter method
    //======>>> Performing API analytics
    //class com.spring.hibernate.dao.AccountDAO: Doing my db work : adding new account
    //
    //======>>> Executing @Before advice on addAccount()
    //
    //======>>> Cancelling account's membership
    //======>>> Aspect for non getter or setter method
    //======>>> Performing API analytics
    //class com.spring.hibernate.dao.AccountDAO: Doing my db work : adding new vip=true account
    //
    //======>>> Executing @Before advice on addAccount()
    //
    //======>>> Cancelling account's membership
    //======>>> Performing API analytics
    //class com.spring.hibernate.dao.AccountDAO: setName()
    //
    //======>>> Executing @Before advice on addAccount()
    //
    //======>>> Cancelling account's membership
    //======>>> Performing API analytics
    //class com.spring.hibernate.dao.AccountDAO: setServiceCode()
    //
    //======>>> Executing @Before advice on addAccount()
    //
    //======>>> Cancelling account's membership
    //======>>> Performing API analytics
    //class com.spring.hibernate.dao.AccountDAO: getName()
    //
    //======>>> Executing @Before advice on addAccount()
    //
    //======>>> Cancelling account's membership
    //======>>> Performing API analytics
    //class com.spring.hibernate.dao.AccountDAO: getServiceCode()
    //
    //======>>> Executing @Before advice on addAccount()
    //
    //======>>> Cancelling account's membership
    //======>>> Aspect for non getter or setter method
    //======>>> Performing API analytics
    //class com.spring.hibernate.dao.MembershipDAO: adding a membership account
    //
    //======>>> Executing @Before advice on addAccount()
    //
    //======>>> Cancelling account's membership
    //======>>> Aspect for non getter or setter method
    //======>>> Performing API analytics
    //class com.spring.hibernate.dao.MembershipDAO cancelling membership of the account
    //
    //======>>> Executing @Before advice on addAccount()
    //
    //======>>> Cancelling account's membership
    //======>>> Performing API analytics
    //class com.spring.hibernate.dao.MembershipDAO setting membership of the account
    //
    //======>>> Executing @Before advice on addAccount()
    //
    //======>>> Cancelling account's membership
    //======>>> Performing API analytics
    //class com.spring.hibernate.dao.MembershipDAO getting membership of the account
}
