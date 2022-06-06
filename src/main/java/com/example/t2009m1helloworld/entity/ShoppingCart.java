package com.example.t2009m1helloworld.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCart {
    private double totalPrice;
    private String shipName;
    private String shipAddress;
    private String shipPhone;
    private String shipNote;
    private HashMap<Integer, CartItem> items;

    public ShoppingCart() {
        items = new HashMap<>();// lấy xe hàng mới trường hợp chưa có
    }

    //những hành động shopping cart có
    public List<CartItem> getListItems() { return new ArrayList<>(items.values());}//chuyển từ một map sang một list
    // quantity > 0
    public boolean add(Product product, int quantity){
        // check xem có sản phẩm chưa.
        CartItem cartItem = null;
        if(items.containsKey(product.getId())){
            // nếu có rồi thì update sản phẩm cũ.
            cartItem = items.get(product.getId());
            cartItem.setQuantity(cartItem.getQuantity()+ quantity);// update số lượng theo số lượng mới
        }else {
            // nếu chưa có thì tạo mới.
            cartItem = CartItem.CartItemBuilder.aCartItem()
                    .productId(product.getId())
                    .productName(product.getName())
                    .productThumbnail(product.getThumbnail())
                    .unitPrice(product.getPrice())
                    .quantity(quantity)
                    .build();
        }
        items.put(product.getId(), cartItem);
        return true;
    }
    // quantity > 0
    public boolean sub(Product product, int quantity){
        // check xem có sản phẩm chưa.
        CartItem cartItem = null;
        if (items.containsKey(product.getId())){
            //nêú có rồi thì update sản phẩm cũ.
            cartItem = items.get(product.getId());
            int updateQuantity = cartItem.getQuantity() - quantity;
            if (updateQuantity <= 0){
                items.remove(product.getId());
            } else {
                cartItem.setQuantity(updateQuantity);// update số lượng theo số lượng mới
            }
        }
        return true;
    }
    public boolean remove(int productId){
        if (items.containsKey(productId)){
            items.remove(productId);
            return true;
        }
        return false;
    }
    public void clear(){items.clear();}

    public double getTotalPrice() {
        if (items.size()==0) {
            return 0;
        }
        totalPrice=0;
        for (CartItem item:getListItems()){
            totalPrice += item.getUnitPrice() * item.getQuantity();
        }
        return totalPrice;
    }
}
