package com.spring.hibernate.demo;


import com.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dmitrii on 21.01.2019.
 */
public class DeleteStudentDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // create student objects
            System.out.println("Creating students");
            Student student1 = new Student("Sam", "Petrov", "andrew1.petrov@mail.ru");
            Student student2 = new Student("Bob", "Petrov", "andrew2.petrov@mail.ru");

            session.beginTransaction();
            session.save(student1);
            session.save(student2);
            session.getTransaction().commit();

            // get students
            System.out.println("Getting student objects");
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student savedStudent1 = session.get(Student.class, student1.getId());
            Student savedStudent2 = session.get(Student.class, student2.getId());
            System.out.println("Got saved student: " + savedStudent1);
            System.out.println("Got saved student: " + savedStudent2);
            session.getTransaction().commit();

            System.out.println("Deleting student objects");
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.delete(savedStudent1);
            session.createQuery("delete from Student s where id=" + savedStudent2.getId()).executeUpdate();
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }

//    Creating students
//    Hibernate: insert into student (email, first_name, last_name) values (?, ?, ?)
//    Hibernate: insert into student (email, first_name, last_name) values (?, ?, ?)
//    Getting student objects
//    Hibernate: select student0_.id as id1_0_0_, student0_.email as email2_0_0_, student0_.first_name as first_na3_0_0_, student0_.last_name as last_nam4_0_0_ from student student0_ where student0_.id=?
//    Hibernate: select student0_.id as id1_0_0_, student0_.email as email2_0_0_, student0_.first_name as first_na3_0_0_, student0_.last_name as last_nam4_0_0_ from student student0_ where student0_.id=?
//    Got saved student: Student{id=10, firstName='Sam', lastName='Petrov', email='andrew1.petrov@mail.ru'}
//    Got saved student: Student{id=11, firstName='Bob', lastName='Petrov', email='andrew2.petrov@mail.ru'}
//    Deleting student objects
//    Hibernate: delete from student where id=?
//    Hibernate: delete from student where id=11
//    Done!
}
