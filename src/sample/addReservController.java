package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import code.Reservation;
import code.Salle;
import code.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class addReservController {
    private Parent sc;
    private Stage pr;
    TextField name = new TextField();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ajouter;

    @FXML
    private Button afficher;

    @FXML
    private Button suprimer;

    @FXML
    private Label add_lab;
    @FXML
    private VBox add_box;
    @FXML
    private ComboBox<?> type_reser;

    @FXML
    private TextField nomReserv;

    @FXML
    private TextField date;

    @FXML
    private ComboBox<?> time;

    @FXML
    private ComboBox<?> salle;

    @FXML
    private Button add_final;

    @FXML
    void aficher(ActionEvent event) throws IOException {
        sc = FXMLLoader.load(getClass().getResource("show.fxml"));
        pr=(Stage)((Node)(event.getSource())).getScene().getWindow();
        Scene scene=pr.getScene();
        Label lblData = (Label) scene.lookup("#add_lab");
        Label lblData2 = (Label) sc.lookup("#afficher_lab");
        lblData2.setText("Afficher les "+lblData.getText().substring(12));
        pr.setScene(new Scene(sc));


    }

    @FXML
    void ajouter(ActionEvent event) {

    }

    @FXML
    void suprimer(ActionEvent event) throws IOException {
        sc = FXMLLoader.load(getClass().getResource("delete.fxml"));
        pr=(Stage)((Node)(event.getSource())).getScene().getWindow();
        Scene scene=pr.getScene();
        Label lblData = (Label) scene.lookup("#add_lab");
        Label lblData2 = (Label) sc.lookup("#del_lab");
        lblData2.setText("Suprimer les "+lblData.getText().substring(12));
        pr.setScene(new Scene(sc));

    }
    @FXML
    void ajouter_final(ActionEvent event) throws SQLException, ClassNotFoundException {
        String kk=((ArrayList)salle.getValue()).get(1).toString();
        Reservation t=new Reservation(nomReserv.getText(),type_reser.getValue().toString(),"Validé",date.getText(),((ArrayList) salle.getValue()).toString());
        ArrayList k=t.Show_Reservations();
        boolean stat=false;
        if(!(t.getReservateur().isEmpty() || t.getTypeReservateur().isEmpty() || t.getSalle().isEmpty() || t.getJour().isEmpty())) {
            for(int i=0;i<k.size();i++){
                if((((ArrayList)k.get(i)).get(1).equals(t.getReservateur()) & ((ArrayList)k.get(i)).get(2).equals(t.getJour()) & ((ArrayList)k.get(i)).get(4).equals(t.getSalle()))){
                    stat=true;
                }
            }
            if(stat==false) t.Add_reservation();
        }

        afficher.fire();

    }
    public void initialize() throws SQLException, ClassNotFoundException {
        ArrayList list=new ArrayList();
        list.add("Club");
        list.add("Professeur");
        ObservableList obList = FXCollections.observableList(list);
        type_reser.setItems(obList);
        type_reser.setPromptText("Vous-etes qui?");
        Salle t=new Salle("Sport","5017","B122","125","info");
        ArrayList k=t.Show_Salles();
        ObservableList obList2 = FXCollections.observableList(k);
        salle.setItems(obList2);
        salle.setPromptText("Salle");
    }

}
