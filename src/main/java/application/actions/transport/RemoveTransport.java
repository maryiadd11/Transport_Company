package application.actions.transport;

import application.actions.Action;
import application.actions.BaseAction;
import application.exceptions.StopApp;
import application.utils.Input;


public class RemoveTransport extends BaseAction implements Action {

    @Override
    public String getName() {
        return "Удалить транспорт";
    }

    @Override
    public void action() throws StopApp {
        int id = Input.getInt("Введите id транспорта для удаления");
        transportController.remove(id);
    }
}
