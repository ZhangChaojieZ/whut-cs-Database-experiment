package src.com.dbExperiment.dao.implDAO;

import src.com.dbExperiment.dao.DAO.scDAO;
import src.com.dbExperiment.dao.vo.SC;
import src.com.dbExperiment.dao.vo.scList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class scIDAO implements scDAO {
    private Connection conn = null;             // 数据库连接对象
    private PreparedStatement pstmt = null;     // 数据据操作对象

    public scIDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean addSc(SC sc) throws SQLException {
        boolean flag = false;        //添加成功与否标志
        String sql = "INSERT INTO sc(csNo,Sno,SCgrade,SCgradeTime) VALUES(?,?,?,?)";        // 添加选课信息
        String updatesql = "UPDATE courseschedule SET csSelNum=csSelNum+1 WHERE csNo=?";    // 更改课程已选人数信息
        String sqlCheck = "SELECT csNo FROM sc WHERE csNo like ? AND Sno=?";                // 查询该课程是否被选过
        // 判断需该课程是否已被选过
        this.pstmt = this.conn.prepareStatement(sqlCheck);
        this.pstmt.setString(1,sc.getCsNo().substring(0,8) + "_");
        this.pstmt.setString(2,sc.getSno());
        // 添加课程到选课信息表中
        if(!this.pstmt.executeQuery().next()) {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, sc.getCsNo());
            this.pstmt.setString(2, sc.getSno());
            this.pstmt.setString(3, sc.getSCgrade() + "");
            this.pstmt.setString(4, sc.getSCgradeTime());
            // 更新课程的已选人数
            if (this.pstmt.executeUpdate() > 0) {
                this.conn.commit();
                this.pstmt = this.conn.prepareStatement(updatesql);
                this.pstmt.setString(1, sc.getCsNo());
                this.pstmt.executeUpdate();
                flag = true;
            }
        }
        this.conn.commit();
        this.pstmt.close();     // 关闭pstmt连接
        this.conn.close();
        return flag;
    }

    @Override
    public List<scList> queryBySno(String sno) throws SQLException {
        List<scList> all = new ArrayList<>();
        scList tempScList = null;
        /*String sql = "SELECT courseschedule.csNo,cName,teaName,student.Sno,Sname,SCgrade,SCgradeTime" +
                "FROM courseschedule,teacher,student,course,sc" +
                "WHERE courseschedule.cNo=course.cNo" +
                "AND course.teaNo=teacher.teaNo" +
                "AND courseschedule.csNo=sc.csNo" +
                "AND sc.Sno=student.Sno";*/
        String sql = "SELECT csNo,cName,teaName,Sno,Sname,SCgrade,SCgradeTime FROM sc_view WHERE Sno=?";

        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,sno);
        ResultSet rs = this.pstmt.executeQuery();

        while (rs.next()) {
            tempScList.setCsNo(rs.getString(1));
            tempScList.setCnmae(rs.getString(2));
            tempScList.setTeaname(rs.getString(3));
            tempScList.setSno(rs.getString(4));
            tempScList.setSname(rs.getString(5));
            tempScList.setScgrade(rs.getInt(6));
            tempScList.setScgradeTime(rs.getString(7));
            all.add(tempScList);
        }

        this.pstmt.close();     // 关闭pstmt连接
        this.conn.close();
        return all;
    }

    @Override
    public List<scList> queryByteaNo(String teano) throws SQLException {
        List<scList> all = new ArrayList<>();
        scList tempScList = null;
        /*String sql = "SELECT courseschedule.csNo,cName,teaName,student.Sno,Sname,SCgrade,SCgradeTime" +
                "FROM courseschedule,teacher,student,course,sc" +
                "WHERE courseschedule.cNo=course.cNo" +
                "AND course.teaNo=teacher.teaNo" +
                "AND courseschedule.csNo=sc.csNo" +
                "AND sc.Sno=student.Sno";*/
        String sql = "SELECT csNo,cName,teaName,Sno,Sname,SCgrade,SCgradeTime FROM sc_view WHERE teaNo=?";

        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,teano);
        ResultSet rs = this.pstmt.executeQuery();

        while (rs.next()) {
            tempScList.setCsNo(rs.getString(1));
            tempScList.setCnmae(rs.getString(2));
            tempScList.setTeaname(rs.getString(3));
            tempScList.setSno(rs.getString(4));
            tempScList.setSname(rs.getString(5));
            tempScList.setScgrade(rs.getInt(6));
            tempScList.setScgradeTime(rs.getString(7));
            all.add(tempScList);
        }

        this.conn.commit();
        this.pstmt.close();     // 关闭pstmt连接
        this.conn.close();
        return all;
    }

    @Override
    public List<scList> queryAll() throws SQLException {
        List<scList> all = new ArrayList<>();
        scList tempScList = null;
        /*String sql = "SELECT courseschedule.csNo,cName,teaName,student.Sno,Sname,SCgrade,SCgradeTime" +
                "FROM courseschedule,teacher,student,course,sc" +
                "WHERE courseschedule.cNo=course.cNo" +
                "AND course.teaNo=teacher.teaNo" +
                "AND courseschedule.csNo=sc.csNo" +
                "AND sc.Sno=student.Sno";*/
        String sql = "SELECT csNo,cName,teaName,Sno,Sname,SCgrade,SCgradeTime FROM sc_view";

        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();

        while (rs.next()) {
            tempScList = new scList();
            tempScList.setCsNo(rs.getString(1));
            tempScList.setCnmae(rs.getString(2));
            tempScList.setTeaname(rs.getString(3));
            tempScList.setSno(rs.getString(4));
            tempScList.setSname(rs.getString(5));
            tempScList.setScgrade(rs.getInt(6));
            tempScList.setScgradeTime(rs.getString(7));
            all.add(tempScList);
        }

        this.conn.commit();
        this.pstmt.close();     // 关闭pstmt连接
        this.conn.close();
        return all;
    }

    @Override
    public boolean delete(String csno, String sno) throws SQLException {
        boolean flag = false;
        String sql = "DELETE FROM sc WHERE csNo=? AND Sno=?";
        String upsql = "UPDATE courseschedule SET csSelNum=csSelNum-1 WHERE csNo=?";

        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,csno);
        this.pstmt.setString(2,sno);
        if(this.pstmt.executeUpdate() > 0) {
            this.pstmt = this.conn.prepareStatement(upsql);
            this.pstmt.setString(1,csno);
            this.pstmt.executeUpdate();
            flag = true;
        }

        this.conn.commit();
        this.pstmt.close();     // 关闭pstmt连接
        this.conn.close();
        return flag;
    }

    @Override
    public boolean updateGrade(String csNo, String Sno, String strtime, int score) throws SQLException {
        boolean flag = true;        //添加成功与否标志
        String sql = "UPDATE sc SET SCgrade=?,SCgradeTime=? WHERE Sno=? AND csNo=?";
        // 执行sql语句
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,score);
        this.pstmt.setString(2,strtime);
        this.pstmt.setString(3,csNo);
        this.pstmt.setString(4,Sno);

        if(this.pstmt.executeUpdate() > 0) {
            flag = true;
        }

        this.conn.commit();
        this.pstmt.close();     // 关闭pstmt连接
        this.conn.close();
        return flag;
    }

}
