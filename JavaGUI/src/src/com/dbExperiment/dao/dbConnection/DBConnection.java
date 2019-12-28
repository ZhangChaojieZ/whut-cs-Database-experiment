package src.com.dbExperiment.dao.dbConnection;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
    // 建立一个连接池对象
    public static DataSource datasource;

    //Connection dbcpConnection = null;

    private static Properties properties = new Properties();

    // 加载JDBC配置文件
    static{
        try{
            FileInputStream inFile = new FileInputStream("config/dbcp");
            properties.load(inFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            datasource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 从池中获得一个数据库连接
    public Connection getConnection() {
        Connection dbcpConnection = null;
        try {
            dbcpConnection = datasource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            dbcpConnection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbcpConnection;
    }

    // 释放掉一个连接
    public void closeAll(ResultSet rs, Statement stmt,Connection conn) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 测试连接
    /*public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        String sql = "select collNo from college";
        try {
            Statement stm = conn.createStatement();
            ResultSet ret = stm.executeQuery(sql);
            while (ret.next()) {
                String str = ret.getString("collNo");
                System.out.println(str);
            }
            conn.closeAll(ret,stm,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
