package application.actions.city;

import application.actions.Action;
import application.actions.BaseAction;
import application.exceptions.StopApp;
import entity.City;
import java.util.List;

public class ShowCities extends BaseAction implements Action {

    @Override
    public String getName() {
        return "Вывести список городов";
    }

    @Override
    public void action() throws StopApp {
        List <City> cities = cityController.get();
        System.out.println(".................................");
        for (City city : cities) {
            System.out.println(city);
        }
        System.out.println(".................................");
    }
}
