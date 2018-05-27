package com.mariusz.login;

import com.mariusz.utils.ListCreator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        boolean correct = false;
        if (login!=null && pass!=null){
            correct = checkCredentials(login,pass);
        }
        if  (correct){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/files/welcome.jsp");
            dispatcher.forward(req, resp);

        }else {
            out.println("Incorrect password or login.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/files/loginPage.jsp");
            dispatcher.include(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/files/loginPage.jsp");
        dispatcher.include(req, resp);
    }

    private boolean checkCredentials(String login, String pass) {
        ListCreator list = new ListCreator();
        return list.checkCredentials(login,pass);
    }
}
