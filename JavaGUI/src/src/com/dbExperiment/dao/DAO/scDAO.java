package src.com.dbExperiment.dao.DAO;

import src.com.dbExperiment.dao.vo.SC;
import src.com.dbExperiment.dao.vo.scList;

import java.sql.SQLException;
import java.util.List;

public interface scDAO {
    public boolean addSc(SC newSC) throws SQLException;                         // 添加新的选课信息
    public List<scList> queryBySno(String sno) throws SQLException;             // 根据学号查询已选课程信息，用于学生查看已选课程
    public List<scList> queryByteaNo(String teano) throws SQLException;         // 根据教师号查询已选课程信息，用于老师查看选课学生名单
    public List<scList> queryAll() throws SQLException;                         // 查询所有询课信息列表，以scList存储显示
    public boolean delete(String csno,String sno) throws SQLException;          // 删除选课信息
    public boolean updateGrade(String csNo,String Sno,String strtime,int score) throws SQLException;// 更新分数
}