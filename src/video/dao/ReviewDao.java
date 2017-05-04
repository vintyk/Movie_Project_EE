package video.dao;

import video.Entity.Countries;
import video.Entity.Review;
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
    private static final String REVIEW_TABLE_NAME = "countries";
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
}
