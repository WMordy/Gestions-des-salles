package sample;
        import code.Club;
        import code.Reservation;
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
        import javafx.scene.layout.VBox;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import java.io.IOException;
        import java.sql.SQLException;
        import java.util.ArrayList;

public class showController {
    private Parent sc;
    private Stage pr;
    private ArrayList list;
    @FXML
    private Button ajouter;

    @FXML
    private Button afficher;

    @FXML
    private Button suprimer;

    @FXML
    private Label afficher_lab;

    @FXML
    private VBox info_box;
    static String genre;

    @FXML
    void suprimer(ActionEvent event) throws IOException {
        sc = FXMLLoader.load(getClass().getResource("delete.fxml"));
        pr=(Stage)((Node)(event.getSource())).getScene().getWindow();
        Scene scene=pr.getScene();
        Label lblData = (Label) scene.lookup("#afficher_lab");
        Label lblData2 = (Label) sc.lookup("#del_lab");
        lblData2.setText("Suprimer les "+lblData.getText().substring(13));
        pr.setScene(new Scene(sc));
    }


    @FXML
    void afficher(ActionEvent event) {
    }

    @FXML
    void ajouter(ActionEvent event) throws IOException {
        pr=(Stage)((Node)(event.getSource())).getScene().getWindow();
        Scene scene=pr.getScene();
        Label lblData = (Label) scene.lookup("afficher_lab");
        String NameFile=afficher_lab.getText().substring(13);
        sc=FXMLLoader.load(getClass().getResource("add"+NameFile+".fxml"));
        pr.setScene(new Scene(sc));

    }
    public void initialize() throws SQLException, ClassNotFoundException {
        if(genre=="prof"){
            Teacher t=new Teacher("just","for","initialize");
            ArrayList k=t.Show_Teachers();
            for(int i=0;i<k.size();i++){
                Text lab=new Text("test");
                String st="Le professeur :"+((ArrayList) k.get(i)).get(0)+" "+((ArrayList) k.get(i)).get(1)+" du matiere de : "+((ArrayList) k.get(i)).get(2);
                lab.setText(st);
                info_box.getChildren().add(lab);
            }
        }
        if(genre=="salle"){
            Salle t=new Salle("Sport","5017","B122","125","info");
            ArrayList k=t.Show_Salles();
            for(int i=0;i<k.size();i++){
                Text lab=new Text("test");
                String st="Salle :"+((ArrayList) k.get(i)).get(2)+" "+((ArrayList) k.get(i)).get(0)+" "+((ArrayList) k.get(i)).get(1)+" de specialité :"+((ArrayList) k.get(i)).get(4)+" de capacité :"+((ArrayList) k.get(i)).get(3);
                lab.setText(st);
                info_box.getChildren().add(lab);
            }
        }
        if(genre=="club"){
            Club t=new Club("Sport","5017","B122","125");
            ArrayList k=t.Show_Clubs();
            for(int i=0;i<k.size();i++){
                Text lab=new Text("test");
                String st="Club :"+((ArrayList) k.get(i)).get(0)+" Dirigé par :"+((ArrayList) k.get(i)).get(1)+" Mission :"+((ArrayList) k.get(i)).get(2)+" Adherants :"+((ArrayList) k.get(i)).get(3);
                lab.setText(st);
                info_box.getChildren().add(lab);
            }
        }
        if(genre=="reservation"){
            Reservation t=new Reservation("Sport","5017","B122","125","dd");
            ArrayList k=t.Show_Reservations();
            for(int i=0;i<k.size();i++){
                Text lab=new Text("test");
                String st=((ArrayList) k.get(i)).get(0)+" "+((ArrayList) k.get(i)).get(1)+" reserve la salle :"+((ArrayList) k.get(i)).get(4)+" le :"+((ArrayList) k.get(i)).get(2);
                lab.setText(st);
                info_box.getChildren().add(lab);
            }
        }



    }


}
