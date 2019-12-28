package src.com.dbExperiment.dao.implDAO;

import src.com.dbExperiment.dao.DAO.userDAO;
import src.com.dbExperiment.dao.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;


public class userIDAO implements userDAO {
    private Connection conn = null;             // 数据库连接对象
    private PreparedStatement pstmt = null;     // 数据据操作对象

    public userIDAO(Connection conn) {
        this.conn = conn;
    }
    @Override
    public boolean getLogin(User user, String role){
        boolean flag = false;       // 登录标志
        String sql;// = "SELECT Sname FROM student WHERE Sno=? AND Spassword=?";   // 默认为学生
        ResultSet rs;
    try {
        if (role.equals("学生")) {
            sql = "SELECT Sname,Syear,classNo FROM student WHERE Sno=? AND Spassword=?";
            // 执行sql语句
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, user.getNo());
            this.pstmt.setString(2, user.getPassword());
            rs = this.pstmt.executeQuery();
            if (rs.next()) {
                user.setName(rs.getString(1));
                user.setCollno(rs.getString(3));
                // 获得学生当前所处学期,根据学生所处学期生成待选课课表
                int year = Calendar.getInstance().get(Calendar.YEAR);
                int month = Calendar.getInstance().get(Calendar.MONTH);
                int i = Integer.parseInt(rs.getString(2));
                int t = year - i;
                System.out.println(year);
                System.out.println(i);
                if (month < 8) {
                    switch (t) {
                        case 0:
                            user.setTerm("大一下");
                            break;
                        case 1:
                            user.setTerm("大二下");
                            break;
                        case 2:
                            user.setTerm("大三下");
                            break;
                        default:
                            user.setTerm("大四下");
                            break;
                    }
                } else {
                    switch (t) {
                        case 0:
                            user.setTerm("大一上");
                            break;
                        case 1:
                            user.setTerm("大二上");
                            break;
                        case 2:
                            user.setTerm("大三上");
                            break;
                        default:
                            user.setTerm("大四上");
                            break;
                    }
                }
                this.conn.commit();

                // 获得学生所处学院，用于提供选课名单
                String tempsql = "SELECT college.collNo FROM college,major,class WHERE " +
                        "class.classNo=? AND class.majorNo=major.majorNo AND major.collNo=college.collNo";
                this.pstmt = this.conn.prepareStatement(tempsql);
                this.pstmt.setString(1, user.getCollno());
                rs = this.pstmt.executeQuery();
                if (rs.next()) {
                    user.setCollno(rs.getString(1));
                    flag = true;
                }
            }
        } else if(role.equals("教师")) {
            sql = "SELECT teaName,collNo FROM teacher WHERE teaNo=? AND teaPassword=?";
            // 执行sql语句
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, user.getNo());
            this.pstmt.setString(2, user.getPassword());
            rs = this.pstmt.executeQuery();
            if (rs.next()) {
                user.setName(rs.getString(1));
                user.setCollno(rs.getString(2));
                flag = true;
            }

        } else {
            sql = "SELECT adminNo FROM adminuser WHERE adminNo=? AND adminPass=?";
            // 执行sql语句
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, user.getNo());
            this.pstmt.setString(2, user.getPassword());
            rs = this.pstmt.executeQuery();
            if (rs.next()) {
                user.setName(rs.getString(1));
                flag = true;
            }
        }


       /* // 执行sql语句
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,user.getNo());
        this.pstmt.setString(2,user.getPassword());
        ResultSet rs = this.pstmt.executeQuery();
        if(rs.next()) {
            user.setName(rs.getString(1));
            flag = true;
        }*/

        this.conn.commit();
        this.pstmt.close();     // 关闭pstmt连接
        this.conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return flag;
    }

    @Override
    public Boolean scStstusSwitch(String sta) throws SQLException {
        boolean flag = false;
        String sql = "UPDATE selcetcoursestatus set scSwitch=? WHERE ID=10001";

        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,sta);
        //ResultSet rs = this.pstmt.executeQuery();
        if(this.pstmt.execute()) {
            flag = true;
        }

        this.conn.commit();
        this.pstmt.close();     // 关闭pstmt连接
        this.conn.close();
        return flag;
    }

    @Override
    public Boolean IsSelCourse() throws SQLException {
        boolean flag = false;
        String sql = "SELECT scSwitch FROM selcetcoursestatus WHERE ID=10001";

        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();
        if(rs.next()) {
            if(rs.getString(1).equals("已开始")) {
                flag = true;
            }else {
                flag = false;
            }

        }

        this.conn.commit();
        this.pstmt.close();     // 关闭pstmt连接
        this.conn.close();
        return flag;
    }
}
