package src.com.dbExperiment.dao.proxy;

import src.com.dbExperiment.dao.DAO.courseDAO;
import src.com.dbExperiment.dao.dbConnection.DBConnection;
import src.com.dbExperiment.dao.implDAO.courseIDAO;
import src.com.dbExperiment.dao.vo.Course;

import java.sql.SQLException;
import java.util.List;

public class courseDAOproxy implements courseDAO {
    private DBConnection db = null;
    private courseDAO dao = null;

    public courseDAOproxy() {
        this.db = new DBConnection();
        this.dao = new courseIDAO(db.getConnection());
    }

    @Override
    public boolean addCourse(Course couurse) {
        boolean flag = false;
        try {
            flag = this.dao.addCourse(couurse);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean updateCourseStatus(String sno, String status) {
        boolean flag = false;
        try {
            flag = this.dao.updateCourseStatus(sno, status);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public List<Course> quaryAllStatue(String status) {
        List<Course> all = null;
        try{
            all = this.dao.quaryAllStatue(status);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    @Override
    public List<Course> quaryAll() {
        List<Course> all = null;
        try{
            all = this.dao.quaryAll();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    @Override
    public Course quaryByCno(String Cno) {
        Course cour = new Course();
        try {
            cour = this.dao.quaryByCno(Cno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cour;
    }

    @Override
    public List<Course> quaryByCollno(String collno) throws SQLException {
        List<Course> all = null;
        try{
            all = this.dao.quaryByCollno(collno);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }
}
