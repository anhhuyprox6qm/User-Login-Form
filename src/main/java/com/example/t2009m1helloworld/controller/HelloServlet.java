package com.example.t2009m1helloworld.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletRequest resp) throws ServletException, IOException{
        resp.getWriter().println("Hello");
    }
    @Override
    protected void doPost(HttpServletRequest req,HttpServletRequest resq) throws ServletException, IOException{
        resq.getWriter().println("post");
    }
}
