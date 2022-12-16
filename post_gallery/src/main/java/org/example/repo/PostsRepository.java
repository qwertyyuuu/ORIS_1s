package org.example.repo;

import org.example.database.PostgresConnection;
import org.example.view.PostModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostsRepository {
    public List<PostModel> findAll() {
        try (Connection connection = PostgresConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from post_table"
            );

            ResultSet set = statement.executeQuery();
            List<PostModel> result = new ArrayList<>();

            while (set.next()) {
                PostModel postModel = PostModel.builder()
                        .id(set.getLong("id"))
                        .title(set.getString("title"))
                        .text(set.getString("text"))
                        .userID(set.getLong("user_id"))
                        .build();

                result.add(postModel);
            }

            return result;

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void save(PostModel postModel) {
        try (Connection connection = PostgresConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into post_table (title, text, user_id) values (?, ?, ?)"
            );

            statement.setString(1, postModel.getTitle());
            statement.setString(2, postModel.getText());
            statement.setLong(3, postModel.getUserID());

            statement.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Optional<PostModel> findByID(Long id) {
        try (Connection connection = PostgresConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from post_table where id = ?"
            );

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(
                        PostModel.builder()
                                .id(resultSet.getLong("id"))
                                .title(resultSet.getString("title"))
                                .text(resultSet.getString("text"))
                                .userID(resultSet.getLong("user_id"))
                                .build()
                );
            }

            return Optional.empty();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void update(PostModel postModel) {
        try (Connection connection = PostgresConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "update post_table set title = ?, text = ? where id = ?"
            );

            statement.setString(1, postModel.getTitle());
            statement.setString(2, postModel.getText());
            statement.setLong(3, postModel.getId());

            statement.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void delete(Long id) {
        try (Connection connection = PostgresConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "delete from post_table where id = ?"
            );

            statement.setLong(1, id);

            statement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
