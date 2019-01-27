package com.spring.hibernate.app;

import com.spring.hibernate.entity.Instructor;
import com.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dmitrii on 19.01.2019.
 */
public class OneToOneDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Instructor instructor = new Instructor("Dima", "Cherry", "dmch@mail.ru");
        InstructorDetail detail = new InstructorDetail("youtube.com/dmch", "Coding, snowboarding, swimming");
        instructor.setInstructorDetail(detail);

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            // this will also save detail class, because of CascadeType=All
            session.save(instructor);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }
}
