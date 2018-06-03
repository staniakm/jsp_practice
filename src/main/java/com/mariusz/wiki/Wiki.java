package com.mariusz.wiki;

import com.mariusz.wiki.entities.Article;
import com.mariusz.wiki.services.ArticleServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/wiki/main"})
public class Wiki extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("Hello from wiki main page.");
        ArticleServices articleList = new ArticleServices();
        List<Article> articles =  articleList.getXnewestArticles(5);

        req.setAttribute("articles", articles);

        req.getRequestDispatcher("/files/wiki.jsp").forward(req,resp);


    }
}
