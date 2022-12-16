package org.example.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.view.PostModel;
import org.example.view.Recension;
import org.example.services.PostService;
import org.example.services.RecensionService;
import org.example.utils.UserUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "PostServlet", urlPatterns = "/posts/*")
public class Post extends HttpServlet {

    private final PostService postService = new PostService();
    private final RecensionService recensionService = new RecensionService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long postID = Long.parseLong(request.getPathInfo().substring(1));
            PostModel postModel = postService.findPost(postID);

            List<Recension> allRecension = recensionService.getAllRecension().stream()
                    .filter(recension -> recension.getPostID().equals(postID)).collect(Collectors.toList());

            request.setAttribute("recension", allRecension);
            request.setAttribute("postModel", postModel);
            request.setAttribute("request", request);
            request.getRequestDispatcher("/WEB-INF/jsp/Post.jsp").forward(request, response);

        } catch (Exception e) {
            response.sendRedirect("/posts");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("recension");
        Long postID = Long.parseLong(request.getPathInfo().substring(1));
        Long authUserID = UserUtils.getAuthUserID(request);

        Recension recension = Recension.builder().text(text).userID(authUserID).postID(postID).build();
        recensionService.saveRecension(recension);

        response.sendRedirect("/posts/" + postID);
    }
}
