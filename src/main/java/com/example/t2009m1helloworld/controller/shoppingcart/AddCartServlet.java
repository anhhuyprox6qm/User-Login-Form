package com.example.t2009m1helloworld.controller.shoppingcart;

import com.example.t2009m1helloworld.entity.Product;
import com.example.t2009m1helloworld.entity.ShoppingCart;
import com.example.t2009m1helloworld.model.ProductModel;
import util.ShoppingCartHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCartServlet extends HttpServlet {
    private ProductModel productModel;
    public AddCartServlet(){this.productModel=new MySqlProductModel();}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        try{
            //lấy tham số khi người dùng tiến hành click add to cart
            Integer productId=Integer.parseInt(req.getParameter("productId"));
            Integer quantity=Integer.parseInt(req.getParameter("quantity"));
            //check sản phẩm tồn tại không, còn hàng không?
            Product product = productModel.findById(productId);
            if (product == null){
                resp.getWriter().println("Product is not found!");
                return;
            }
            //check số lượng sản phẩm có nhỏ hơn hoặc bằng 0?
            if (quantity <= 0){
                resp.getWriter().println("Invalid quantity!");
                return;
            }
            //check xem shopping cart có trong session chưa, có rồi thì lấy ra
            //chưa có tạo mới
            ShoppingCartHelper shoppingCartHelper = new ShoppingCartHelper(req);
            ShoppingCart shoppingCart = shoppingCartHelper.getCart();
            //thêm sản phẩm vào shopping cart
            shoppingCart.add(product, quantity);
            //lưu shopping cart vào session
            shoppingCartHelper.saveCart(shoppingCart);
            resp.sendRedirect("/shopping-cart/get");
        }catch (Exception ex){
            resp.getWriter().println(ex.getMessage());
        }
    }
}
