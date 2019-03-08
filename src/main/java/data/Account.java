package data;

public class Account {
    private int id;
    private String login;
    private String password;
    private int accountType;

    public Account(String login, String password, int accountType) {
        this.login = login;
        this.password = password;
        this.accountType = accountType;
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
}
