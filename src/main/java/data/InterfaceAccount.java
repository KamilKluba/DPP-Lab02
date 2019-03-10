package data;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceAccount extends Remote {
    public String toStrin() throws RemoteException;
    public int getId() throws RemoteException;
    public void setId(int id) throws RemoteException;
    public String getLogin() throws RemoteException;
    public void setLogin(String login) throws RemoteException;
    public String getPassword() throws RemoteException;
    public void setPassword(String password) throws RemoteException;
    public int getAccountType() throws RemoteException;
    public void setAccountType(int accountType) throws RemoteException;
}