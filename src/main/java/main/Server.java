package main;

import data.Account;
import data.InterfaceAccount;
import gui.ServerWindow;
import gui.ServerWindowController;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;

public class Server extends UnicastRemoteObject implements InterfaceServer, Serializable {
    private int port;
    private Registry registry;
    private ObservableList<Object> observableListAccounts;
    private ObservableList<Object> observableListProducts;
    private ServerWindow serverwindow;
    private ServerWindowController serverWindowController;

    public Server(ServerWindowController serverWindowController) throws RemoteException {
        super();
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            setPort(1099);
            setRegistry(LocateRegistry.createRegistry(getPort()));
            getRegistry().rebind("Server", this);

            serverWindowController.getLabelServerStatus().setText("Serwer gotowy!");
        } catch (Exception e) {
            serverWindowController.getLabelServerStatus().setText("Serwer nie działa!");
            e.printStackTrace();
        }

        this.serverWindowController = serverWindowController;
        serverWindowController.setServer(this);

        // DO TYCH LIST TRZEBA ŁADOWAC Z BAZY
        observableListAccounts = serverWindowController.getObservableListAccounts();
        observableListProducts = serverWindowController.getObservableListProducts();
    }

    public boolean addAccount(Object account) throws RemoteException {
        try {
            observableListAccounts.add(account);
            for(Object o : observableListAccounts){
                System.out.println(((InterfaceAccount)o).toStrin());
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeAccount(Object account) throws RemoteException {
        try {
            observableListAccounts.remove(account);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addProduct(Object product) throws RemoteException {
        try {
            observableListProducts.add(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeProduct(Object product) throws RemoteException {
        try {
            observableListProducts.remove(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean orderProduct(int productID) throws RemoteException {

//        for (Object p : observableListProducts)
//            if ((Account)p.getId() == productID)
//                return p.decreaseQuantity();
        return false;
    }

    public int test(){
        return port;
    }

    public ObservableList<Object> getListAccounts() throws RemoteException {
        return observableListAccounts;
    }

    public ObservableList<Object> getListProducts() throws RemoteException {
        return observableListProducts;
    }

    public int metoda(int arg) {
        return arg * 10;
    }

    public static void main(String[] args) {
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

    public ObservableList<Account> getObservableListAccounts() {
        return null;//observableListAccounts;
    }

    public void setObservableListAccounts(ObservableList<Account> observableListAccounts) {
        //this.observableListAccounts = observableListAccounts;
    }

    public ObservableList<Object> getObservableListProduct() {
        return observableListProducts;
    }

    public void setObservableListProduct(ObservableList<Object> observableListProduct) {
        this.observableListProducts = observableListProduct;
    }
}