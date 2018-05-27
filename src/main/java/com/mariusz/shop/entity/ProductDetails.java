package com.mariusz.shop.entity;

import com.mariusz.utils.ListCreator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/showProductDetails")
public class ProductDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String id = req.getParameter("id");

        if (id == null || id.equals("")) {
            out.println("<p>Niepoprawne ID</p>");
            RequestDispatcher dispatcher = req.getRequestDispatcher("showAllProducts");
            dispatcher.include(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/files/productDetails.jsp");
            HttpSession session = req.getSession();

            ListCreator listImporter = new ListCreator();
            int prodId = Integer.parseInt(id);
            Product prod = listImporter.getProductByID(prodId);
            session.setAttribute("product", prod);
            dispatcher.include(req, resp);

        }
    }
}
