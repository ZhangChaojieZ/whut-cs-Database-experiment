package src.com.dbExperiment.dao.proxy;

import src.com.dbExperiment.dao.DAO.scDAO;
import src.com.dbExperiment.dao.dbConnection.DBConnection;
import src.com.dbExperiment.dao.implDAO.scIDAO;
import src.com.dbExperiment.dao.implDAO.userIDAO;
import src.com.dbExperiment.dao.vo.SC;
import src.com.dbExperiment.dao.vo.scList;

import java.sql.SQLException;
import java.util.List;

public class scDAOproxy implements scDAO {
    private DBConnection db = null;
    private scDAO dao = null;

    public scDAOproxy() {
        this.db = new DBConnection();
        this.dao = new scIDAO(db.getConnection());
    }

    @Override
    public boolean addSc(SC newSC) {
        boolean flag = false;
        try {
            flag = this.dao.addSc(newSC);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public List<scList> queryBySno(String sno) {
        List<scList> all = null;
        try {
            all = this.dao.queryBySno(sno);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return all;
    }

    @Override
    public List<scList> queryByteaNo(String teano) {
        List<scList> all = null;
        try {
            all = this.dao.queryByteaNo(teano);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return all;
    }

    @Override
    public List<scList> queryAll() {
        List<scList> all = null;
        try {
            all = this.dao.queryAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return all;
    }

    @Override
    public boolean delete(String csno, String sno) throws SQLException {
        boolean flag = false;
        try {
            flag = this.dao.delete(csno, sno);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean updateGrade(String csNo, String Sno, String strtime, int score) throws SQLException {
        boolean flag = false;
        try {
            flag = this.dao.updateGrade(csNo,Sno,strtime,score);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }
}
