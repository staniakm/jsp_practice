package com.mariusz.wiki.servlets;

import com.mariusz.wiki.controlers.Controler;
import com.mariusz.wiki.entities.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if (req.getParameter("reg").equalsIgnoreCase("true")){
            String message = "";
            String uName = req.getParameter("uname");
            String uLogin = req.getParameter("un");
            String uPass = req.getParameter("pw");
            if (uLogin.length()<=4 || uPass.length()<=4){
                message = "Incorrect password or login. Password and login should have length > 4";

            }else if ( checkLoginUsage(req.getParameter("un"))){
                message = "LoginServlet is taken.";
            }

            if (message.length()==0){
                registerNewUser(uLogin, uPass, uName);
                out.println("New user added.");

                RequestDispatcher dispatcher = req.getRequestDispatcher("/files/loginPage.jsp");
                dispatcher.forward(req, resp);
            }else {
                out.print(message);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/files/register.jsp");
                dispatcher.forward(req, resp);
            }

        }

        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        Person person = null;

        if (login!=null && pass!=null){
            person = checkCredencial(login,pass);
        }
        if  (person!=null){
            HttpSession session = req.getSession();

            session.setAttribute("userAuth", person);
            session.setMaxInactiveInterval(60*60*2);
            resp.sendRedirect( req.getServletContext().getContextPath()+"/wiki/main");

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


    private void registerNewUser(String uLogin, String uPass, String uName) {

        Controler list = new Controler();
        list.registerNewUser(uLogin, uPass, uName);

    }
    private boolean checkLoginUsage(String login) {
        Controler list = new Controler();
        return list.checkLoginUsage(login);
    }

    private Person checkCredencial(String login, String pass) {
        Controler list = new Controler();
        return list.checkCredentials(login,pass);
    }
}
