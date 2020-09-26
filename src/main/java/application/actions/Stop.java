package application.actions;

import application.exceptions.StopApp;

public class Stop implements Action{

    public String getName() {
        return "Выйти";
    }

    public void action() throws StopApp {
        throw new StopApp();
    }
}
