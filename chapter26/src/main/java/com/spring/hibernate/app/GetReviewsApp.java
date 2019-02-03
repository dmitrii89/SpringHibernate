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
public class GetReviewsApp {
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

            Course course = session.get(Course.class, 14);
            System.out.println(course);
            System.out.println(course.getReviews());

            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

    //Hibernate: select course0_.id as id1_0_0_, course0_.instructor_id as instruct3_0_0_, course0_.title as title2_0_0_, instructor1_.id as id1_1_1_, instructor1_.email as email2_1_1_, instructor1_.first_name as first_na3_1_1_, instructor1_.instructor_detail_id as instruct5_1_1_, instructor1_.last_name as last_nam4_1_1_, instructor2_.id as id1_2_2_, instructor2_.hobby as hobby2_2_2_, instructor2_.youtube_channel as youtube_3_2_2_ from course course0_ left outer join instructor instructor1_ on course0_.instructor_id=instructor1_.id left outer join instructor_detail instructor2_ on instructor1_.instructor_detail_id=instructor2_.id where course0_.id=?
    //Course [id=14, title=How to learn Hibernate]
    //Hibernate: select reviews0_.course_id as course_i3_3_0_, reviews0_.id as id1_3_0_, reviews0_.id as id1_3_1_, reviews0_.comment as comment2_3_1_ from review reviews0_ where reviews0_.course_id=?
    //[Review{id=4, comment='Very good course'}, Review{id=5, comment='Awesome course'}, Review{id=6, comment='This course is the worsest of ever'}]
    //Done!
}
