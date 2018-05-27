package com.mariusz.shop.entity;

public class Product {

    private int id;
    private String name;
    private String url;
    private String imgUrl;
    private double price;

    public Product(int id, String name, String url, String imgUrl, double price) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.imgUrl = imgUrl;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
