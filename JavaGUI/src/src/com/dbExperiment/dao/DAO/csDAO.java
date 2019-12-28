package src.com.dbExperiment.dao.DAO;

import src.com.dbExperiment.dao.vo.CourseSchedule;
import src.com.dbExperiment.dao.vo.csList;

import java.sql.SQLException;
import java.util.List;

public interface csDAO {
    public boolean addCs(CourseSchedule cs) throws SQLException;            // 添加课程安排
    public List<csList> queryAllCs() throws SQLException;                   // 查询课程安排列表
    public List<csList> queryBycollNoAndCterm(String collNo,String cterm) throws SQLException;
    public List<csList> queryselected(String sno) throws SQLException;
    public List<csList> querycsByteaNo(String teano) throws SQLException;
}
