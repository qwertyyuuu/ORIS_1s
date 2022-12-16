package org.example.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.view.PostModel;
import org.example.services.PostService;

import java.io.IOException;

@WebServlet(name = "EditPostServlet", value = "/posts/edit")
public class Edit extends HttpServlet {

    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long postID = Long.parseLong(request.getParameter("postID"));
        PostModel postModel = postService.findPost(postID);
        request.setAttribute("postModel", postModel);
        request.getRequestDispatcher("/WEB-INF/jsp/EditPost.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String text = request.getParameter("text");
        PostModel postModel = postService.findPost(Long.parseLong(request.getParameter("postID")));
        postModel.setTitle(title);
        postModel.setText(text);

        postService.updatePost(postModel);
        response.sendRedirect("/posts/" + request.getParameter("postID"));
    }
}
