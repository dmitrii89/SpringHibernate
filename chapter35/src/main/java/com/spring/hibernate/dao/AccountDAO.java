package com.spring.hibernate.dao;

import com.spring.hibernate.model.Account;
import org.springframework.stereotype.Component;

/**
 * Created by Dmitrii on 07.02.2019.
 */
@Component
public class AccountDAO {

    public void addAccount(){
        System.out.println(getClass() + ": Doing my db work : adding empty account");
    }

    public void addAccount(Account account){
        System.out.println(getClass() + ": Doing my db work : adding new account");
    }

    public void addAccount(Account account, Boolean vip){
        System.out.println(getClass() + ": Doing my db work : adding new vip=" + vip + " account");
    }

}
