package main;

import data.Account;
import data.Product;

import javax.swing.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;

public class Server extends UnicastRemoteObject implements InterfaceServer {
    JLabel label = new JLabel();
    private int port;
    private Registry registry;
    private ArrayList<Account> arrayListAccounts;
    private ArrayList<Product> arrayListProduct;

    public Server() throws RemoteException {
        super();
        System.setProperty("java.security.policy", "file:./jav.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            setPort(1099);
            setRegistry(LocateRegistry.createRegistry(getPort()));
            getRegistry().rebind("Server", this);

            System.out.println("MyInterfaceImpl ok");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TE LISTY BĘDZIE TRZEBA POBIERAC Z BAZY
        arrayListAccounts = new ArrayList<Account>();
        arrayListProduct = new ArrayList<Product>();
    }

    public boolean addAccount(Account account) throws RemoteException {
        try {
            arrayListAccounts.add(account);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addProduct(Product product) throws RemoteException {
        try {
            arrayListProduct.add(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean orderProduct(int productID) throws RemoteException {
        for (Product p : arrayListProduct)
            if (p.getId() == productID)
                return p.decreaseQuantity();
        return false;
    }

    public List<Account> getListAccounts() throws RemoteException {
        return arrayListAccounts;
    }

    public List<Product> getListProducts() throws RemoteException {
        return arrayListProduct;
    }

    public int metoda(int arg) {
        return arg * 10;
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Registry getRegistry() {
        return registry;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }

    public ArrayList<Account> getArrayListAccounts() {
        return arrayListAccounts;
    }

    public void setArrayListAccounts(ArrayList<Account> arrayListAccounts) {
        this.arrayListAccounts = arrayListAccounts;
    }

    public ArrayList<Product> getArrayListProduct() {
        return arrayListProduct;
    }

    public void setArrayListProduct(ArrayList<Product> arrayListProduct) {
        this.arrayListProduct = arrayListProduct;
    }
}