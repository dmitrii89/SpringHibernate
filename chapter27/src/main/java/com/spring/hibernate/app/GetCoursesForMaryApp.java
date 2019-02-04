package com.spring.hibernate.app;

import com.spring.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dmitrii on 19.01.2019.
 */
public class GetCoursesForMaryApp {
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

            Student mary = session.get(Student.class, 2);
            System.out.println(mary);
            System.out.println(mary.getCourses());

            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

//    Hibernate: select student0_.id as id1_5_0_, student0_.email as email2_5_0_, student0_.first_name as first_na3_5_0_,
//    student0_.last_name as last_nam4_5_0_ from student student0_ where student0_.id=?
//    com.spring.hibernate.entity.Student@4f936da8
//    Hibernate: select courses0_.student_id as student_1_1_0_, courses0_.course_id as course_i2_1_0_, course1_.id as id1_0_1_,
//    course1_.instructor_id as instruct3_0_1_, course1_.title as title2_0_1_, instructor2_.id as id1_2_2_, instructor2_.email as email2_2_2_,
//    instructor2_.first_name as first_na3_2_2_, instructor2_.instructor_detail_id as instruct5_2_2_, instructor2_.last_name as last_nam4_2_2_,
//    instructor3_.id as id1_3_3_, instructor3_.hobby as hobby2_3_3_, instructor3_.youtube_channel as youtube_3_3_3_
//    from course_student courses0_ inner join course course1_ on courses0_.course_id=course1_.id left outer join instructor instructor2_
//    on course1_.instructor_id=instructor2_.id left outer join instructor_detail instructor3_ on instructor2_.instructor_detail_id=instructor3_.id
//    where courses0_.student_id=?
//    [Course [id=10, title=Learn Hibernate in 24 hours], Course [id=13, title=Rubik's Cube - How to Speed Cube], Course [id=14, title=Atari 2600 - Game development]]
//    Done!
}
