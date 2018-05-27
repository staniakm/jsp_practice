package com.mariusz.generator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(value = "/generator")
public class Generator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/files/generator.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        String length = req.getParameter("length");
        String incChars = req.getParameter("incChars");
        String incNums = req.getParameter("incNums");
        String incLower = req.getParameter("incLower");
        String incUpper = req.getParameter("incUpper");
        String excAmbi = req.getParameter("excAmbi");
        String excSimi = req.getParameter("excSimi");

        if(incChars==null && incNums==null && incLower==null && incUpper==null){
            writer.print("Select at at least one option that will provide chars for password.");
        }else {
            List<String> chars = getChars(incChars,incNums,incLower,incUpper,excAmbi,excSimi);
            Collections.shuffle(chars);
            String pass = generate(Integer.parseInt(length), chars);
            req.setAttribute("pas",pass);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/files/generator.jsp");
            dispatcher.forward(req, resp);

        }
    }

    private List<String> getChars(String incChars, String incNums, String incLower,
                                  String incUpper, String excAmbi,String excSimi) {
        List<String> chars = new ArrayList<>();
        if(incChars!=null) {
            chars.addAll(Arrays.asList("!@#$%^&*+-*=".split("")));
            if (excAmbi==null){
                chars.addAll(Arrays.asList("{}[]()\\//'\"~`.,;:<>".split("")));
            }
        }
        if (incNums!=null){
            chars.addAll(Arrays.asList("123456789".split("")));
            if (excSimi==null){
                chars.addAll(Arrays.asList("0".split("")));
            }
        }

        if(incLower!=null){
            chars.addAll(Arrays.asList("qwertyupkjhgfdsazxcvbnm".split("")));
            if (excSimi==null){
                chars.addAll(Arrays.asList("ilo".split("")));
            }
        }

        if(incUpper!=null){
            chars.addAll(Arrays.asList("QWERTYUPLKJHGFDSAZXCVBNM".split("")));
            if (excSimi==null){
                chars.addAll(Arrays.asList("OI".split("")));
            }
        }

        return chars;
    }

    private String generate(int length, List<String> chars){

        StringBuilder pass2 = new StringBuilder();
        int number;
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            number = random.nextInt(chars.size());
            pass2.append(chars.get(number));
        }
        return pass2.toString();
    }

}
