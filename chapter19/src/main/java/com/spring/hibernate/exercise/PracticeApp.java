package com.spring.hibernate.exercise;

import com.spring.hibernate.entity.Employee;
import com.spring.hibernate.utils.DateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.List;

public class PracticeApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating an employee");
            Employee employee1 = new Employee("Dima", "Cherry", "NC", DateUtils.parseDate("16/09/2016"));
            Employee employee2 = new Employee("Anna", "Cherry", "FF", DateUtils.parseDate("21/01/2019"));
            System.out.println();

            System.out.println("Saving employee object");
            session.beginTransaction();
            session.save(employee1);
            session.save(employee2);
            session.getTransaction().commit();

            System.out.println("Saved employee: " + employee1);
            System.out.println();

            System.out.println("Getting employee by id = " + employee1.getId());
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee savedEmployee = session.get(Employee.class, employee1.getId());
            session.getTransaction().commit();

            System.out.println("Got saved employee: " + savedEmployee);
            System.out.println();

            System.out.println("Getting employee by company name = FF");
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Employee> resultList = session.createQuery("from Employee e where e.company='FF'").getResultList();
            session.getTransaction().commit();

            System.out.println("Printing found employees:");
            for (Employee employee : resultList) {
                System.out.println(employee);
            }
            System.out.println();

            System.out.println("Deleting employee with id = " + employee1.getId());
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.delete(employee1);
            session.getTransaction().commit();
            System.out.println();

            System.out.println("Getting all employees: ");
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Employee> list = session.createQuery("from Employee").getResultList();
            session.getTransaction().commit();
            for (Employee employee : list) {
                System.out.println(employee);
            }
            System.out.println();


        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }


//    Creating an employee
//
//    Saving employee object
//    Hibernate: insert into employee (company, date, first_name, last_name) values (?, ?, ?, ?)
//    Hibernate: insert into employee (company, date, first_name, last_name) values (?, ?, ?, ?)
//    Saved employee: Employee{id=1, firstName='Dima', lastName='Cherry', company='NC', date=16/09/2016}
//
//    Getting employee by id = 1
//    Hibernate: select employee0_.id as id1_0_0_, employee0_.company as company2_0_0_, employee0_.date as date3_0_0_, employee0_.first_name as first_na4_0_0_, employee0_.last_name as last_nam5_0_0_ from employee employee0_ where employee0_.id=?
//    Got saved employee: Employee{id=1, firstName='Dima', lastName='Cherry', company='NC', date=16/09/2016}
//
//    Getting employee by company name = FF
//    Hibernate: select employee0_.id as id1_0_, employee0_.company as company2_0_, employee0_.date as date3_0_, employee0_.first_name as first_na4_0_, employee0_.last_name as last_nam5_0_ from employee employee0_ where employee0_.company='FF'
//    Printing found employees:
//    Employee{id=2, firstName='Anna', lastName='Cherry', company='FF', date=21/01/2019}
//
//    Deleting employee with id = 1
//    Hibernate: delete from employee where id=?
//
//    Getting all employees:
//    Hibernate: select employee0_.id as id1_0_, employee0_.company as company2_0_, employee0_.date as date3_0_, employee0_.first_name as first_na4_0_, employee0_.last_name as last_nam5_0_ from employee employee0_
//    Employee{id=2, firstName='Anna', lastName='Cherry', company='FF', date=21/01/2019}

}
