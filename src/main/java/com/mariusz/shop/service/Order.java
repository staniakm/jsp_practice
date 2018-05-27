package com.mariusz.shop.service;

import com.mariusz.shop.entity.Cart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/placeOrder")
public class Order extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        Cart cartBean = null;
        Object objCartBean = session.getAttribute("cart");

        if (objCartBean != null) {
            cartBean = (Cart) objCartBean;
            out.print("<a href=./showAllProducts>Go to main</a>");
            out.print("<hr>");

            out.print("<h3>Order placed</h3>");

            out.print("<p>Items: " + cartBean.getTotalItems() + "<p>");
            out.print("<p>Total: " + cartBean.getTotalCost() + " zł</p>");
            session.setAttribute("cart", null);


        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("showAllProducts");
            dispatcher.forward(request, response);
        }


    }
}
