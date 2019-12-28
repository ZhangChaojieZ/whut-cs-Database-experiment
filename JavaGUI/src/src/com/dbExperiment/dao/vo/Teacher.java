package src.com.dbExperiment.dao.vo;

public class Teacher implements userInter {
    private String tno;         // 账号
    private String tname;       // 姓名
    private String tpassword;   // 密码
    private String trole;       // 角色

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    public String getTrole() {
        return trole;
    }

    public void setTrole(String trole) {
        this.trole = trole;
    }

    @Override
    public boolean getlogin() {
        return false;
    }
}
