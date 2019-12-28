package src.com.dbExperiment.dao.vo;

public class Adminstrator implements userInter {
    private String mno;         // 账号
    private String mname;       // 姓名
    private String mpassword;   // 密码
    private String mrole;       // 角色

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }

    public String getMrole() {
        return mrole;
    }

    public void setMrole(String mrole) {
        this.mrole = mrole;
    }

    @Override
    public boolean getlogin() {
        return false;
    }
}
