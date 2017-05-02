package video.dao;

import video.Entity.*;
import video.connection.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Vinty on 09.04.2017.
 */
public class MoviesDao {
    private static final String MOVIES_TABLE_NAME = "movies";
    private static final String GENRES_TABLE_NAME = "genres";
    private static final String COUNTRIES_TABLE_NAME = "countries";
    private static final Object LOCK = new Object();
    private static MoviesDao INSTANCE = null;

    public static MoviesDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new MoviesDao();
                }
            }
        }
        return INSTANCE;
    }

    private Movies createMoviesFromResultSet(ResultSet resultSet) throws SQLException {
        return new Movies(
                resultSet.getLong(MOVIES_TABLE_NAME + ".id"),
                resultSet.getString(MOVIES_TABLE_NAME + ".name"),
                resultSet.getString(MOVIES_TABLE_NAME + ".year"),
                new Genres(
                        resultSet.getLong(GENRES_TABLE_NAME + ".id"),
                        resultSet.getString(GENRES_TABLE_NAME + ".name")),
                new Countries(
                        resultSet.getLong(COUNTRIES_TABLE_NAME + ".id"),
                        resultSet.getString(COUNTRIES_TABLE_NAME + ".name")));
    }

    private Movies createMoviesYearFromResultSet(ResultSet resultSet) throws SQLException {
        return new Movies(
                resultSet.getLong(MOVIES_TABLE_NAME + ".id"),
                resultSet.getString(MOVIES_TABLE_NAME + ".year"));
    }
    private Movies createMoviesByYearFromResultSet(ResultSet resultSet) throws SQLException {
        return new Movies(
                resultSet.getString(MOVIES_TABLE_NAME + ".name"),
                resultSet.getString(MOVIES_TABLE_NAME + ".year"));
    }

    public void create(Movies movies, long genreId, long countrieId) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO movies (name, year, genre, countrie) " +
                            "VALUES (?, ?, ?, ?)")) {
                preparedStatement.setString(1, movies.getNameMovie());
                preparedStatement.setString(2, movies.getDateReleaseMovie());
                preparedStatement.setLong(3, genreId);
                preparedStatement.setLong(4, countrieId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Movies> findById(long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT genres.id,\n" +
                            "       genres.name,\n" +
                            "       movies.id,\n" +
                            "       movies.name,\n" +
                            "       movies.genre,\n" +
                            "       movies.countrie,\n" +
                            "       movies.year,\n" +
                            "       countries.id,\n" +
                            "       countries.name\n" +
                            "FROM (movies_project.movies  AS  movies\n" +
                            "      INNER JOIN movies_project.countries AS countries\n" +
                            "         ON (movies.countrie = countries.id))\n" +
                            "     INNER JOIN movies_project.genres genres ON (movies.genre = genres.id)\n" +
                            "     where movies.id = ?;")) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(createMoviesFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Movies> findAll() {
        List<Movies> movies = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT genres.id,\n" +
                            "   genres.name,\n" +
                            "   movies.id,\n" +
                            "   movies.name,\n" +
                            "   movies.genre,\n" +
                            "   movies.countrie,\n" +
                            "   movies.year,\n" +
                            "   countries.id,\n" +
                            "   countries.name\n" +
                            "FROM (movies_project.movies  AS  movies\n" +
                            "  INNER JOIN movies_project.countries AS countries\n" +
                            "     ON (movies.countrie = countries.id))\n" +
                            " INNER JOIN movies_project.genres genres ON (movies.genre = genres.id);")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        movies.add(createMoviesFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public List<Movies> findAllYear() {
        List<Movies> movies = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT \n" +
                            "       movies.id,\n" +
                            "       movies.year\n" +
                            "FROM movies_project.movies\n" +
                            "ORDER BY 2 ASC")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        movies.add(createMoviesYearFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }
    public List<Movies> findAllMovieByYear(String year) {
        List<Movies> movies = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT \n" +
                            "   movies.name,\n" +
                            "   movies.year \n" +
                            "FROM movies_project.movies  AS  movies\n" +
                            "           WHERE YEAR(movies.year)= ?")) {
                preparedStatement.setString(1, year);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println(createMoviesByYearFromResultSet(resultSet));
                        movies.add(createMoviesByYearFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
