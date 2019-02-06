package com.spring.hibernate.service;

import com.spring.hibernate.entity.Customer;

import java.util.List;

/**
 * Created by Dmitrii on 06.02.2019.
 */
public interface CustomerService {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int customerId);
}
