package com.spring.hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.hibernate.pojos.Student;

import java.io.File;

/**
 * Created by Dmitrii on 16.02.2019.
 */
public class JacksonApp {
    public static void main(String[] args) {

        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            //File file = new File(classLoader.getResource("sample-lite.json").getFile());
            File file = new File(classLoader.getResource("sample-full.json").getFile());

            ObjectMapper mapper = new ObjectMapper();
            Student student = mapper.readValue(file, Student.class);

            System.out.println("First name: " + student.getFirstName());
            System.out.println("Last name: " + student.getLastName());
            System.out.println("Address: " + student.getAddress());
            System.out.println("Languages: " + student.getLanguages());

        } catch (Exception e){
            e.printStackTrace();
        }

        //First name: Mario
        //Last name: Rossi
        //Address: Address{state='Pennsylvania', country='USA', city='Philadelphia', street='100 Main St', zip='19103'}
        //Languages: [Java, C#, Python, Javascript]
    }
}
