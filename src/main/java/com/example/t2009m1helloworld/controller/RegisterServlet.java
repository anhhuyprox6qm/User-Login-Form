package com.example.t2009m1helloworld.controller;

import com.example.t2009m1helloworld.entity.Account;
import com.example.t2009m1helloworld.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // lấy dữ liệu truyền lên từ query string
//        String currentName=req.getParameter("currentName");
//        // set vào thuộc tính của request.
//        req.setAttribute("currentName","Dao Hong Luyen");
//        List<Student> list=new ArrayList<>();
//        Student student = new Student("A001","Xuan Hung",1);
//        list.add(student);
//        Student student1= new Student("A002","Xuan Luyen",1);
//        list.add(student1);
//        req.setAttribute("list",student);
        req.getRequestDispatcher("/user/register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String username= req.getParameter("username");
        String password= req.getParameter("password");
        String confirmPassword= req.getParameter("comfirmPassword");
        String fullName= req.getParameter("fullName");

        Account account = new Account();
        account.setUsername(username);
        account.setUsername(password);
        account.setUsername(fullName);
        req.setAttribute("account",account);
        req.getRequestDispatcher("/user/register-success.jsp").forward(req,resp);
    }
}
