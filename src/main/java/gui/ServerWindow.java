package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.Server;

import java.rmi.RemoteException;

public class ServerWindow extends Application {
    public ServerWindow(){

    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/ServerWindow.fxml"));
        Pane pane = loader.load();

        Scene scene = new Scene(pane);

        ServerWindowController serverWindowController = loader.getController();
        try {
            Server server = new Server(serverWindowController);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
