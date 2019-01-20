package com.spring.hibernate.demo;


import com.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dmitrii on 19.01.2019.
 */
public class PrimaryKeyDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating students");
            Student student1 = new Student("Вася", "Пупкин", "vasya.pupkin@mail.ru");
            Student student2 = new Student("Павел", "Морозов", "pavel.morozov@mail.ru");
            Student student3 = new Student("Саша", "Сашин", "sasha.sashin@mail.ru");

            //start a transaction
            System.out.println("Starting transaction");
            session.beginTransaction();

            // save the student object
            System.out.println("Saving students");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }

//        Creating a students
//        Starting transaction
//        Saving a students
//        Hibernate: insert into student (email, first_name, last_name, id) values (?, ?, ?, ?)
//        Hibernate: insert into student (email, first_name, last_name, id) values (?, ?, ?, ?)
//        Hibernate: insert into student (email, first_name, last_name, id) values (?, ?, ?, ?)
//        Done!
    }
}
