package com.mariusz.shop.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList();
    private double totalCost;


    public void addCartItem(Product product, String quantity) {
        double q = Double.parseDouble(quantity);
        CartItem cartItem = new CartItem(product, q);
        items.add(cartItem);
        calculateOrderTotal();
    }

    private void calculateOrderTotal() {
        double tempCost = 0;
        for (int counter = 0; counter < items.size(); counter++) {
            CartItem cartItem = items.get(counter);
            tempCost += cartItem.getTotalCost();
        }
        totalCost = tempCost;
    }

    public double getTotalCost(){
        return totalCost;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public int getTotalItems(){
        return items.size();
    }

}
