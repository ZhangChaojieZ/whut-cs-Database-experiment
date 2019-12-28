package src.com.dbExperiment.dao.factory;

import src.com.dbExperiment.dao.DAO.csDAO;
import src.com.dbExperiment.dao.proxy.csDAOproxy;

public class csDAOfactory {
    public static csDAO getcsDAOInstance() {
        return new csDAOproxy();
    }
}
