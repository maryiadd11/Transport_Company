package application.actions.city;

import application.actions.Action;
import application.actions.BaseAction;
import application.exceptions.StopApp;
import application.utils.Input;

public class RemoveCity extends BaseAction implements Action {

    @Override
    public String getName() {
        return "Удалить город";
    }

    @Override
    public void action() throws StopApp {
        String name = Input.getString("Введите название города");
        cityController.remove(name);
    }
}
