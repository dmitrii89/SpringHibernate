package com.spring.hibernate.app;

import com.spring.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dmitrii on 19.01.2019.
 */
public class ManyToManyApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course course = new Course("Learn Hibernate in 24 hours");
            session.save(course);

            Student student1 = new Student("John", "Doe", "john.dow@mail.com");
            Student student2 = new Student("Mary", "Public", "mary.public@mail.com");

            course.addStudent(student1);
            course.addStudent(student2);

            session.save(student1);
            session.save(student2);

            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

    //Hibernate: insert into course (instructor_id, title) values (?, ?)
    //Hibernate: insert into student (email, first_name, last_name) values (?, ?, ?)
    //Hibernate: insert into student (email, first_name, last_name) values (?, ?, ?)
    //Hibernate: insert into course_student (course_id, student_id) values (?, ?)
    //Hibernate: insert into course_student (course_id, student_id) values (?, ?)
    //фев 04, 2019 4:59:42 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl stop
    //INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false&serverTimezone=Europe/Moscow]
    //Done!
}
