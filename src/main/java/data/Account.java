package data;

public class Account {
    private int id;
    private String login;
    private String password;
    private int accountType;

    public Account(int id, String login, String password, int accountType) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.accountType = accountType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public String toString(){
        return id + " " + login;
    }
}
