package com.example.t2009m1helloworld.entity;

import java.awt.*;

public class CartItem {
    private int productId;
    private String productName;
    private String productThumbnail;
    private double unitPrice;
    private int quantity;

    @Override
    public String toString(){
        return String.format("%s - %.2f - %d", productName, unitPrice, quantity);
    }
    public CartItem(){

    }
}
