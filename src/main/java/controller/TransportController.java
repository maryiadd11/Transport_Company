package controller;

import dao.transport.DBTransportDao;
import dao.transport.TransportDao;
import entity.Transport;

import java.util.List;

public class TransportController {

    private TransportDao transportDao = new DBTransportDao();

    public void add (Transport transport) {
        transportDao.add(transport);
    }

    public List <Transport> get () {
        return transportDao.get();
    }

    public void remove (int id) {
        transportDao.remove(new Transport(id));
    }

    public void update (Transport transport) {
        transportDao.update(transport);
    }
}
