package com.spring.hibernate.dao;

import org.springframework.stereotype.Component;

/**
 * Created by Dmitrii on 08.02.2019.
 */
@Component
public class MembershipDAO {

    public boolean addMemberAccount() {
        System.out.println(getClass() + ": Doing stuff : adding a membership account");
        return true;
    }
}
