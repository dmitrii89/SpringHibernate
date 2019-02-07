package com.spring.hibernate.dao;

import org.springframework.stereotype.Component;

/**
 * Created by Dmitrii on 07.02.2019.
 */
@Component
public class AccountDAO {

    public void addAccount(){
        System.out.println(getClass() + ": Doing my db work : adding account");
    }

}
