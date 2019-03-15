package data;

import javafx.collections.ObservableList;
import main.InterfaceServer;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Account implements InterfaceAccount, Serializable {
    Registry reg;
    InterfaceServer remote_server;

    private int id;
    private String login;
    private String password;
    private int accountType;

    public Account(int id, String login, String password, int accountType) {
        System.setProperty("java.security.policy", "file:./jav.policy");
        this.id = id;
        this.login = login;
        this.password = password;
        this.accountType = accountType;

        try {
            reg = LocateRegistry.getRegistry("192.168.1.6", 1099);
            remote_server = (InterfaceServer) reg.lookup("Server");

            InterfaceAccount ic = (InterfaceAccount) UnicastRemoteObject.exportObject(this, 0);
            remote_server.addAccount(ic);
            //ObservableList list = remote_server.getListAccounts();

            System.out.println("Udało sie");
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    public String toStrin() throws RemoteException{
        return id + " " + login;
    }

    public static void main(String[] args){
        new Account(2, "kek1", "kek2", 2);
    }
}