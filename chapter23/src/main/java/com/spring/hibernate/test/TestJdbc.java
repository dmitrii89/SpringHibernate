package com.spring.hibernate.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=Europe/Moscow&useUnicode=true&characterEncoding=utf8";
        String user = "hbstudent";
        String password = "hbstudent";
        try {
            System.out.println("Connecting to database");
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
