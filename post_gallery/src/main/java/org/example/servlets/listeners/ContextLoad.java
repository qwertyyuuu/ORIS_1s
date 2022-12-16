package org.example.servlets.listeners;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.database.PostgresConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebListener
public class ContextLoad implements ServletContextListener, HttpSessionListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        // language=SQL
        String createUser = "create table if not exists user_table (" +
                "id bigserial primary key," +
                "login varchar(200)," +
                "password varchar(200)," +
                "role varchar(50) default 'user')";

        // language=SQL
        String createPost = "create table if not exists post_table (" +
                "id bigserial primary key," +
                "title varchar(500)," +
                "text varchar(2000)," +
                "user_id bigint references user_table(id))";

        // language=SQL
        String createRecension = "create table if not exists recension_table (" +
                "id bigserial primary key," +
                "text varchar(1000)," +
                "user_id bigint references user_table(id)," +
                "post_id bigint references post_table(id))";

        try (Connection connection = PostgresConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(createUser);
            statement.execute();

            statement = connection.prepareStatement(createPost);
            statement.execute();

            statement = connection.prepareStatement(createRecension);
            statement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
