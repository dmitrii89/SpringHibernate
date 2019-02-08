package com.spring.hibernate.dao;

import com.spring.hibernate.model.Account;
import org.springframework.stereotype.Component;

/**
 * Created by Dmitrii on 08.02.2019.
 */
@Component
public class MembershipDAO {

    public boolean addMemberAccount() {
        System.out.println(getClass() + ": adding a membership account");
        return true;
    }

    public void cancelMembership(Account account) {
        System.out.println(getClass() + " cancelling membership of the account");
    }

    public void getMembership(Account account) {
        System.out.println(getClass() + " getting membership of the account");
    }

    public void setMembership(Account account) {
        System.out.println(getClass() + " setting membership of the account");
    }
}
