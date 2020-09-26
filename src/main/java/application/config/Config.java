package application.config;

import application.actions.Action;
import application.actions.SelectTransport;
import application.actions.Stop;
import application.actions.city.AddCity;
import application.actions.city.EditCity;
import application.actions.city.RemoveCity;
import application.actions.city.ShowCities;
import application.actions.transport.AddTransport;
import application.actions.transport.EditTransport;
import application.actions.transport.RemoveTransport;
import application.actions.transport.ShowTransport;

import java.util.HashMap;
import java.util.Map;

public class Config {

    public static Map<Integer, Action> actions = new HashMap<Integer, Action>();

    static {
        actions.put(1, new AddCity());
        actions.put(2, new ShowCities());
        actions.put(3, new EditCity());
        actions.put(4, new RemoveCity());

        actions.put(5, new AddTransport());
        actions.put(6, new ShowTransport());
        actions.put(7, new EditTransport());
        actions.put(8, new RemoveTransport());

        actions.put(9, new SelectTransport());
        actions.put(0, new Stop());
    }

}
