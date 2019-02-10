package com.spring.hibernate.app;

import com.spring.hibernate.DemoConfig;
import com.spring.hibernate.dao.AccountDAO;
import com.spring.hibernate.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by Dmitrii on 07.02.2019.
 */
public class AfterThrowingApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = null;
        try {
            accounts = accountDAO.findAccountsException();
        } catch (Exception e){
            System.out.println("Main program caught exception: " + e);
        }

        System.out.println("\nMain program: AfterThrowingApp");
        System.out.println("------");
        System.out.println("Data: " + accounts);

        context.close();
    }

    //======>>> Executing @Before advice
    //======>>> Executing @AfterThrowing on method: AccountDAO.findAccountsException()
    //======>>> AfterThrowing caught the exception: java.lang.RuntimeException: Something went wrong
    //Main program caught exception: java.lang.RuntimeException: Something went wrong
    //
    //Main program: AfterThrowingApp
    //------
    //Data: null

}
