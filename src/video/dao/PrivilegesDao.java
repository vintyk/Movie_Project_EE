package video.dao;
import video.Entity.Privileges;
import video.Entity.Roles;
import video.connection.ConnectionManager;
import java.sql.*;
import java.util.Optional;
/**
 * Created by User on 21.04.2017.
 */
public class PrivilegesDao {
    private static final Object LOCK = new Object();
    private static PrivilegesDao INSTANCE = null;

    public static PrivilegesDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new PrivilegesDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<Privileges> getById(long id) {
        try(Connection connection = ConnectionManager.getConnection()) {
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT name FROM privileges WHERE id = ?")) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Privileges(resultSet.getString("name")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}