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
            Instructor instructor = new Instructor("Dima", "Cherry", "dm.ch@mail.ru");
            InstructorDetail detail = new InstructorDetail("youtube.com", "Coding");
            instructor.setInstructorDetail(detail);

            Course algebra = new Course("Algebra");
            Course programming = new Course("Programming");
            instructor.add(algebra);
            instructor.add(programming);

            System.out.println("Instructor : " + instructor);

            session.beginTransaction();
            session.save(instructor);
            //nex 2 lines not necessary in case of cascade = CascadeType.ALL
            session.save(algebra);
            session.save(programming);
            session.getTransaction().commit();

            System.out.println("Instructor : " + instructor);

            session = factory.getCurrentSession();
            session.beginTransaction();
            Instructor savedInstructor = session.get(Instructor.class, instructor.getId());
            System.out.println("========== Saved instructor ================");
            System.out.println(savedInstructor);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            session.delete(savedInstructor.getCourses().get(0));
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

//        Instructor : Instructor{id=0, firstName='Dima', lastName='Cherry', email='dm.ch@mail.ru', instructorDetail=InstructorDetail{id=0, youtubeChannel='youtube.com', hobby='Coding}, courses=[Course{id=0, title='Algebra'}, Course{id=0, title='Programming'}]}
//        Hibernate: insert into instructor_detail (hobby, youtube_channel) values (?, ?)
//        Hibernate: insert into instructor (email, first_name, instructor_detail_id, last_name) values (?, ?, ?, ?)
//        Hibernate: insert into course (instructor_id, title) values (?, ?)
//        Hibernate: insert into course (instructor_id, title) values (?, ?)
//        Instructor : Instructor{id=9, firstName='Dima', lastName='Cherry', email='dm.ch@mail.ru', instructorDetail=InstructorDetail{id=9, youtubeChannel='youtube.com', hobby='Coding}, courses=[Course{id=5, title='Algebra'}, Course{id=6, title='Programming'}]}
//        Hibernate: select instructor0_.id as id1_1_0_, instructor0_.email as email2_1_0_, instructor0_.first_name as first_na3_1_0_, instructor0_.instructor_detail_id as instruct5_1_0_, instructor0_.last_name as last_nam4_1_0_, instructor1_.id as id1_2_1_, instructor1_.hobby as hobby2_2_1_, instructor1_.youtube_channel as youtube_3_2_1_ from instructor instructor0_ left outer join instructor_detail instructor1_ on instructor0_.instructor_detail_id=instructor1_.id where instructor0_.id=?
//        Hibernate: select instructor0_.id as id1_1_1_, instructor0_.email as email2_1_1_, instructor0_.first_name as first_na3_1_1_, instructor0_.instructor_detail_id as instruct5_1_1_, instructor0_.last_name as last_nam4_1_1_, instructor1_.id as id1_2_0_, instructor1_.hobby as hobby2_2_0_, instructor1_.youtube_channel as youtube_3_2_0_ from instructor instructor0_ left outer join instructor_detail instructor1_ on instructor0_.instructor_detail_id=instructor1_.id where instructor0_.instructor_detail_id=?
//        ========== Saved instructor ================
//        Hibernate: select courses0_.instructor_id as instruct3_0_0_, courses0_.id as id1_0_0_, courses0_.id as id1_0_1_, courses0_.instructor_id as instruct3_0_1_, courses0_.title as title2_0_1_ from course courses0_ where courses0_.instructor_id=?
//        Instructor{id=9, firstName='Dima', lastName='Cherry', email='dm.ch@mail.ru', instructorDetail=InstructorDetail{id=9, youtubeChannel='youtube.com', hobby='Coding}, courses=[Course{id=5, title='Algebra'}, Course{id=6, title='Programming'}]}
//        Hibernate: delete from course where id=?
//        Done!
