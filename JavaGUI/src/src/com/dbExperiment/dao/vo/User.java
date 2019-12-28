package src.com.dbExperiment.dao.vo;

public class User {
    private String no;         // 账号
    private String name;       // 姓名
    private String password;   // 密码
    private String collno;
    private String term;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCollno() {
        return collno;
    }

    public void setCollno(String collno) {
        this.collno = collno;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
