package video.dao;

import video.Entity.Privileges;
import video.Entity.Users;
import video.connection.ConnectionManager;

import java.sql.*;
import java.util.Optional;

/**
 * Created by Vinty on 09.04.2017.
 */
public class UsersDao {
    private static final Object LOCK = new Object();
    private static UsersDao INSTANCE = null;

    public static UsersDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new UsersDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<Users> addUser(Users users) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users (name, family, s_name, password, e_mail) " +
                            " VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, users.getNameUser());
                preparedStatement.setString(2, users.getFamilyUser());
                preparedStatement.setString(3, users.getsNameUser());
                preparedStatement.setString(4, users.getPasswordUser());
                preparedStatement.setString(5, users.geteMailUser());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if(generatedKeys.next()){
                    users.setId(generatedKeys.getLong(1));
                    return Optional.of(users);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    public Optional<Users> addUserAdmin(Users users) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users (name, family, s_name, password, privilege_id, e_mail) " +
                            " VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, users.getNameUser());
                preparedStatement.setString(2, users.getFamilyUser());
                preparedStatement.setString(3, users.getsNameUser());
                preparedStatement.setString(4, users.getPasswordUser());
                preparedStatement.setInt(5, users.getPrivilegeUser());
                preparedStatement.setString(6, users.geteMailUser());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if(generatedKeys.next()){
                    users.setId(generatedKeys.getLong(1));
                    return Optional.of(users);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    public Optional<Users> find(String eMail) {
        try(Connection connection = ConnectionManager.getConnection()) {
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT id, name, e_mail, password, privilege_id FROM users WHERE e_mail = ?")) {
                preparedStatement.setString(1, eMail);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                   return Optional.of(new Users(
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                                    resultSet.getString("e_mail"),
                            resultSet.getString("password"),
                            resultSet.getInt("privilege_id")
                            ));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Users> getById(long id) {
        try(Connection connection = ConnectionManager.getConnection()) {
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE id = ?")) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Users(
                            resultSet.getString("name"),
                            resultSet.getString("family"),
                            resultSet.getString("s_name"),
                            resultSet.getString("password"),
                            resultSet.getInt("privilege_id"),
                            resultSet.getString("e_mail")));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    public Optional<Users> getByIdPriv(long id) {
        try(Connection connection = ConnectionManager.getConnection()) {
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE id = ?")) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int tmp = resultSet.getInt("privilege_id");
                    Optional<Privileges> privileges = PrivilegesDao.getInstance().getById(tmp);
                    return Optional.of(new Users(
                            resultSet.getString("name"),
                            resultSet.getString("family"),
                            resultSet.getString("s_name"),
                            resultSet.getString("password"),
                            privileges.get().getName(),
                            resultSet.getString("e_mail")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
