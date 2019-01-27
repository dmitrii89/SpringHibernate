package com.spring.hibernate.app;

import com.spring.hibernate.entity.Instructor;
import com.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dmitrii on 19.01.2019.
 */
public class DeleteOneToOneDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 1);
            if(instructor != null) {
                // this will also delete InstructorDetail object, because of CascadeType=ALL
                session.delete(instructor);
            }

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }

//        INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQLDialect
//        Hibernate: select instructor0_.id as id1_0_0_, instructor0_.email as email2_0_0_, instructor0_.first_name as first_na3_0_0_, instructor0_.instructor_detail_id as instruct5_0_0_, instructor0_.last_name as last_nam4_0_0_, instructor1_.id as id1_1_1_, instructor1_.hobby as hobby2_1_1_, instructor1_.youtube_channel as youtube_3_1_1_ from instructor instructor0_ left outer join instructor_detail instructor1_ on instructor0_.instructor_detail_id=instructor1_.id where instructor0_.id=?
//        Hibernate: delete from instructor where id=?
//        Hibernate: delete from instructor_detail where id=?
//        Done!

    }
}
