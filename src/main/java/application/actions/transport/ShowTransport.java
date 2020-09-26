package application.actions.transport;

import application.actions.Action;
import application.actions.BaseAction;
import application.exceptions.StopApp;
import entity.Transport;

import java.util.List;

public class ShowTransport extends BaseAction implements Action {

    @Override
    public String getName() {
        return "Показать весь список транспорта";
    }

    @Override
    public void action() throws StopApp {
        List <Transport> transports = transportController.get();
        System.out.println("........................");
        for (Transport transport : transports) {
            System.out.println(transport);
        }
        System.out.println("........................");
    }
}
