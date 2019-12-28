package src.com.dbExperiment.dao.vo;

public class CourseSchedule {
    private String csno;        // 课程安排编号
    private String cscapacity;  // 课程容量
    private String csselnum;    // 已选人数
    private String csweeks;     // 上课周数
    private String csweek;      // 上课周次
    private String csday;       // 上课天次
    private String csclass;     // 上课课次
    private String csadress;    // 上课地点
    private String cno;         // 课程号


    public String getCsno() {
        return csno;
    }

    public void setCsno(String csno) {
        this.csno = csno;
    }

    public String getCscapacity() {
        return cscapacity;
    }

    public void setCscapacity(String cscapacity) {
        this.cscapacity = cscapacity;
    }

    public String getCsselnum() {
        return csselnum;
    }

    public void setCsselnum(String csselnum) {
        this.csselnum = csselnum;
    }

    public String getCsweeks() {
        return csweeks;
    }

    public void setCsweeks(String csweeks) {
        this.csweeks = csweeks;
    }

    public String getCsweek() {
        return csweek;
    }

    public void setCsweek(String csweek) {
        this.csweek = csweek;
    }

    public String getCsday() {
        return csday;
    }

    public void setCsday(String csday) {
        this.csday = csday;
    }

    public String getCsclass() {
        return csclass;
    }

    public void setCsclass(String csclass) {
        this.csclass = csclass;
    }

    public String getCsadress() {
        return csadress;
    }

    public void setCsadress(String csadress) {
        this.csadress = csadress;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }
}
