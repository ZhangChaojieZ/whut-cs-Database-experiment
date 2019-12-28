package src.com.dbExperiment.dao.DAO;

import src.com.dbExperiment.dao.vo.User;

import java.sql.SQLException;

public interface userDAO {
    public boolean getLogin(User user, String role) throws SQLException;
    public Boolean scStstusSwitch(String sta) throws SQLException;
    public Boolean IsSelCourse() throws SQLException;
}
