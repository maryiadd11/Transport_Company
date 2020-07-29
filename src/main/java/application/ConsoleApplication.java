package application;

import application.actions.Action;
import application.config.Config;
import application.exceptions.StopApp;
import application.utils.Input;

import java.util.Map;

public class ConsoleApplication {

    public void start() {
        System.out.println("Start");
        run ();
        System.out.println("End");
    }

    private void run () {
        while (true) {
            Action action = getAction();
            try {
                action.action();
            } catch (StopApp e) {
                break;
            }
        }
    }

    private Action getAction () {
        menu();
        int number  = Input.getInt("Выберите действие");
        Action action = Config.actions.get(number);
        if (action != null) {
            return action;
        }
        System.out.println("Нет такого действия. Повторите ввод");
        return getAction();
    }

    private void menu () {
        for (Map.Entry<Integer, Action> action : Config.actions.entrySet()) {
            System.out.println (action.getKey() + " - " + action.getValue().getName());
        }
    }
}