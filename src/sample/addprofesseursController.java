package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import code.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class addprofesseursController {
    private Parent sc;
    private Stage pr;

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
    private Button add_final;
    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField specialite;

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
        Teacher t=new Teacher(prenom.getText(),nom.getText(),specialite.getText());
        nom.clear();
        prenom.clear();
        specialite.clear();
        ArrayList k=t.Show_Teachers();
        boolean stat=false;
        if(!(t.getNom().isEmpty() || t.getPrenom().isEmpty() || t.getSpecialite().isEmpty())) {
            for(int i=0;i<k.size();i++){
                if((((ArrayList)k.get(i)).get(1).equals(t.getPrenom()) & ((ArrayList)k.get(i)).get(0).equals(t.getNom()))||(((ArrayList)k.get(i)).get(0).equals(t.getPrenom()) & ((ArrayList)k.get(i)).get(1).equals(t.getNom()))  ){
                    stat=true;
                }
            }
            if(stat==false) t.Add_Teacher();
        }

    }

}
