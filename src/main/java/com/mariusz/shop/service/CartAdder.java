package com.mariusz.shop.service;

import com.mariusz.shop.entity.Cart;
import com.mariusz.shop.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/addToCart")
public class CartAdder extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
                addToCart(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/files/shoppingCart.jsp");
        dispatcher.forward(request, response);
    }

    private void addToCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Product prod = ((Product) session.getAttribute("product"));

        String strQuantity = request.getParameter("quantity");

        Cart cartBean = null;

        Object objCartBean = session.getAttribute("cart");

        if (objCartBean != null) {
            cartBean = (Cart) objCartBean;
        } else {
            cartBean = new Cart();
            session.setAttribute("cart", cartBean);
        }

        cartBean.addCartItem(prod, strQuantity);
    }

}
