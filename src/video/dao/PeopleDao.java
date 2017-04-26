package video.dao;

import video.Entity.People;
import video.Entity.Roles;
import video.connection.ConnectionManager;

import javax.management.relation.Role;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Vinty on 09.04.2017.
 */
public class PeopleDao {

    private static final String PEOPLE_TABLE_NAME = "people";
    private static final String ROLES_TABLE_NAME = "roles";
    private static final Object LOCK = new Object();
    private static PeopleDao INSTANCE = null;

    public static PeopleDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new PeopleDao();
                }
            }
        }
        return INSTANCE;
    }

    private People createPeopleFromResultSet(ResultSet resultSet) throws SQLException {
        return new People(
                resultSet.getLong(PEOPLE_TABLE_NAME + ".id"),
                resultSet.getString(PEOPLE_TABLE_NAME + ".name"),
                resultSet.getString(PEOPLE_TABLE_NAME + ".family"),
                resultSet.getString(PEOPLE_TABLE_NAME + ".s_name"),
                resultSet.getString(PEOPLE_TABLE_NAME + ".date_bday"),
                new Roles(resultSet.getLong(ROLES_TABLE_NAME + ".id"),
                        resultSet.getString(ROLES_TABLE_NAME + ".name")));
    }

    public void create(People people, long rolesId) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO people (name, family, s_name, date_bday, id_role) " +
                            "VALUES (?, ?, ?, ?, ?)")) {
                preparedStatement.setString(1, people.getsNamePeople());
                preparedStatement.setString(2, people.getFamilyPeople());
                preparedStatement.setString(3, people.getsNamePeople());
                preparedStatement.setString(4, people.getDateOfBirthPeople());
                preparedStatement.setLong(5, rolesId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<People> findById(long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * \n" +
                            "FROM people \n" +
                            "JOIN roles ON people.id_role = roles.id \n" +
                            "WHERE people.id = ?")) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(createPeopleFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<People> findAll() {
        List<People> people = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM people JOIN roles ON people.id_role = roles.id ORDER BY family;")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        people.add(createPeopleFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }
 }
