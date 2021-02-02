package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import code.Salle;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class addSalleController {
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
    private TextField Type;

    @FXML
    private TextField numero;

    @FXML
    private TextField nom;

    @FXML
    private TextField capa;

    @FXML
    private TextField spec;

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
    void ajouter(ActionEvent event) throws SQLException, ClassNotFoundException {

        }

    @FXML
    void suprimer(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
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
        Salle t = new Salle(Type.getText(), numero.getText(), nom.getText(), capa.getText(), spec.getText());
        nom.clear();
        Type.clear();
        spec.clear();
        numero.clear();
        capa.clear();
        ArrayList k=t.Show_Salles();
        boolean stat=false;
        if (!(t.getNom().isEmpty() || t.getNumero().isEmpty() || t.getSpec().isEmpty() || t.getType().isEmpty() )){
            for(int i=0;i<k.size();i++){
                if(((ArrayList)k.get(i)).get(1).equals(t.getNumero())){
                    stat=true;
                }
            }
            if(stat==false) t.Add_Salle();
        }
    }
}
