package gui;

import data.Account;
import data.Product;
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
import java.util.ArrayList;
import java.util.List;

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
    private TableView<Account> tableViewAccounts;
    @FXML
    private TableView<Product> tableViewProducts;
    @FXML
    private Label labelServerStatus;

    private ListProperty<Account> listPropertyAccounts;
    private ObservableList<Account> observableListAccounts;

    private ListProperty<Product> listPropertyProducts;
    private ObservableList<Product> observableListProducts;

    private Server server;

    public void initialize(){
        observableListAccounts = FXCollections.observableArrayList();
        listPropertyAccounts = new SimpleListProperty<Account>();
        listPropertyAccounts.set(observableListAccounts);
        tableViewAccounts.setItems(observableListAccounts);
        tableViewAccounts.itemsProperty().bindBidirectional(listPropertyAccounts);

        tableColumnAccountID.setCellValueFactory(new PropertyValueFactory<Account, String>("id"));
        tableColumnAccountLogin.setCellValueFactory(new PropertyValueFactory<Account, String>("login"));

        observableListProducts = FXCollections.observableArrayList();
        listPropertyProducts = new SimpleListProperty<Product>();
        listPropertyProducts.set(observableListProducts);
        tableViewProducts.setItems(observableListProducts);
        tableViewProducts.itemsProperty().bindBidirectional(listPropertyProducts);

        tableColumnProductID.setCellValueFactory(new PropertyValueFactory<Product, String>("id"));
        tableColumnProductName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        tableColumnProductCost.setCellValueFactory(new PropertyValueFactory<Product, String>("cost"));
        tableColumnProductQuantity.setCellValueFactory(new PropertyValueFactory<Product, String>("quantity"));
        tableColumnSellerID.setCellValueFactory(new PropertyValueFactory<Product, String>("seller"));

        observableListAccounts.add(new Account(1, "loginek", "haselko", 1));
        observableListProducts.add(new Product(1, "test", "bardzo fajny test", 1, 1, 1000));
    }

    public void actionDeleteAccount(){
        try {
            Account account = tableViewAccounts.getSelectionModel().getSelectedItem();
            server.removeAccount(account);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void actionDeleteProduct(){
        try {
            Product product = tableViewProducts.getSelectionModel().getSelectedItem();
            server.removeProduct(product);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Account> getObservableListAccounts() {
        return observableListAccounts;
    }

    public void setObservableListAccounts(ObservableList<Account> observableListAccounts) {
        this.observableListAccounts = observableListAccounts;
    }

    public ObservableList<Product> getObservableListProducts() {
        return observableListProducts;
    }

    public void setObservableListProducts(ObservableList<Product> observableListProducts) {
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
