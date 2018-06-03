package com.mariusz.wiki.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/wiki/main/articles/article/*","/wiki/main/articles/new/*"})
public class ArticleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        /*doesn't require implementation*/
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html; charset=UTF-8");
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        Object auth = session.getAttribute("userAuth");
        if (auth == null) {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/login");
            dispatcher.forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        /*doesn't require implementation*/
    }
}
