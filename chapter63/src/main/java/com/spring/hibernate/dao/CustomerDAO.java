package com.spring.hibernate.dao;

import com.spring.hibernate.entity.Customer;

import java.util.List;

/**
 * Created by Dmitrii on 05.02.2019.
 */
public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int customerId);

    void deleteCustomer(int customerId);

    List<Customer> searchCustomers(String theSearchName);
}
