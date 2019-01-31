package com.spring.hibernate.app;

import com.spring.hibernate.entity.Course;
import com.spring.hibernate.entity.Instructor;
import com.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dmitrii on 19.01.2019.
 */
public class OneToManyApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 7);
            System.out.println("========== Instructor ================");
            System.out.println(instructor);
            System.out.println("========== Instructor's courses ================");
            System.out.println(instructor.getCourses());

            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
