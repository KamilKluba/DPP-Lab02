package main;

import data.Account;
import data.Product;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface InterfaceServer extends Remote {
    boolean addAccount(Account account) throws RemoteException;
    boolean addProduct(Product product) throws RemoteException;
    boolean orderProduct(int productID) throws RemoteException;
    List<Account> getListAccounts() throws RemoteException;
    List<Product> getListProducts() throws RemoteException;
}