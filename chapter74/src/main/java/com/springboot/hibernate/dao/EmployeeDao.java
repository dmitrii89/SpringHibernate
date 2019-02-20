package com.springboot.hibernate.dao;

import com.springboot.hibernate.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee getById(int id);

    void save(Employee employee);

    void deleteById(int id);

}
