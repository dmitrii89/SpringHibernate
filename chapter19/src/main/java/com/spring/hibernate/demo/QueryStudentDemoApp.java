package com.spring.hibernate.demo;


import com.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Dmitrii on 19.01.2019.
 */
public class QueryStudentDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            System.out.println("ALL students =======================");
            List<Student> students = session.createQuery("from Student").getResultList();
            printStudent(students);

            System.out.println("By lastName =======================");
            students = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
            printStudent(students);

            System.out.println("By firstName and lastName =======================");
            students = session.createQuery("from Student s where s.firstName='Вася' OR s.lastName='Duck'").getResultList();
            printStudent(students);

            System.out.println("By email with like =======================");
            students = session.createQuery("from Student s where s.email like '%@mail.ru'").getResultList();
            printStudent(students);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }

    }

    private static void printStudent(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

//    ALL students =======================
//    Hibernate: select student0_.id as id1_0_, student0_.email as email2_0_, student0_.first_name as first_na3_0_, student0_.last_name as last_nam4_0_ from student student0_
//    Student{id=1, firstName='Mike', lastName='Fedorov', email='mike.fedorov@mail.ru'}
//    Student{id=2, firstName='Donald', lastName='Duck', email='donald.duck@mail.ru'}
//    Student{id=3, firstName='Вася', lastName='Пупкин', email='vasya.pupkin@mail.ru'}
//    Student{id=4, firstName='Павел', lastName='Морозов', email='pavel.morozov@mail.ru'}
//    Student{id=5, firstName='Саша', lastName='Сашин', email='sasha.sashin@mail.ru'}
//    By lastName =======================
//    Hibernate: select student0_.id as id1_0_, student0_.email as email2_0_, student0_.first_name as first_na3_0_, student0_.last_name as last_nam4_0_ from student student0_ where student0_.last_name='Duck'
//    Student{id=2, firstName='Donald', lastName='Duck', email='donald.duck@mail.ru'}
//    By firstName and lastName =======================
//    Hibernate: select student0_.id as id1_0_, student0_.email as email2_0_, student0_.first_name as first_na3_0_, student0_.last_name as last_nam4_0_ from student student0_ where student0_.first_name='Вася' or student0_.last_name='Duck'
//    Student{id=2, firstName='Donald', lastName='Duck', email='donald.duck@mail.ru'}
//    Student{id=3, firstName='Вася', lastName='Пупкин', email='vasya.pupkin@mail.ru'}
//    By email with like =======================
//    Hibernate: select student0_.id as id1_0_, student0_.email as email2_0_, student0_.first_name as first_na3_0_, student0_.last_name as last_nam4_0_ from student student0_ where student0_.email like '%@mail.ru'
//    Student{id=1, firstName='Mike', lastName='Fedorov', email='mike.fedorov@mail.ru'}
//    Student{id=2, firstName='Donald', lastName='Duck', email='donald.duck@mail.ru'}
//    Student{id=3, firstName='Вася', lastName='Пупкин', email='vasya.pupkin@mail.ru'}
//    Student{id=4, firstName='Павел', lastName='Морозов', email='pavel.morozov@mail.ru'}
//    Student{id=5, firstName='Саша', lastName='Сашин', email='sasha.sashin@mail.ru'}
//    Done!
}
