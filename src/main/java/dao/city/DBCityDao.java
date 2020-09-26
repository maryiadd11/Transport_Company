package dao.city;

import connections.MySqlConnection;
import entity.City;
import exceptions.DuplicateCityException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBCityDao implements CityDao {

    public void add(City city) throws DuplicateCityException {
        try (Connection connection = MySqlConnection.getConnection()) {
            String sql = "INSERT INTO cities (name, length, width, hasAirport, hasSeaPort) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, city.getName());
            statement.setDouble(2, city.getLength());
            statement.setDouble(3, city.getWidth());
            statement.setBoolean(4, city.isHasAirport());
            statement.setBoolean(5, city.isHasSeaPort());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<City> get() {
        List <City> cities = new ArrayList<>();
        try (Connection connection = MySqlConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM cities");
            while (result.next()) {
                City city = new City();
                city.setId(result.getInt("id"));
                city.setName(result.getString("name"));
                city.setLength(result.getDouble("length"));
                city.setWidth(result.getDouble("width"));
                city.setHasAirport(result.getBoolean("hasAirport"));
                city.setHasSeaPort(result.getBoolean("hasSeaPort"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public void remove(City city) {
        try (Connection connection = MySqlConnection.getConnection()) {
            String sql = "DELETE FROM cities WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, city.getName());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(City city) {
        try (Connection connection = MySqlConnection.getConnection()) {
            String sql = "UPDATE cities SET name = ?, length = ?, width = ?, hasAirport = ?, hasSeaPort = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, city.getName());
            statement.setDouble(2, city.getLength());
            statement.setDouble(3, city.getWidth());
            statement.setBoolean(4, city.isHasAirport());
            statement.setBoolean(5, city.isHasSeaPort());
            statement.setInt(6, city.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
