package com.spring.hibernate.app;

import com.spring.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dmitrii on 19.01.2019.
 */
public class DeleteCourseApp {
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

            Course course = session.get(Course.class, 12);
            System.out.println(course);

            session.delete(course);

            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

//    Hibernate: select course0_.id as id1_0_0_, course0_.instructor_id as instruct3_0_0_, course0_.title as title2_0_0_,
//    instructor1_.id as id1_2_1_, instructor1_.email as email2_2_1_, instructor1_.first_name as first_na3_2_1_,
//    instructor1_.instructor_detail_id as instruct5_2_1_, instructor1_.last_name as last_nam4_2_1_, instructor2_.id as id1_3_2_,
//    instructor2_.hobby as hobby2_3_2_, instructor2_.youtube_channel as youtube_3_3_2_ from course course0_ left
//    outer join instructor instructor1_ on course0_.instructor_id=instructor1_.id left outer join instructor_detail instructor2_
//    on instructor1_.instructor_detail_id=instructor2_.id where course0_.id=?
//    Course [id=12, title=Learn Hibernate in 24 hours]
//    Hibernate: select reviews0_.course_id as course_i3_4_0_, reviews0_.id as id1_4_0_, reviews0_.id as id1_4_1_, reviews0_.comment as comment2_4_1_ from review reviews0_ where reviews0_.course_id=?
//    Hibernate: delete from course_student where course_id=?
//    Hibernate: delete from course where id=?
//    фев 04, 2019 7:36:26 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl stop
//    INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false&serverTimezone=Europe/Moscow]
//    Done!

}
