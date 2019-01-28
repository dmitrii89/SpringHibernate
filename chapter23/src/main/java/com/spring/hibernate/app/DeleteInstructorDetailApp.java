package com.spring.hibernate.app;

import com.spring.hibernate.entity.InstructorBiderectional;
import com.spring.hibernate.entity.InstructorDetailBidirectional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dmitrii on 19.01.2019.
 */
public class DeleteInstructorDetailApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorBiderectional.class)
                .addAnnotatedClass(InstructorDetailBidirectional.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            InstructorDetailBidirectional detail = session.get(InstructorDetailBidirectional.class, 2);
            System.out.println("Instructor detail: " + detail);
            System.out.println("Instructor : " + detail.getInstructor());

            System.out.println("Deleting instructor details!!!");
            session.delete(detail);

            session.getTransaction().commit();
            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

//    Hibernate: select instructor0_.id as id1_1_0_, instructor0_.hobby as hobby2_1_0_, instructor0_.youtube_channel as youtube_3_1_0_, instructor1_.id as id1_0_1_, instructor1_.email as email2_0_1_, instructor1_.first_name as first_na3_0_1_, instructor1_.instructor_detail_id as instruct5_0_1_, instructor1_.last_name as last_nam4_0_1_ from instructor_detail instructor0_ left outer join instructor instructor1_ on instructor0_.id=instructor1_.instructor_detail_id where instructor0_.id=?
//    Instructor detail: InstructorDetailBidirectional{id=2, youtubeChannel='youtube.com/dmch', hobby='Coding, snowboarding, swimming}
//    Instructor : InstructorBiderectional{id=2, firstName='Dima', lastName='Cherry', email='dmch@mail.ru', instructorDetail=InstructorDetailBidirectional{id=2, youtubeChannel='youtube.com/dmch', hobby='Coding, snowboarding, swimming}}
//    Deleting instructor details!!!
//    Hibernate: delete from instructor where id=?
//    Hibernate: delete from instructor_detail where id=?
//    Done!
}
