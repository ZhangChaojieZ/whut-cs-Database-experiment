package src.com.dbExperiment.dao.vo;

// 选课学生名单，老师查看
public class stuSelList {
    private String csNo;            // 课程安排编号
    private String cnmae;           // 课程名称
    private String teaname;         // 教学老师姓名
    private String sname;           // 选课学生姓名
    private String sno;             // 学号

    public String getCsNo() {
        return csNo;
    }

    public void setCsNo(String csNo) {
        this.csNo = csNo;
    }

    public String getCnmae() {
        return cnmae;
    }

    public void setCnmae(String cnmae) {
        this.cnmae = cnmae;
    }

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}
