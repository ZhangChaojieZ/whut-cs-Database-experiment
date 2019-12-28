package src.com.dbExperiment.dao.factory;
import src.com.dbExperiment.dao.DAO.*;
import src.com.dbExperiment.dao.proxy.userDAOproxy;

public class userDAOfactory {
    public static userDAO getuserDAOInstance() {
        return new userDAOproxy();
    }
}
