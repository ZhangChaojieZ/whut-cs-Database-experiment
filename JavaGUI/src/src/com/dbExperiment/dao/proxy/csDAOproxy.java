package src.com.dbExperiment.dao.proxy;

import src.com.dbExperiment.dao.DAO.csDAO;
import src.com.dbExperiment.dao.dbConnection.DBConnection;
import src.com.dbExperiment.dao.implDAO.csIDAO;
import src.com.dbExperiment.dao.vo.CourseSchedule;
import src.com.dbExperiment.dao.vo.csList;

import java.sql.SQLException;
import java.util.List;

public class csDAOproxy implements csDAO {
    private DBConnection db = null;
    private csDAO dao = null;

    public csDAOproxy() {
        this.db = new DBConnection();
        this.dao = new csIDAO(db.getConnection());
    }

    @Override
    public boolean addCs(CourseSchedule cs) {
        boolean flag = false;
        try {
            flag = this.dao.addCs(cs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public List<csList> queryAllCs() {
        List<csList> all = null;
        try{
            all = this.dao.queryAllCs();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    @Override
    public List<csList> queryBycollNoAndCterm(String collNo, String cterm) throws SQLException {
        List<csList> all = null;
        try{
            all = this.dao.queryBycollNoAndCterm(collNo,cterm);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    @Override
    public List<csList> queryselected(String sno) throws SQLException {
        List<csList> all = null;
        try{
            all = this.dao.queryselected(sno);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    @Override
    public List<csList> querycsByteaNo(String teano) throws SQLException {
        List<csList> all = null;
        try{
            all = this.dao.querycsByteaNo(teano);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }
}
