package dao.transport;

import connections.MySqlConnection;
import entity.Transport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBTransportDao implements TransportDao {

    @Override
    public void add(Transport transport) {
        try (Connection connection = MySqlConnection.getConnection()) {
            String sql = "INSERT INTO transports (name, speed, seatCapacity, cargoCapacity, type, pricePerKM) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, transport.getName());
            statement.setInt(2, transport.getSpeed());
            statement.setInt(3, transport.getSeatCapacity());
            statement.setInt(4, transport.getCargoCapacity());
            statement.setString(5, transport.getType());
            statement.setInt(6, transport.getPricePerKM());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transport> get() {
        List<Transport> transports = new ArrayList<>();
        try (Connection connection = MySqlConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM transports");
            while (result.next()) {
                Transport transport = new Transport();
                transport.setId(result.getInt("id"));
                transport.setName(result.getString("name"));
                transport.setSpeed(result.getInt("speed"));
                transport.setSeatCapacity(result.getInt("seatCapacity"));
                transport.setCargoCapacity(result.getInt("cargoCapacity"));
                transport.setType(result.getString("type"));
                transport.setPricePerKM(result.getInt("pricePerKM"));
                transports.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transports;
    }

    @Override
    public void remove(Transport transport) {
        try (Connection connection = MySqlConnection.getConnection()) {
            String sql = "DELETE FROM transports WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, transport.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Transport transport) {
        try (Connection connection = MySqlConnection.getConnection()) {
            String sql = "UPDATE transports SET name = ?, speed = ?, seatCapacity = ?, cargoCapacity = ?, type = ?, pricePerKM = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, transport.getName());
            statement.setInt(2, transport.getSpeed());
            statement.setInt(3, transport.getSeatCapacity());
            statement.setInt(4, transport.getCargoCapacity());
            statement.setString(5, transport.getType());
            statement.setInt(6, transport.getPricePerKM());
            statement.setInt(7, transport.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
