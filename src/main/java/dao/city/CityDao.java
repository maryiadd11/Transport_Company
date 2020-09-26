package dao.city;

import entity.City;
import exceptions.DuplicateCityException;

import java.util.List;

public interface CityDao {

    void add (City city) throws DuplicateCityException;
    List <City> get ();
    void remove (City city);
    void update (City city);

}
