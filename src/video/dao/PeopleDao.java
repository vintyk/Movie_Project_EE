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
                    "SELECT * FROM people JOIN roles ON people.id_role = roles.id;")) {
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
    //    public Optional<People> addPeople(People people) {


//    public static List<People> getPeopleByMovieId(long idMovie) {

    //    }
//        return result;
//        }
//            e.printStackTrace();
//        } catch (SQLException e) {
//            }
//                }
//                    }
//                        result.add(people);
//                                role);
//                                dateOfBirthPeople,
//                                sNamePeople,
//                                familyPeople,
//                                namePeople,
//                        People people = new People(idPeople,
//                        String dateOfBirthPeople = resultSet.getString("people.date_bday");
//                        String sNamePeople = resultSet.getString("people.s_name");
//                        String familyPeople = resultSet.getString("people.family");
//                        String namePeople = resultSet.getString("people.name");
//                        int role = resultSet.getInt("roles.name");
//                        long idPeople = resultSet.getLong("movies.id");
//                    while (resultSet.next()) {
//                try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                preparedStatement.setLong(1, idMovie);
//                            "ORDER BY roles.name DESC")) {
//                            "        where movies.id = ?\n" +
//                            "        ON (movie_people_role.id_movie = movies.id)\n" +
//                            "     INNER JOIN movies_project.movies movies\n" +
//                            "            AND (movie_people_role.id_people = people.Id))\n" +
//                            "         ON     (people.id_role = roles.id)\n" +
//                            "      INNER JOIN movies_project.people people\n" +
//                            "          ON (movie_people_role.id_role = roles.id))\n" +
//                            "       INNER JOIN movies_project.roles roles\n" +
//                            "FROM ((movies_project.movie_people_role    movie_people_role\n" +
//                            "       people.date_bday\n" +
//                            "       people.s_name,\n" +
//                            "       people.family,\n" +
//                            "       people.name,\n" +
//                            "       roles.name,\n" +
//                    "SELECT     movies.id,\n" +
//            try (PreparedStatement preparedStatement = connection.prepareStatement(
//        try (Connection connection = ConnectionManager.getConnection()) {
//        List<People> result = new ArrayList<>();
//    }
//        return Optional.empty();
//        }
//            e.printStackTrace();
//        } catch (SQLException e) {
//            }
//                }
//                    return Optional.of(people);
//                    people.setId(generatedKeys.getLong(1));
//                if (generatedKeys.next()) {
//                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//                preparedStatement.executeUpdate();
//                preparedStatement.setInt(5, people.getRole());
//                preparedStatement.setString(4, people.getDateOfBirthPeople());
//                preparedStatement.setString(3, people.getsNamePeople());
//                preparedStatement.setString(2, people.getFamilyPeople());
//                preparedStatement.setString(1, people.getNamePeople());
//                            " VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
//                    "INSERT INTO people (name, family, s_name, date_bday, id_role) " +
//            try (PreparedStatement preparedStatement = connection.prepareStatement(
//        try (Connection connection = ConnectionManager.getConnection()) {
//    public Optional<People> addPeople(People people) {
//        RolesDao.getInstance().getById(1);
//        try (Connection connection = ConnectionManager.getConnection()) {
//            try (PreparedStatement preparedStatement = connection.prepareStatement(
//                    "INSERT INTO people (name, family, s_name, date_bday, id_role) " +
//                            " VALUES (?, ?, ?, ?, ?)")) {
//                preparedStatement.setString(1, people.getNamePeople());
//                preparedStatement.setString(2, people.getFamilyPeople());
//                preparedStatement.setString(3, people.getsNamePeople());
//                preparedStatement.setString(4, people.getDateOfBirthPeople());
//                preparedStatement.setInt(5, people.getRole());
//                preparedStatement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }

}
