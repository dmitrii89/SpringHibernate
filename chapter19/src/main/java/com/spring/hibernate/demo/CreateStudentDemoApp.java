package com.spring.hibernate.demo;


import com.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dmitrii on 19.01.2019.
 */
public class CreateStudentDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating a student");
            Student student = new Student("Mike", "Fedorov", "mike.fedorov@mail.ru");

            //start a transaction
            System.out.println("Starting transaction");
            session.beginTransaction();

            // save the student object
            System.out.println("Saving a student");
            session.save(student);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }

//        Creating students
//        Starting transaction
//        Saving students
//        Hibernate: insert into student (email, first_name, last_name) values (?, ?, ?)
//        Hibernate: insert into student (email, first_name, last_name) values (?, ?, ?)
//        Hibernate: insert into student (email, first_name, last_name) values (?, ?, ?)
//        Done!
    }
}
