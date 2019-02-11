package com.spring.hibernate.testDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
        String user = "springstudent";
        String password = "springstudent";

        System.out.println("Connecting to database");

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connected successfully!");

            PrintWriter writer = resp.getWriter();
            writer.println("Success");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
