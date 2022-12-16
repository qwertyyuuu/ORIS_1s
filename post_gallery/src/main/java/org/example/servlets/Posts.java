package org.example.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.view.PostModel;
import org.example.services.PostService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllPostsServlet", value = "/posts")
public class Posts extends HttpServlet {

    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PostModel> postModels = postService.getAllPosts();
        request.setAttribute("posts", postModels);
        request.getRequestDispatcher("/WEB-INF/jsp/Posts.jsp").forward(request, response);
    }

}
