package main;

import data.Account;
import data.Product;
import javafx.collections.ObservableList;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface InterfaceServer extends Remote {
    boolean addAccount(Object account) throws RemoteException;
    boolean removeAccount(Object account) throws RemoteException;
    boolean addProduct(Object product) throws RemoteException;
    boolean removeProduct(Object product) throws RemoteException;
    boolean orderProduct(int productID) throws RemoteException;
    ObservableList<Object> getListAccounts() throws RemoteException;
    ObservableList<Object> getListProducts() throws RemoteException;
    int test() throws RemoteException;
}