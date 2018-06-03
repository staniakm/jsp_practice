package com.mariusz.wiki.servlets;

import com.mariusz.wiki.entities.Article;
import com.mariusz.wiki.services.ArticleServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/wiki/main/articles/article")
public class ArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        ArticleServices services = new ArticleServices();
        int id = Integer.parseInt(req.getParameter("id"));
        Article art = services.getArticleById(id);

        req.setAttribute("art",art);

        req.getRequestDispatcher("/files/article.jsp").forward(req,resp);

    }
}
