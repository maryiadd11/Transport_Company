package application.actions.city;

import application.actions.Action;
import application.actions.BaseAction;
import application.exceptions.StopApp;
import entity.City;
import exceptions.DuplicateCityException;

public class AddCity extends BaseAction implements Action {

    @Override
    public String getName() {
        return "Добавить город";
    }

    @Override
    public void action() throws StopApp {
        City city = createCity();
        try {
            cityController.add(city);
        } catch (DuplicateCityException e) {
            System.out.println(e.getMessage());
        }
    }
}
