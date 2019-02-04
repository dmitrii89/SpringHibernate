package com.spring.hibernate.app;

import com.spring.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dmitrii on 19.01.2019.
 */
public class DeleteStudentApp {
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

            Student student = session.get(Student.class, 1);
            System.out.println(student);

            session.delete(student);

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
//    Hibernate: delete from course_student where student_id=?
//    Hibernate: delete from student where id=?
//    Done!

}
