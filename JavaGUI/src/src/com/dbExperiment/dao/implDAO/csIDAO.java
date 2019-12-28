package src.com.dbExperiment.dao.implDAO;

import src.com.dbExperiment.dao.DAO.csDAO;
import src.com.dbExperiment.dao.vo.CourseSchedule;
import src.com.dbExperiment.dao.vo.csList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class csIDAO implements csDAO {
    private Connection conn = null;             // 数据库连接对象
    private PreparedStatement pstmt = null;     // 数据据操作对象

    public csIDAO(Connection conn){
        this.conn = conn;
    }

    // 根据用户填写信息，生成CourseSchedule(课程安排类)，并添加到对应表中
    @Override
    public boolean addCs(CourseSchedule cs) throws SQLException {
        boolean flag = false;
        String sql = "INSERT INTO courseschedule VALUES(?,?,?,?,?,?,?,?,?)";    // 添加课程安排到courseschedule表中

        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,cs.getCsno());
        this.pstmt.setInt(2,Integer.parseInt(cs.getCscapacity()));
        this.pstmt.setInt(3,Integer.parseInt(cs.getCsselnum()));
        this.pstmt.setString(4,cs.getCsweeks());
        this.pstmt.setString(5,cs.getCsweek());
        this.pstmt.setString(6,cs.getCsday());
        this.pstmt.setString(7,cs.getCsclass());
        this.pstmt.setString(8,cs.getCsadress());
        this.pstmt.setString(9,cs.getCno());
        if(this.pstmt.executeUpdate() > 0) {
            flag = true;
        }
        this.conn.commit();
        this.pstmt.close();     // 关闭pstmt连接
        this.conn.close();
        return flag;
    }

    @Override
    public List<csList> queryAllCs() throws SQLException {
        csList tempCslist = null;
        List<csList> all = new ArrayList<>();     // 定义集合收集数据
        String sql = "SELECT csNo,cName,teaName,csWeeks,csWeek,csDay,csClass,csAdress,csCapacity,csSelNum FROM " +
                "cslist_view";

        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();

        while(rs.next()) {
            tempCslist = new csList();
            tempCslist.setCsno(rs.getString(1));
            tempCslist.setcNmae(rs.getString(2));
            tempCslist.setTeaNmae(rs.getString(3));
            tempCslist.setCsweeks(rs.getString(5));
            tempCslist.setCsweek(rs.getString(5));
            tempCslist.setCsday(rs.getString(6));
            tempCslist.setCsclass(rs.getString(7));
            tempCslist.setCsadress(rs.getString(8));
            tempCslist.setCscapacity(String.valueOf(rs.getInt(9)));
            tempCslist.setCsselnum(String.valueOf(rs.getInt(10)));
            all.add(tempCslist);
        }

        this.conn.commit();
        this.pstmt.close();
        this.conn.close();
        return all;
    }

    @Override
    public List<csList> queryBycollNoAndCterm(String collNo, String cterm) throws SQLException {
        csList tempCslist = null;
        List<csList> all = new ArrayList<>();     // 定义集合收集数据
        String sql = "SELECT csNo,cName,teaName,csWeeks,csWeek,csDay,csClass,csAdress,csCapacity,csSelNum FROM " +
                "cslist_view WHERE cTerm=? AND collNo=?";

        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,cterm);
        this.pstmt.setString(2,collNo);
        ResultSet rs = this.pstmt.executeQuery();

        while(rs.next()) {
            tempCslist = new csList();
            tempCslist.setCsno(rs.getString(1));
            tempCslist.setcNmae(rs.getString(2));
            tempCslist.setTeaNmae(rs.getString(3));
            tempCslist.setCsweeks(rs.getString(5));
            tempCslist.setCsweek(rs.getString(5));
            tempCslist.setCsday(rs.getString(6));
            tempCslist.setCsclass(rs.getString(7));
            tempCslist.setCsadress(rs.getString(8));
            tempCslist.setCscapacity(String.valueOf(rs.getInt(9)));
            tempCslist.setCsselnum(String.valueOf(rs.getInt(10)));
            all.add(tempCslist);
        }

        this.pstmt.close();
        this.conn.close();
        return all;
    }

    @Override
    public List<csList> queryselected(String sno) throws SQLException {
        csList tempCslist = null;
        List<csList> all = new ArrayList<>();     // 定义集合收集数据
        String sql = "SELECT cslist_view.csNo,cName,teaName,csWeeks,csWeek,csDay,csClass,csAdress,csCapacity,csSelNum" +
                " FROM " +
                "cslist_view,sc WHERE cslist_view.csNo=sc.csNo AND sc.Sno=?";

        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,sno);
        ResultSet rs = this.pstmt.executeQuery();

        while(rs.next()) {
            tempCslist = new csList();
            tempCslist.setCsno(rs.getString(1));
            tempCslist.setcNmae(rs.getString(2));
            tempCslist.setTeaNmae(rs.getString(3));
            tempCslist.setCsweeks(rs.getString(4));
            tempCslist.setCsweek(rs.getString(5));
            tempCslist.setCsday(rs.getString(6));
            tempCslist.setCsclass(rs.getString(7));
            tempCslist.setCsadress(rs.getString(8));
            tempCslist.setCscapacity(String.valueOf(rs.getInt(9)));
            tempCslist.setCsselnum(String.valueOf(rs.getInt(10)));
            all.add(tempCslist);
        }

        this.conn.commit();
        this.pstmt.close();
        this.conn.close();
        return all;
    }

    @Override
    public List<csList> querycsByteaNo(String teano) throws SQLException {
        csList tempCslist = null;
        List<csList> all = new ArrayList<>();     // 定义集合收集数据
        String sql = "SELECT csNo,cName,teaName,csWeeks,csWeek,csDay,csClass,csAdress," +
                "csCapacity,csSelNum FROM teacher,course,courseschedule WHERE courseschedule.cNo=course.cNo AND " +
                "course.teaNo=teacher.teaNo AND teacher.teaNo=?";

        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,teano);
        ResultSet rs = this.pstmt.executeQuery();

        while(rs.next()) {
            tempCslist = new csList();
            tempCslist.setCsno(rs.getString(1));
            tempCslist.setcNmae(rs.getString(2));
            tempCslist.setTeaNmae(rs.getString(3));
            tempCslist.setCsweeks(rs.getString(4));
            tempCslist.setCsweek(rs.getString(5));
            tempCslist.setCsday(rs.getString(6));
            tempCslist.setCsclass(rs.getString(7));
            tempCslist.setCsadress(rs.getString(8));
            tempCslist.setCscapacity(String.valueOf(rs.getInt(9)));
            tempCslist.setCsselnum(String.valueOf(rs.getInt(10)));
            all.add(tempCslist);
        }

        this.conn.commit();
        this.pstmt.close();
        this.conn.close();
        return all;
    }


}
