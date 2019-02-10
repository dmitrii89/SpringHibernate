package com.spring.hibernate.app;

import com.spring.hibernate.DemoConfig;
import com.spring.hibernate.dao.AccountDAO;
import com.spring.hibernate.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by Dmitrii on 07.02.2019.
 */
public class AfterFinallyApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = null;
        try {
            accounts = accountDAO.findAccountsException();
        } catch (Exception e){
            System.out.println("Main program caught exception: " + e);
        }
        accounts = accountDAO.findAccounts();

        System.out.println("\nMain program: AfterFinallyApp");
        System.out.println("------");
        System.out.println("Data: " + accounts);

        context.close();
    }

    //======>>> Executing @Before advice
    //======>>> Executing @After (finally) on method: AccountDAO.findAccountsException()
    //======>>> Executing @AfterThrowing on method: AccountDAO.findAccountsException()
    //======>>> AfterThrowing caught the exception: java.lang.RuntimeException: Something went wrong
    //Main program caught exception: java.lang.RuntimeException: Something went wrong
    //======>>> Executing @Before advice
    //======>>> Executing @After (finally) on method: AccountDAO.findAccounts()
    //======>>> Executing @AfterReturning on method: AccountDAO.findAccounts()
    //======>>> result is: [Account{name='Dima', level='platinum'}, Account{name='Anya', level='golden'}, Account{name='Mark', level='silver'}]
    //
    //Main program: AfterFinallyApp
    //------
    //Data: [Account{name='Dima Ch.', level='platinum'}, Account{name='Anya Ch.', level='golden'}, Account{name='Mark Ch.', level='silver'}]

}
