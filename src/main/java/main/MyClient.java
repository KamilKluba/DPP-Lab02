package main;

import data.Account;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MyClient extends UnicastRemoteObject implements InterfaceClient, Serializable {
    Registry reg;
    InterfaceServer remote_server;

    public MyClient() throws RemoteException{
        System.setProperty("java.security.policy", "file:./jav.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }

        try {
            reg = LocateRegistry.getRegistry();
            remote_server = (InterfaceServer) reg.lookup("Server");

            //ObservableList<Account> list = remote_server.getListAccounts();
            //System.out.println(remote_server.test());
            remote_server.addAccount(new Account(2, "kek", "kek2", 2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        try {
            new MyClient();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void metoda() throws RemoteException {

    }
}