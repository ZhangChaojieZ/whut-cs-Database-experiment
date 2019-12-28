package src.com.dbExperiment.dao.vo;

public class SC {
    private String csNo;            // 课程安排编号
    private String sno;             // 学号
    private int SCgrade;            // 成绩
    private String SCgradeTime;     // 成绩时间

    public String getCsNo() {
        return csNo;
    }

    public String getSno() {
        return sno;
    }

    public int getSCgrade() {
        return SCgrade;
    }

    public String getSCgradeTime() {
        return SCgradeTime;
    }

    public void setCsNo(String csNo) {
        this.csNo = csNo;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public void setSCgrade(int SCgrade) {
        this.SCgrade = SCgrade;
    }

    public void setSCgradeTime(String SCgradeTime) {
        this.SCgradeTime = SCgradeTime;
    }
}
