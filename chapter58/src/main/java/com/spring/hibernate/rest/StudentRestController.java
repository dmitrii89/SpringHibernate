package com.spring.hibernate.rest;

import com.spring.hibernate.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Dmitrii on 17.02.2019.
 */
@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        Student dima = new Student("Petya", "Ivanov");
        Student anya = new Student("Vasya", "Petrov");
        Student mark = new Student("Misha", "Sidorov");
        return Arrays.asList(dima, anya, mark);
    }
}
