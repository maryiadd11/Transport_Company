package dao.transport;

import entity.Transport;

import java.util.List;

public interface TransportDao  {

    void add (Transport transport);
    List <Transport> get ();
    void remove (Transport transport);
    void update (Transport transport);

}
