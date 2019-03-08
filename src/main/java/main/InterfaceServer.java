package main;

import data.Account;
import data.Product;
import javafx.collections.ObservableList;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface InterfaceServer extends Remote {
    boolean addAccount(Account account) throws RemoteException;
    boolean removeAccount(Account account) throws RemoteException;
    boolean addProduct(Product product) throws RemoteException;
    boolean removeProduct(Product product) throws RemoteException;
    boolean orderProduct(int productID) throws RemoteException;
    ObservableList<Account> getListAccounts() throws RemoteException;
    ObservableList<Product> getListProducts() throws RemoteException;
    int test() throws RemoteException;
}