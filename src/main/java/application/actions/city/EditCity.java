package application.actions.city;

import application.actions.Action;
import application.actions.BaseAction;
import application.exceptions.StopApp;
import entity.City;

public class EditCity extends BaseAction implements Action {


    @Override
    public String getName() {
        return "Редактировать город";
    }

    @Override
    public void action() throws StopApp {
        City city = createCity();
        cityController.update(city);
    }
}
