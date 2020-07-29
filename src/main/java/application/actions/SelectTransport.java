package application.actions;

import application.exceptions.StopApp;
import entity.Selection;
import exceptions.NoCityException;

public class SelectTransport extends BaseAction implements Action {

    public String getName() {
        return "Подобрать транспорт";
    }

    public void action() throws StopApp {
        try {
            Selection selection = createSelection();
            selectionController.selectTransport(selection);
        } catch (NoCityException e) {
            System.out.println(e.message());
        }
    }

}
