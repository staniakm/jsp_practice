package com.mariusz.wiki.servlets;

import com.mariusz.wiki.entities.Article;
import com.mariusz.wiki.entities.Content;
import com.mariusz.wiki.entities.Person;
import com.mariusz.wiki.services.ArticleServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/wiki/main/articles/new")
public class ArticleNew extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/files/addArticle.jsp");
        dispatcher.forward(req,resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticleServices articleServices = new ArticleServices();
        Person person = (Person) req.getSession().getAttribute("userAuth");
        String author = "Anonnymus";
        if (person!=null)
            author = person.getName();

        Article art = new Article();
        art.setTitle(req.getParameter("title"));
        art.setLastUpdate(LocalDateTime.now());
        art.setAuthor(author);

        Content content = new Content(req.getParameter("articleContent"));

        articleServices.saveArticle(art, content);

        resp.sendRedirect(req.getContextPath()+"/wiki/main/articles");
    }
}
