package dao;

import connections.MySqlConnection;
import dao.transport.DBTransportDao;
import entity.Selection;
import entity.Transport;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBCalculationDao {

    private DBTransportDao transportDao = new DBTransportDao();


    public void selectTransport(Selection selection)  {
        Transport t = suitable(selection);
        double time = calcTime(selection);
        double price = calcPrice(selection);
        String text = String.format("Самый быстрый транспорт для доставки %d человек и %dт груза из %s в %s - это %s. " +
                "Время в пути %.2f часов. Стоимость доставки - %.2f$", selection.getPassengers(), selection.getCargo(), selection.getCityFrom().getName(),
                selection.getCityTo().getName(), t.getName(), time, price);
        System.out.println(text);
    }


    protected Transport suitable (Selection selection) {
        List<Transport> trans = new ArrayList<>();
        for (Transport t : transportDao.get()) {
            if (selection.getCityFrom().isHasAirport() && selection.getCityTo().isHasAirport() && selection.getCityFrom().isHasSeaPort() && selection.getCityTo().isHasSeaPort()) {
                try (Connection connection = MySqlConnection.getConnection()) {
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM transports WHERE seatCapacity >= ? AND cargoCapacity >= ? ORDER BY speed LIMIT 1");
                    preparedStatement.setInt(1, selection.getPassengers());
                    preparedStatement.setInt(2, selection.getCargo());
                    ResultSet result = preparedStatement.executeQuery();
                    while (result.next()) {
                        Transport transport = new Transport();
                        transport.setId(result.getInt("id"));
                        transport.setName(result.getString("name"));
                        transport.setSpeed(result.getInt("speed"));
                        transport.setSeatCapacity(result.getInt("seatCapacity"));
                        transport.setCargoCapacity(result.getInt("cargoCapacity"));
                        transport.setType(result.getString("type"));
                        transport.setPricePerKM(result.getInt("pricePerKM"));
                        trans.add(transport);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return t;
            }
            if (selection.getCityFrom().isHasAirport() && selection.getCityTo().isHasAirport()) {
                try (Connection connection = MySqlConnection.getConnection()) {
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM transports WHERE type = 'Air' OR type = 'Ground' AND seatCapacity >= ? AND cargoCapacity >= ? ORDER BY speed LIMIT 1");
                    preparedStatement.setInt(1, selection.getPassengers());
                    preparedStatement.setInt(2, selection.getCargo());
                    ResultSet result = preparedStatement.executeQuery();
                    while (result.next()) {
                        Transport transport = new Transport();
                        transport.setId(result.getInt("id"));
                        transport.setName(result.getString("name"));
                        transport.setSpeed(result.getInt("speed"));
                        transport.setSeatCapacity(result.getInt("seatCapacity"));
                        transport.setCargoCapacity(result.getInt("cargoCapacity"));
                        transport.setType(result.getString("type"));
                        transport.setPricePerKM(result.getInt("pricePerKM"));
                        trans.add(transport);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return t;
            }
            else if (selection.getCityFrom().isHasSeaPort() && selection.getCityTo().isHasSeaPort()) {
                try (Connection connection = MySqlConnection.getConnection()) {
                    PreparedStatement preparedStatement = connection.prepareStatement ("SELECT * FROM transports WHERE type = 'Sea' OR type = 'Ground' AND seatCapacity >= ? AND cargoCapacity >= ? ORDER BY speed LIMIT 1");
                    preparedStatement.setInt(1, selection.getPassengers());
                    preparedStatement.setInt(2, selection.getCargo());
                    ResultSet result = preparedStatement.executeQuery();
                    while (result.next()) {
                        Transport transport = new Transport();
                        transport.setId(result.getInt("id"));
                        transport.setName(result.getString("name"));
                        transport.setSpeed(result.getInt("speed"));
                        transport.setSeatCapacity(result.getInt("seatCapacity"));
                        transport.setCargoCapacity(result.getInt("cargoCapacity"));
                        transport.setType(result.getString("type"));
                        transport.setPricePerKM(result.getInt("pricePerKM"));
                        trans.add(transport);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return t;
            }
            else {
                try (Connection connection = MySqlConnection.getConnection()) {
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM transports WHERE type = 'Ground' AND seatCapacity >= ? AND cargoCapacity >= ? ORDER BY speed LIMIT 1");
                    preparedStatement.setInt(1, selection.getPassengers());
                    preparedStatement.setInt(2, selection.getCargo());
                    ResultSet result = preparedStatement.executeQuery();
                    while (result.next()) {
                        Transport transport = new Transport();
                        transport.setId(result.getInt("id"));
                        transport.setName(result.getString("name"));
                        transport.setSpeed(result.getInt("speed"));
                        transport.setSeatCapacity(result.getInt("seatCapacity"));
                        transport.setCargoCapacity(result.getInt("cargoCapacity"));
                        transport.setType(result.getString("type"));
                        transport.setPricePerKM(result.getInt("pricePerKM"));
                        trans.add(transport);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return t;
            }
        }
        return new Transport();
    }


    public double calcDistance(Selection selection) {
        double lon = selection.getCityFrom().getLength(); //широта
        double lat = selection.getCityFrom().getWidth(); //долгота
        double lon2 = selection.getCityTo().getLength();
        double lat2 = selection.getCityTo().getWidth();
        double result = 111.2 * Math.sqrt( (lon - lon2)*(lon - lon2) + (lat - lat2)*Math.cos(Math.PI*lon/180)*(lat - lat2)*Math.cos(Math.PI*lon/180));
        return result;
    }


    public double calcTime (Selection selection) {
        double s = calcDistance(selection);
        Transport t = suitable(selection);
        return s / t.getSpeed();
    }


    public double calcPrice (Selection selection) {
        Transport t = suitable(selection);
        return t.getPricePerKM() * calcDistance(selection);
    }

}
