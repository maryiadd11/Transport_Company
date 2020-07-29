package application.actions;

import application.utils.Input;
import controller.CityController;
import controller.SelectionController;
import controller.TransportController;
import dao.DBCalculationDao;
import entity.City;
import entity.Selection;
import entity.Transport;
import exceptions.NoCityException;

public abstract class BaseAction implements Action {

    protected DBCalculationDao DBCalculationDao = new DBCalculationDao();

    protected SelectionController selectionController = new SelectionController();
    protected CityController cityController = new CityController();
    protected TransportController transportController = new TransportController();


    protected City createCity () {
        int id = Input.getInt("Введите id города");
        String name = Input.getString("Введите название города");
        double length = Input.getDouble("Введите широту");
        double width = Input.getDouble("Введите долготу");
        boolean hasAirport = Input.getBoolean("Введите наличие аэропорта");
        boolean hasSeaPort = Input.getBoolean("Введите наличие морского порта");
        return new City(id, name, length, width, hasAirport, hasSeaPort);
    }

    protected Transport createTransport () {
        int id = Input.getInt("Введите id транспорта");
        String name = Input.getString("Введите название транспорта");
        int speed = Input.getInt("Введите скорость транспорта");
        int seatCapacity = Input.getInt("Введите количество мест");
        int cargoCapacity = Input.getInt("Введите грузоподьемность");
        String type = Input.getString("Введите тип транспорта");
        int pricePerKM = Input.getInt("Введите цену за километр");
        return new Transport(id, name, speed, seatCapacity, cargoCapacity, pricePerKM);
    }

    protected Selection createSelection() throws NoCityException {
        City cityFrom = searchCityFrom();
        City cityTo = searchCityTo();
        int passengers = Input.getInt("Введите количество пассажиров");
        int cargo = Input.getInt("Введите количество груза (тонн)");
        return new Selection(cityFrom, cityTo, passengers,cargo);
    }


    private City searchCityFrom () throws NoCityException {
        String cityFrom = Input.getString("Введите город отправления");
        for (City city : cityController.get()) {
            if (cityFrom.equalsIgnoreCase(city.getName())) {
                return city;
            }
        }
        throw new NoCityException();
    }

    private City searchCityTo () throws NoCityException {
        String cityTo = Input.getString("Введите город прибытия");
        for (City city : cityController.get()) {
            if (cityTo.equalsIgnoreCase(city.getName())) {
                return city;
            }
        }
        throw new NoCityException();
    }

}
