package org.example.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.view.User;
import org.example.services.RecensionService;
import org.example.services.UserService;

public class UserUtils {
    private static final UserService userService = new UserService();
    private static final RecensionService recensionService = new RecensionService();
    public static boolean isAuth(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        return session != null && session.getAttribute("user") != null;
    }

    public static Long getAuthUserID(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return user.getId();
    }

    public static User getAuthUser(HttpServletRequest request) {
        return (User) request.getSession(false).getAttribute("user");
    }

    public static boolean isPostBelongsToAuthUser(Long postID, HttpServletRequest request) {
        User user = getAuthUser(request);
        return user.getId().equals(postID);
    }

    public static String getRecensionAuthorName(Long authorID) {
        return userService.getUser(authorID).getLogin();
    }

}
