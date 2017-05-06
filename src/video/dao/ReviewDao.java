package video.dao;

import video.Entity.*;
import video.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 04.05.2017.
 */
public class ReviewDao {
    private static final String REVIEW_TABLE_NAME = "reviews";
    private static final String USERS_TABLE_NAME = "users";
    private static final Object LOCK = new Object();
    private static ReviewDao INSTANCE = null;

    public static ReviewDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ReviewDao();
                }
            }
        }
        return INSTANCE;
    }

    private Review createReviewFromResultSet(ResultSet resultSet) throws SQLException {
        return new Review(
                resultSet.getLong(REVIEW_TABLE_NAME + ".rank"),
                resultSet.getString(REVIEW_TABLE_NAME + ".comment_user"),
                new Users(
                        resultSet.getString(USERS_TABLE_NAME + ".name"),
                        resultSet.getString(USERS_TABLE_NAME + ".family")));
    }

    public void create(Review review) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO reviews (id_movies, id_user, rank, comment_user) " +
                            "VALUES (?, ?, ?, ?)")) {
                preparedStatement.setLong(1, review.getMovieId());
                preparedStatement.setLong(2, review.getUserId());
                preparedStatement.setLong(3, review.getRank());
                preparedStatement.setString(4, review.getCommentUser());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Review> findAllReviewByIDMovie(long id) {
        List<Review> review = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT reviews.rank,\n" +
                            "       reviews.comment_user,\n" +
                            "       users.name,\n" +
                            "       users.family\n" +
                            "FROM (movies_project.reviews    reviews\n" +
                            "      INNER JOIN movies_project.users users\n" +
                            "         ON (reviews.id_user = users.id))\n" +
                            "     INNER JOIN movies_project.movies movies\n" +
                            "        ON (reviews.id_movies = movies.id)\n" +
                            "        where movies.id = ?")) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                         System.out.println(createReviewFromResultSet(resultSet));
                        review.add(createReviewFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return review;
    }
}
