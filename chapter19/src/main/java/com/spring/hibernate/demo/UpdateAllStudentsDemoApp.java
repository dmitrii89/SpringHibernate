package com.spring.hibernate.demo;


import com.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Dmitrii on 21.01.2019.
 */
public class UpdateAllStudentsDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            System.out.println("Updating all students");
            session.createQuery("update Student set email='yaya@yandex.ru'")
                    .executeUpdate();
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("ALL students =======================");
            List<Student> students = session.createQuery("from Student").getResultList();
            printStudent(students);

        } finally {
            factory.close();
        }
    }

    private static void printStudent(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

//    Updating all students
//    Hibernate: update student set email='yaya@yandex.ru'
//    ALL students =======================
//    Hibernate: select student0_.id as id1_0_, student0_.email as email2_0_, student0_.first_name as first_na3_0_, student0_.last_name as last_nam4_0_ from student student0_
//    Student{id=1, firstName='Mike', lastName='Fedorov', email='yaya@yandex.ru'}
//    Student{id=2, firstName='Donald', lastName='Duck', email='yaya@yandex.ru'}
//    Student{id=3, firstName='Вася', lastName='Пупкин', email='yaya@yandex.ru'}
//    Student{id=4, firstName='Павел', lastName='Морозов', email='yaya@yandex.ru'}
}
