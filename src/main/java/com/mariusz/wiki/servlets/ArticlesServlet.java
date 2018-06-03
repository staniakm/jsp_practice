package com.mariusz.wiki.servlets;

import com.mariusz.wiki.entities.Article;
import com.mariusz.wiki.services.ArticleServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/wiki/main/articles")
public class ArticlesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArticleServices articleList = new ArticleServices();
        List<Article> articles =  articleList.getAllArticles();
        req.setAttribute("articles", articles);

        req.getRequestDispatcher("/files/articles.jsp").forward(req,resp);

    }
}
