package com.mariusz.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListCreator {
//    private Map<String, Integer> lista = new HashMap<>();
//    private List<Shop> shops = new ArrayList<>();
    private Map<String, String> logins = new HashMap<>();
//    private List<Product> products = new ArrayList<>();

    public ListCreator() {
//        createMap();
//        createShopList();
        createCredentials();
//        createProducts();
    }

//    private void createProducts() {
//        products.add(new Product(1,"Truskawka","https://pl.wikipedia.org/wiki/Truskawka","https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Strawberry_closeup.jpg/240px-Strawberry_closeup.jpg",20));
//        products.add(new Product(2,"Banan","https://pl.wikipedia.org/wiki/Banan","https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Musa_x_paradisiaca_-_Pisang_Mas.jpg/220px-Musa_x_paradisiaca_-_Pisang_Mas.jpg",10));
//        products.add(new Product(3,"Mango","https://pl.wikipedia.org/wiki/Mango","https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/The_Botanical_Magazine._Mango.jpg/201px-The_Botanical_Magazine._Mango.jpg",15));
//    }
//    public List<Product> getProducts(){
//        return products;
//    }
//
//    public Product getProductByID(int id){
//        for (Product prod: products
//                ) {
//            if (prod.getId()==id){
//                return prod;
//            }
//        }
//        return null;
//    }

    private void createCredentials() {
        logins.put("mariusz","1");
        logins.put("pawel","1234");
        logins.put("ania","4321");
    }

    public boolean checkCredentials(String login, String pass){
        if (logins.containsKey(login.toLowerCase())){
            return logins.get(login.toLowerCase()).equals(pass);
        }else {
            return false;
        }
    }

//    private void createShopList() {
//        shops.add(new Shop(1,"sklep 1"));
//        shops.add(new Shop(2,"sklep 2"));
//        shops.add(new Shop(3,"sklep 3"));
//        shops.add(new Shop(4,"sklep 4"));
//
//    }
//
//    public List<Shop> getShops() {
//        return shops;
//    }
//
//    private void createMap() {
//        lista.put("Mariusz",1500);
//        lista.put("Paweł",1254);
//        lista.put("Łukasz",1577);
//        lista.put("Dominik",2556);
//        lista.put("Karolina",1145);
//    }
//
//    public Map<String, Integer> getMap(){
//        return lista;
//    }

}
