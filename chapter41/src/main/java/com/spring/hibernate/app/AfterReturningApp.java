package com.spring.hibernate.app;

import com.spring.hibernate.DemoConfig;
import com.spring.hibernate.dao.AccountDAO;
import com.spring.hibernate.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by Dmitrii on 07.02.2019.
 */
public class AfterReturningApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = accountDAO.findAccounts();

        System.out.println("\nMain program: AfterReturningApp");
        System.out.println("------");
        System.out.println("Modified data: " + accounts);

        context.close();
    }

    //======>>> Executing @Before advice
    //======>>> Executing @AfterReturning on method: AccountDAO.findAccounts()
    //======>>> result is: [Account{name='Dima', level='platinum'}, Account{name='Anya', level='golden'}, Account{name='Mark', level='silver'}]
    //
    //Main program: AfterReturningApp
    //------
    //Modified data: [Account{name='Dima Ch.', level='platinum'}, Account{name='Anya Ch.', level='golden'}, Account{name='Mark Ch.', level='silver'}]

}
