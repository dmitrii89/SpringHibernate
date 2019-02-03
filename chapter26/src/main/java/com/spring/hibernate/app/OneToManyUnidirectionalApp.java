package com.spring.hibernate.app;

import com.spring.hibernate.entity.Course;
import com.spring.hibernate.entity.Instructor;
import com.spring.hibernate.entity.InstructorDetail;
import com.spring.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dmitrii on 19.01.2019.
 */
public class OneToManyUnidirectionalApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course course = new Course("How to learn Hibernate");
            course.addReview(new Review("Very good course"));
            course.addReview(new Review("Awesome course"));
            course.addReview(new Review("This course is the worsest of ever"));

            session.save(course);

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
    //Hibernate: insert into review (comment) values (?)
    //Hibernate: insert into review (comment) values (?)
    //Hibernate: insert into review (comment) values (?)
    //Hibernate: update review set course_id=? where id=?
    //Hibernate: update review set course_id=? where id=?
    //Hibernate: update review set course_id=? where id=?
    //Done!
}
