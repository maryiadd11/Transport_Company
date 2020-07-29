package application.actions.transport;

import application.actions.Action;
import application.actions.BaseAction;
import application.exceptions.StopApp;
import entity.Transport;

public class AddTransport extends BaseAction implements Action {

    @Override
    public String getName() {
        return "Добавить транспорт";
    }

    @Override
    public void action() throws StopApp {
        Transport transport = createTransport();
        transportController.add(transport);
    }

}
