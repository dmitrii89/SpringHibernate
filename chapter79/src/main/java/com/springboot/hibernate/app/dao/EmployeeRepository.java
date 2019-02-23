package com.springboot.hibernate.app.dao;

import com.springboot.hibernate.app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
