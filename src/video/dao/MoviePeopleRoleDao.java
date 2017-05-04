package video.dao;


import video.Entity.MoviePeopleRole;
import video.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Vinty on 09.04.2017.
 */
public class MoviePeopleRoleDao {

    private static final Object LOCK = new Object();
    private static MoviePeopleRoleDao INSTANCE = null;

    public static MoviePeopleRoleDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new MoviePeopleRoleDao();
                }
            }
        }
        return INSTANCE;
    }

    public void create(MoviePeopleRole moviePeopleRole) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO movie_people_role (id_movie, id_people, id_role) " +
                            "VALUES (?, ?, ?)")) {
                preparedStatement.setLong(1, moviePeopleRole.getMoviesId());
                preparedStatement.setLong(2, moviePeopleRole.getPeoplesId());
                preparedStatement.setLong(3, moviePeopleRole.getRolesId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
