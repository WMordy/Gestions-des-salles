package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import code.Club;
import code.Reservation;
import code.Salle;
import code.Teacher;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class deleteController {
    private Parent sc;
    private Stage pr;
    static String genre;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private VBox del_box;

    @FXML
    private Button ajouter;

    @FXML
    private Button afficher;

    @FXML
    private Label del_lab;

    @FXML
    void afficher(ActionEvent event) throws IOException {
        sc = FXMLLoader.load(getClass().getResource("show.fxml"));
        pr = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Scene scene = pr.getScene();
        Label lblData = (Label) scene.lookup("#del_lab");
        Label lblData2 = (Label) sc.lookup("#afficher_lab");
        lblData2.setText("Afficher les " + lblData.getText().substring(13));
        pr.setScene(new Scene(sc));
    }

    @FXML
    void ajouter(ActionEvent event) throws IOException {
        pr = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Scene scene = pr.getScene();
        Label lblData = (Label) scene.lookup("#del_lab");
        String NameFile = lblData.getText().substring(13);
        sc = FXMLLoader.load(getClass().getResource("add" + NameFile + ".fxml"));
        pr.setScene(new Scene(sc));

    }

    @FXML
    void del_final(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList list = del_box.getChildren();
        if (genre == "prof") {
            Teacher t = new Teacher("just", "for", "initialize");
            ArrayList k = t.Show_Teachers();
            for (int i = 1; i < k.size(); i++) {
                for (Object j : list) {
                    if (((CheckBox) j).isSelected()) {
                        int kkk = Integer.parseInt(((CheckBox) j).getId().trim().substring(2));
                        if (kkk == i) {
                            Teacher t2 = new Teacher(((ArrayList) k.get(i)).get(1).toString(), ((ArrayList) k.get(i)).get(0).toString(), ((ArrayList) k.get(i)).get(2).toString());
                            t2.Del_Teacher();
                        }
                    }

                }
            }
        }
        if (genre == "salle") {
            Salle t = new Salle("Sport", "5017", "B122", "125", "info");
            ArrayList k = t.Show_Salles();
            for (int i = 0; i < k.size(); i++) {
                for (Object j : list) {
                    if (((CheckBox) j).isSelected()) {
                        int kkk = Integer.parseInt(((CheckBox) j).getId().trim().substring(2));
                        if (kkk == i) {
                            Salle t2 = new Salle(((ArrayList) k.get(i)).get(0).toString(), ((ArrayList) k.get(i)).get(1).toString(), ((ArrayList) k.get(i)).get(2).toString(), ((ArrayList) k.get(i)).get(3).toString(), ((ArrayList) k.get(i)).get(4).toString());
                            t2.Del_Salle();
                        }
                    }

                }
            }
        }
        if (genre == "club") {
            Club t = new Club("just", "for", "initialize", "300");
            ArrayList k = t.Show_Clubs();
            for (int i = 0; i < k.size(); i++) {
                for (Object j : list) {
                    if (((CheckBox) j).isSelected()) {
                        int kkk = Integer.parseInt(((CheckBox) j).getId().trim().substring(2));
                        if (kkk == i) {
                            Club t2 = new Club(((ArrayList) k.get(i)).get(0).toString(), ((ArrayList) k.get(i)).get(1).toString(), ((ArrayList) k.get(i)).get(2).toString(), ((ArrayList) k.get(i)).get(3).toString());
                            t2.Del_Club();
                        }
                    }

                }
            }
        }
        if (genre == "reservation") {
            Reservation t = new Reservation("just", "for", "initialize", "300","dd");
            ArrayList k = t.Show_Reservations();
            for (int i = 0; i < k.size(); i++) {
                for (Object j : list) {
                    if (((CheckBox) j).isSelected()) {
                        int kkk = Integer.parseInt(((CheckBox) j).getId().trim().substring(2));
                        if (kkk == i) {
                            Reservation t2 = new Reservation(((ArrayList) k.get(i)).get(1).toString(), ((ArrayList) k.get(i)).get(0).toString(), ((ArrayList) k.get(i)).get(3).toString(), ((ArrayList) k.get(i)).get(2).toString(),((ArrayList) k.get(i)).get(4).toString());
                            t2.Del_reservation();
                        }
                    }

                }
            }
        }
        for (Object i : list) {
            if (((CheckBox) i).isSelected()) {
                String k = ((CheckBox) i).getText();
            }
        }
        afficher.fire();
    }

    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {
        if (genre == "prof") {
            Teacher t = new Teacher("just", "for", "initialize");
            ArrayList k = t.Show_Teachers();
            for (int i = 0; i < k.size(); i++) {
                Text lab = new Text("test");
                String st = "Le professeur :" + ((ArrayList) k.get(i)).get(0) + " " + ((ArrayList) k.get(i)).get(1) + " du matiere de : " + ((ArrayList) k.get(i)).get(2);
                CheckBox check = new CheckBox();
                check.setText(st);
                check.setId("id" + i);
                del_box.getChildren().add(check);
            }
        }
        if (genre == "salle") {
            Salle t = new Salle("Sport", "5017", "B122", "125", "info");
            ArrayList k = t.Show_Salles();
            for (int i = 0; i < k.size(); i++) {
                Text lab = new Text("test");
                String st = "Salle :"+((ArrayList) k.get(i)).get(2)+" "+((ArrayList) k.get(i)).get(0)+" "+((ArrayList) k.get(i)).get(1)+" de specialité :"+((ArrayList) k.get(i)).get(4)+" de capacité :"+((ArrayList) k.get(i)).get(3);
                CheckBox check = new CheckBox();
                check.setText(st);
                check.setId("id" + i);
                del_box.getChildren().add(check);
            }
        }
        if (genre == "club") {
            Club t = new Club("Sport", "5017", "B122", "125");
            ArrayList k = t.Show_Clubs();
            for (int i = 0; i < k.size(); i++) {
                Text lab = new Text("test");
                String st="Club :"+((ArrayList) k.get(i)).get(0)+" Dirigé par :"+((ArrayList) k.get(i)).get(1)+" Mission :"+((ArrayList) k.get(i)).get(2)+" Adherants :"+((ArrayList) k.get(i)).get(3);
                CheckBox check = new CheckBox();
                check.setText(st);
                check.setId("id" + i);
                del_box.getChildren().add(check);
            }

        }
        if (genre == "reservation") {
            Reservation t = new Reservation("Sport", "5017", "B122", "125","dd");
            ArrayList k = t.Show_Reservations();
            for (int i = 0; i < k.size(); i++) {
                Text lab = new Text("test");
                String st=((ArrayList) k.get(i)).get(0)+" "+((ArrayList) k.get(i)).get(1)+" reserve la salle :"+((ArrayList) k.get(i)).get(4)+" le :"+((ArrayList) k.get(i)).get(2);
                CheckBox check = new CheckBox();
                check.setText(st);
                check.setId("id" + i);
                del_box.getChildren().add(check);
            }

        }

    }
}
