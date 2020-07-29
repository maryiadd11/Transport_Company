package application.actions.transport;

import application.actions.Action;
import application.actions.BaseAction;
import application.exceptions.StopApp;
import entity.Transport;

public class EditTransport extends BaseAction implements Action {

    @Override
    public String getName() {
        return "Редактировать транспорт";
    }

    @Override
    public void action() throws StopApp {
        Transport transport = createTransport();
        transportController.update(transport);
    }
}
