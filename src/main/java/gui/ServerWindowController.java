package gui;

import data.InterfaceAccount;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Server;

import java.rmi.RemoteException;
import java.util.Iterator;

public class ServerWindowController {
    @FXML
    private TableColumn tableColumnAccountID;
    @FXML
    private TableColumn tableColumnAccountLogin;
    @FXML
    private TableColumn tableColumnProductID;
    @FXML
    private TableColumn tableColumnProductName;
    @FXML
    private TableColumn tableColumnProductCost;
    @FXML
    private TableColumn tableColumnProductQuantity;
    @FXML
    private TableColumn tableColumnSellerID;
    @FXML
    private TableView<Object> tableViewAccounts;
    @FXML
    private TableView<Object> tableViewProducts;
    @FXML
    private Label labelServerStatus;

    private ListProperty<Object> listPropertyAccounts;
    private ObservableList<Object> observableListAccounts;

    private ListProperty<Object> listPropertyProducts;
    private ObservableList<Object> observableListProducts;

    private Server server;

    public void initialize(){
        observableListAccounts = FXCollections.observableArrayList();
        listPropertyAccounts = new SimpleListProperty<Object>();
        listPropertyAccounts.set(observableListAccounts);
        tableViewAccounts.setItems(observableListAccounts);
        tableViewAccounts.itemsProperty().bindBidirectional(listPropertyAccounts);

        tableColumnAccountID.setCellValueFactory(new PropertyValueFactory<Object, String>("id"));
        tableColumnAccountLogin.setCellValueFactory(new PropertyValueFactory<Object, String>("login"));

        observableListProducts = FXCollections.observableArrayList();
        listPropertyProducts = new SimpleListProperty<Object>();
        listPropertyProducts.set(observableListProducts);
        tableViewProducts.setItems(observableListProducts);
        tableViewProducts.itemsProperty().bindBidirectional(listPropertyProducts);

        tableColumnProductID.setCellValueFactory(new PropertyValueFactory<Object, String>("id"));
        tableColumnProductName.setCellValueFactory(new PropertyValueFactory<Object, String>("name"));
        tableColumnProductCost.setCellValueFactory(new PropertyValueFactory<Object, String>("cost"));
        tableColumnProductQuantity.setCellValueFactory(new PropertyValueFactory<Object, String>("quantity"));
        tableColumnSellerID.setCellValueFactory(new PropertyValueFactory<Object, String>("seller"));

//        observableListAccounts.add(new Account(1, "loginek", "haselko", 1));
//        observableListProducts.add(new Product(1, "test", "bardzo fajny test", 1, 1, 1000));
    }

    public void actionDeleteAccount(){
        try {
            Object account = tableViewAccounts.getSelectionModel().getSelectedItem();
            server.removeAccount(account);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void actionDeleteProduct(){
        try {
            Object product = tableViewProducts.getSelectionModel().getSelectedItem();
            server.removeProduct(product);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void actionen() {
        Iterator<Object> iterator = observableListAccounts.iterator();
        while(iterator.hasNext()){
            InterfaceAccount ic = (InterfaceAccount) iterator.next();
            try {
                System.out.println(ic.getLogin());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public ObservableList<Object> getObservableListAccounts() {
        return observableListAccounts;
    }

    public void setObservableListAccounts(ObservableList<Object> observableListAccounts) {
        this.observableListAccounts = observableListAccounts;
    }

    public ObservableList<Object> getObservableListProducts() {
        return observableListProducts;
    }

    public void setObservableListProducts(ObservableList<Object> observableListProducts) {
        this.observableListProducts = observableListProducts;
    }

    public Label getLabelServerStatus() {
        return labelServerStatus;
    }

    public void setLabelServerStatus(Label labelServerStatus) {
        this.labelServerStatus = labelServerStatus;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}