package application.actions;

import application.exceptions.StopApp;

public interface Action {

    String getName ();
    void action () throws StopApp;
}
