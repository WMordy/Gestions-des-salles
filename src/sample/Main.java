package sample;

import code.DatabaseConnect;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {
    Stage main;
    Parent root;

    @Override
    public void start(Stage main) throws Exception {
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        main.setTitle("Gestionneur Des Salles");
        main.setScene(new Scene(root, 720, 480));
        main.setResizable(false);
        main.show();



    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseConnect connexion=new DatabaseConnect();
        connexion.CheckDB();
        launch(args);


    }
}