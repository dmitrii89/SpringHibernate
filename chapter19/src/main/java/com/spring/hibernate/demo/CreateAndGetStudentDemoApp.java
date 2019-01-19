package com.spring.hibernate.demo;


import com.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dmitrii on 19.01.2019.
 */
public class CreateAndGetStudentDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating a student");
            Student student = new Student("Donald", "Duck", "donald.duck@mail.ru");
            session.beginTransaction();
            System.out.println("Saving a student: " + student);
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Saved student: " + student);
            System.out.println();

            // get the student object block
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student by id
            Student savedStudent = session.get(Student.class, student.getId());
            System.out.println("Got saved student: " + savedStudent);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }

//        Creating a student
//        Saving a student: Student{id=0, firstName='Donald', lastName='Duck', email='donald.duck@mail.ru'}
//        Hibernate: insert into student (email, first_name, last_name) values (?, ?, ?)
//        Saved student: Student{id=11, firstName='Donald', lastName='Duck', email='donald.duck@mail.ru'}
//
//        Hibernate: select student0_.id as id1_0_0_, student0_.email as email2_0_0_, student0_.first_name as first_na3_0_0_,
//                   student0_.last_name as last_nam4_0_0_ from student student0_ where student0_.id=?
//        Got saved student: Student{id=11, firstName='Donald', lastName='Duck', email='donald.duck@mail.ru'}
//        Done!
    }
}
