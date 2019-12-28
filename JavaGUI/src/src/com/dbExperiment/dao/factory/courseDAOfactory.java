package src.com.dbExperiment.dao.factory;

import src.com.dbExperiment.dao.DAO.courseDAO;
import src.com.dbExperiment.dao.proxy.courseDAOproxy;

public class courseDAOfactory {
    public static courseDAO getcourseDAOInstance() {
        return new courseDAOproxy();
    }
}
