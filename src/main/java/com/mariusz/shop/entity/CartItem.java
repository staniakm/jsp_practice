package com.mariusz.shop.entity;

public class CartItem {
    private Product product;
    private double quantity;

    public CartItem(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getTotalCost() {
       return product.getPrice()*quantity;

    }
}
