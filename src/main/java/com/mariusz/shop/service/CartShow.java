package com.mariusz.shop.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/showCart")
public class CartShow extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/files/shoppingCart.jsp");
        dispatcher.forward(request, response);
    }

//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html; charset=UTF-8");
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/files/shoppingCart.jsp");
//        dispatcher.forward(request, response);
//
//    }
}
