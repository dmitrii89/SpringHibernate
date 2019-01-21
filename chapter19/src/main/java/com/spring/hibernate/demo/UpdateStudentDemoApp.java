package com.spring.hibernate.demo;


import com.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dmitrii on 21.01.2019.
 */
public class UpdateStudentDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating a student");
            Student student = new Student("Andrew", "Petrov", "andrew.petrov@mail.ru");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();

            // get and update student
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student savedStudent = session.get(Student.class, student.getId());
            System.out.println("Got saved student: " + savedStudent);

            savedStudent.setFirstName("Scooby");
            session.getTransaction().commit();

            // get updated student
            session = factory.getCurrentSession();
            session.beginTransaction();
            savedStudent = session.get(Student.class, student.getId());
            System.out.println("Got saved student: " + savedStudent);
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }

//        Creating a student
//        Hibernate: insert into student (email, first_name, last_name) values (?, ?, ?)
//        Hibernate: select student0_.id as id1_0_0_, student0_.email as email2_0_0_, student0_.first_name as first_na3_0_0_, student0_.last_name as last_nam4_0_0_ from student student0_ where student0_.id=?
//        Got saved student: Student{id=7, firstName='Andrew', lastName='Petrov', email='andrew.petrov@mail.ru'}
//        Hibernate: update student set email=?, first_name=?, last_name=? where id=?
//        Hibernate: select student0_.id as id1_0_0_, student0_.email as email2_0_0_, student0_.first_name as first_na3_0_0_, student0_.last_name as last_nam4_0_0_ from student student0_ where student0_.id=?
//        Got saved student: Student{id=7, firstName='Scooby', lastName='Petrov', email='andrew.petrov@mail.ru'}
//        Done!
    }
}
