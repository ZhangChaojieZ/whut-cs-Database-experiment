package src.com.dbExperiment.dao.implDAO;

import src.com.dbExperiment.dao.DAO.courseDAO;
import src.com.dbExperiment.dao.vo.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class courseIDAO implements courseDAO {
    private Connection conn = null;             // 数据库连接对象
    private PreparedStatement pstmt = null;     // 数据据操作对象

    public courseIDAO(Connection conn){
        this.conn = conn;
    }

    // 根据教师填写的课程信息生成Course(课程类)，添加到course表中
    @Override
    public boolean addCourse(Course course) throws SQLException {
        boolean flag = false;
        String sql = "INSERT INTO course(cNo,cName,cNature,cStatus,cCredit,cHour,cTerm,teaNo,collNo)" +
                " VALUES(?,?,?,?,?,?,?,?,?)";

        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,course.getCno());
        this.pstmt.setString(2,course.getCname());
        this.pstmt.setString(3,course.getCnature());
        this.pstmt.setString(4,course.getCstatus());
        this.pstmt.setFloat(5,Float.parseFloat(course.getCcredit()));
        this.pstmt.setInt(6,Integer.parseInt(course.getChour()));
        this.pstmt.setString(7,course.getCterm());
        this.pstmt.setString(8,course.getTeano());
        this.pstmt.setString(9,course.getCollno());

        if(this.pstmt.executeUpdate() > 0) {
            flag = true;
        }
        this.conn.commit();
        this.pstmt.close();     // 关闭pstmt连接
        this.conn.close();
        return flag;
    }

    @Override
    public boolean updateCourseStatus(String cno, String status) throws SQLException {
        boolean flag = false;
        String sql = "UPDATE course SET cStatus=? WHERE cNo=?";

        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,status);
        this.pstmt.setString(2,cno);

        if(this.pstmt.executeUpdate() > 0) {
            flag = true;
        }

        this.conn.commit();
        this.pstmt.close();     // 关闭pstmt连接
        this.conn.close();
        return flag;
    }

    @Override
    public List<Course> quaryAllStatue(String status) throws SQLException {
        Course course = null;
        List<Course> allStatus = new ArrayList<>();     // 定义集合收集数据
        String sql = "SELECT cNo,cName,cNature,cStatus,cCredit,cHour,cTerm,teaNo,collNo FROM course WHERE cStatus=?";

        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,status);
        ResultSet rs = this.pstmt.executeQuery();

        while(rs.next()) {
            course = new Course();
            course.setCno(rs.getString(1));
            course.setCname(rs.getString(2));
            course.setCnature(rs.getString(3));
            course.setCstatus(rs.getString(4));
            course.setCcredit(rs.getString(5));
            course.setChour(rs.getString(6));
            course.setCterm(rs.getString(7));
            course.setTeano(rs.getString(8));
            course.setCollno(rs.getString(9));
            allStatus.add(course);
        }

        this.conn.commit();
        this.pstmt.close();
        this.conn.close();
        return allStatus;
    }

    @Override
    public List<Course> quaryAll() throws SQLException {
        Course course = null;
        List<Course> all = new ArrayList<>();     // 定义集合收集数据
        String sql = "SELECT cNo,cName,cNature,cStatus,cCredit,cHour,cTerm,teaNo,collNo FROM course";

        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();

        while(rs.next()) {
            course = new Course();
            course.setCno(rs.getString(1));
            course.setCname(rs.getString(2));
            course.setCnature(rs.getString(3));
            course.setCstatus(rs.getString(4));
            course.setCcredit(rs.getString(5));
            course.setChour(rs.getString(6));
            course.setCterm(rs.getString(7));
            course.setTeano(rs.getString(8));
            course.setCollno(rs.getString(9));
            all.add(course);
        }

        this.conn.commit();
        this.pstmt.close();
        this.conn.close();
        return all;
    }

    @Override
    public Course quaryByCno(String Cno) throws SQLException {
        Course course = null;
        String sql = "SELECT cNo,cName,cNature,cStatus,cCredit,cHour,cTerm,teaNo,collNo FROM course WHERE cNo=?";

        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,Cno);
        ResultSet rs = this.pstmt.executeQuery();

        course = new Course();
        course.setCno(rs.getString(1));
        course.setCname(rs.getString(2));
        course.setCnature(rs.getString(3));
        course.setCstatus(rs.getString(4));
        course.setCcredit(rs.getString(5));
        course.setChour(rs.getString(6));
        course.setCterm(rs.getString(7));
        course.setTeano(rs.getString(8));
        course.setCollno(rs.getString(9));

        this.conn.commit();
        this.pstmt.close();
        this.conn.close();
        return course;
    }

    @Override
    public List<Course> quaryByCollno(String collno) throws SQLException {
        Course course = null;
        List<Course> all = new ArrayList<>();     // 定义集合收集数据
        String sql = "SELECT cNo,cName,cNature,cStatus,cCredit,cHour,cTerm,teaNo,collNo FROM course WHERE collNo=?";

        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,collno);
        ResultSet rs = this.pstmt.executeQuery();

        while(rs.next()) {
            course = new Course();
            course.setCno(rs.getString(1));
            course.setCname(rs.getString(2));
            course.setCnature(rs.getString(3));
            course.setCstatus(rs.getString(4));
            course.setCcredit(rs.getString(5));
            course.setChour(rs.getString(6));
            course.setCterm(rs.getString(7));
            course.setTeano(rs.getString(8));
            course.setCollno(rs.getString(9));
            all.add(course);
        }

        this.conn.commit();
        this.pstmt.close();
        this.conn.close();
        return all;
    }

}
