package com.spring.hibernate.dao;

import com.spring.hibernate.entity.Customer;

import java.util.List;

/**
 * Created by Dmitrii on 05.02.2019.
 */
public interface CustomerDAO {

    List<Customer> getCustomers();
}