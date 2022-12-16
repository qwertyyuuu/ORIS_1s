package org.example.servlets.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.utils.UserUtils;

import java.io.IOException;

@WebFilter(urlPatterns = "/posts/add")
public class MainFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!UserUtils.isAuth(request)) {
            response.sendRedirect("/auth");
            return;
        }

        chain.doFilter(request, response);
    }
}
