package com.spring.hibernate.dao;

import com.spring.hibernate.model.Account;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Dmitrii on 07.02.2019.
 */
@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public List<Account> findAccounts() {
        Account dima = new Account("Dima", "platinum");
        Account anya = new Account("Anya", "golden");
        Account mark = new Account("Mark", "silver");
        return Arrays.asList(dima, anya, mark);
    }

    public void addAccount(){
        System.out.println(getClass() + ": Doing my db work : adding empty account");
    }

    public void addAccount(Account account){
        System.out.println(getClass() + ": Doing my db work : adding new account");
    }

    public void addAccount(Account account, Boolean vip){
        System.out.println(getClass() + ": Doing my db work : adding new vip=" + vip + " account");
    }

    public String getName() {
        System.out.println(getClass() + ": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
