package com.example.t2009m1helloworld.controller;

import com.example.t2009m1helloworld.entity.Product;
import com.example.t2009m1helloworld.model.MySqlProduct;
import com.example.t2009m1helloworld.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListProductServlet  extends HttpServlet {
    private ProductModel productModel;
    public void init() throws ServletException {
        productModel = new MySqlProduct();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product>  productList = productModel.findAll();
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/products/list.jsp").forward(req, resp);
    }
}
