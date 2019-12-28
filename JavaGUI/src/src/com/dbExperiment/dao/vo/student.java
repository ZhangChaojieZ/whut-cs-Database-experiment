package src.com.dbExperiment.dao.vo;

public class student implements userInter {
    private String sno;         // 账号
    private String sname;       // 姓名
    private String spassword;   // 密码
    private String srole;       // 角色

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public String getSrole() {
        return srole;
    }

    public void setSrole(String srole) {
        this.srole = srole;
    }

    @Override
    public boolean getlogin() {
        return false;
    }
}
