package controller;

import dao.DBCalculationDao;
import entity.Selection;

public class SelectionController {

    private DBCalculationDao calculationDao = new DBCalculationDao();


    public void selectTransport (Selection selection) {
        calculationDao.selectTransport(selection);
    }

}
