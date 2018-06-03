package com.mariusz.wiki.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/logout")
public class LogoutFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        /*Doesn't require implementation*/
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        session.removeAttribute("userAuth");

        ((HttpServletResponse)servletResponse).sendRedirect(((HttpServletRequest) servletRequest).getContextPath()+"/wiki/main");
    }


    @Override
    public void destroy() {
        /*Doesn't require implementation*/
    }
}
