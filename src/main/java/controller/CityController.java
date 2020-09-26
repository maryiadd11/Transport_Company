package controller;

import dao.city.CityDao;
import dao.city.DBCityDao;
import entity.City;
import exceptions.DuplicateCityException;

import java.util.List;

public class CityController {

    private CityDao cityDao = new DBCityDao();

    public void add (City city) throws DuplicateCityException {
        cityDao.add(city);
    }

    public List <City> get () {
        return cityDao.get();
    }

    public void remove (String name) {
        cityDao.remove(new City (name));
    }

    public void update (City city) {
        cityDao.update(city);
    }
}
