package com.example.t2009m1helloworld.controller.shoppingcart;

import com.example.t2009m1helloworld.entity.ShoppingCart;
import util.ShoppingCartHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try{
            //lấy tham số khi người dùng tiến hành click add to cart
            Integer productId = Integer.parseInt(req.getParameter("productId"));
            //check xem shopping cart có trong session chưa, có rồi thì lấy ra
            //chưa có tạo mới
            ShoppingCartHelper shoppingCartHelper= new ShoppingCartHelper(req);
            ShoppingCart shoppingCart = shoppingCartHelper.getCart();
            //thêm sản phẩm vào shopping cart
            shoppingCart.remove(productId);
            //lưu shopping cart vào session
            shoppingCartHelper.saveCart(shoppingCart);
            resp.sendRedirect("/shopping-cart/get");
        }catch (Exception ex){
            resp.getWriter().println(ex.getMessage());
        }
    }
}
