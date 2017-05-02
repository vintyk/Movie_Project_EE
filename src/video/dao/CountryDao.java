package video.dao;

import video.Entity.Countries;
import video.connection.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinty on 09.04.2017.
 */
public class CountryDao {

    private static final String COUNTRIES_TABLE_NAME = "countries";
    private static final Object LOCK = new Object();
    private static CountryDao INSTANCE = null;

    public static CountryDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new CountryDao();
                }
            }
        }
        return INSTANCE;
    }

    private Countries createCountriesFromResultSet(ResultSet resultSet) throws SQLException {
        return new Countries(
                resultSet.getLong(COUNTRIES_TABLE_NAME + ".id"),
                resultSet.getString(COUNTRIES_TABLE_NAME + ".name"));
    }

    public List<Countries> findAll() {
        List<Countries> countries = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM countries ORDER BY name;")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        countries.add(createCountriesFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
