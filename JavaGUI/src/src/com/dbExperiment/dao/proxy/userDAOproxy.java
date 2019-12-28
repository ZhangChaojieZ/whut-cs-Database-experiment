package src.com.dbExperiment.dao.proxy;

import src.com.dbExperiment.dao.DAO.userDAO;
import src.com.dbExperiment.dao.dbConnection.DBConnection;
import src.com.dbExperiment.dao.implDAO.userIDAO;
import src.com.dbExperiment.dao.vo.User;

import java.sql.SQLException;

public class userDAOproxy implements userDAO {
    private DBConnection db = null;
    private userDAO dao = null;

    public userDAOproxy() {
        this.db = new DBConnection();
        this.dao = new userIDAO(db.getConnection());
    }
    @Override
    public boolean getLogin(User user, String role) {
        boolean flag = false;
        try {
            flag = this.dao.getLogin(user,role);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public Boolean scStstusSwitch(String sta) throws SQLException {
        boolean flag = false;
        try {
            flag = this.dao.scStstusSwitch(sta);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public Boolean IsSelCourse() throws SQLException {
        boolean flag = false;
        try {
            flag = this.dao.IsSelCourse();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

}
