package src.com.dbExperiment.dao.DAO;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import src.com.dbExperiment.dao.vo.Course;

import java.sql.SQLException;
import java.util.List;

public interface courseDAO {
    public boolean addCourse(Course couurse) throws SQLException;                          // 添加新的课程（老师申请开课）
    public boolean updateCourseStatus(String cno, String status) throws SQLException;      // 更新课程状态
    public List<Course> quaryAllStatue(String status) throws SQLException;                 // 查询待审核的课程
    public List<Course> quaryAll() throws SQLException;
    public Course quaryByCno(String Cno) throws SQLException;
    public List<Course> quaryByCollno(String collno) throws SQLException;

}