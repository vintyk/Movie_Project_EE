package video.dao;

import video.Entity.Roles;
import video.connection.ConnectionManager;

import java.sql.*;
import java.util.Optional;

/**
 * Created by User on 21.04.2017.
 */
public class RolesDao {
    private static final Object LOCK = new Object();
    private static RolesDao INSTANCE = null;

    public static RolesDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new RolesDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<Roles> getById(long id) {
        try(Connection connection = ConnectionManager.getConnection()) {
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM roles WHERE id = ?")) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Roles(id, resultSet.getString("name")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
