package org.example.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.view.User;
import org.example.services.UserService;
import org.example.utils.Hash;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AuthServlet", value = "/auth")
public class LogIn extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/Auth.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        password = Hash.hashPassword(password);

        List<User> users = userService.getAllUsers();

        for (User user : users) {
            if (user.getLogin().equals(login)) {
                if (user.getPassword().equals(password)) {
                    request.getSession(true).setAttribute("user", user);
                    response.sendRedirect("/home");
                    return;
                }
            }
        }

        response.sendRedirect("/auth?error");
    }
}
