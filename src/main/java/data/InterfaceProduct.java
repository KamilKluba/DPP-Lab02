package data;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceProduct extends Remote {
    public int getId() throws RemoteException;
    public void setId(int id) throws RemoteException;
    public String getName() throws RemoteException;
    public void setName(String name) throws RemoteException;
    public String getDescription() throws RemoteException;
    public void setDescription(String description) throws RemoteException;
    public int getQuantity() throws RemoteException;
    public boolean decreaseQuantity() throws RemoteException;
    public void setQuantity(int quantity) throws RemoteException;
    public int getSellerID() throws RemoteException;
    public void setSellerID(int sellerID) throws RemoteException;
    public int getCost() throws RemoteException;
    public void setCost(int cost) throws RemoteException;
}
