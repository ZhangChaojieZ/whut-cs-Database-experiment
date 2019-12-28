package src.com.dbExperiment.dao.factory;

import src.com.dbExperiment.dao.DAO.scDAO;
import src.com.dbExperiment.dao.proxy.scDAOproxy;

public class scDAOfactory {
    public static scDAO getscDAOInstance() {
        return new scDAOproxy();
    }
}
