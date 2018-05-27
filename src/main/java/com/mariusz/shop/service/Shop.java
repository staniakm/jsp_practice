package com.mariusz.shop.service;


import com.mariusz.shop.entity.Product;
import com.mariusz.utils.ListCreator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet (value = "/showAllProducts")
public class Shop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        ListCreator importer = new ListCreator();
        List<Product> products = importer.getProducts();
        out.print("<a href=./showCart>Show cart</a>");
            out.println("<table border = \"1\" width = \"100%\">");
            out.println("<tr>" +
                    "<th>ID.</th>" +
                    "<th>Name</th>" +
                    "<th>Details</th>" +
                    "</tr>");

            for (Product prod : products
                    ) {
                out.print("<tr>");
                out.print("<td>" + prod.getId() + "</td>");
                out.print("<td>" + prod.getName() + "</td>");
                out.print("<td><a href=./showProductDetails?id=" + prod.getId() + ">"+prod.getName()+"</a></td>");
                out.print("</tr>");
            }
            out.println("</table>");



    }


}
