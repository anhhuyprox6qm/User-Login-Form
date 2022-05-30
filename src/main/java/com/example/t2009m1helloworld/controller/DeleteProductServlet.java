package com.example.t2009m1helloworld.controller;

import com.example.t2009m1helloworld.model.ProductModel;
import com.example.t2009m1helloworld.entity.Product;
import com.example.t2009m1helloworld.entity.ProductStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProductServlet extends HttpServlet {
    private ProductModel productModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId =Integer.parseInt(req.getParameter("id"));
        Product product = productModel.findById(productId);
        product.setProductStatus(ProductStatus.DELETED);
    }
}
