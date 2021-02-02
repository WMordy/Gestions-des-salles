package sample;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class mainController {
    private Parent sc;
    private Stage pr;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane main;

    @FXML
    private Button reserv_button;

    @FXML
    private Button salles_button;

    @FXML
    private Button prof_button;

    @FXML
    private Button club_button;

    @FXML
    void test(ActionEvent event) throws IOException {
        showController scc=new showController();
        deleteController dll=new deleteController();
        dll.genre="reservation";
        scc.genre="reservation";
        sc = FXMLLoader.load(getClass().getResource("show.fxml"));
        Label lblData = (Label) sc.lookup("#afficher_lab");
        if (lblData!=null) lblData.setText("Afficher les reservations");
        pr=(Stage)((Node)(event.getSource())).getScene().getWindow();
        pr.setScene(new Scene(sc));
    }
    @FXML
    void club(ActionEvent event) throws IOException {
        showController scc=new showController();
        deleteController dll=new deleteController();
        dll.genre="club";
        scc.genre="club";
        sc = FXMLLoader.load(getClass().getResource("show.fxml"));
        Label lblData = (Label) sc.lookup("#afficher_lab");
        if (lblData!=null) lblData.setText("Afficher les clubs");
        pr=(Stage)((Node)(event.getSource())).getScene().getWindow();
        pr.setScene(new Scene(sc));

    }

    @FXML
    void prof(ActionEvent event) throws IOException {
        showController scc=new showController();
        deleteController dll=new deleteController();
        dll.genre="prof";
        scc.genre="prof";
        sc = FXMLLoader.load(getClass().getResource("show.fxml"));
        Label lblData = (Label) sc.lookup("#afficher_lab");
        if (lblData!=null) lblData.setText("Afficher les professeurs");
        pr=(Stage)((Node)(event.getSource())).getScene().getWindow();
        pr.setScene(new Scene(sc));


    }

    @FXML
    void salles(ActionEvent event) throws IOException {
        showController scc=new showController();
        deleteController dll=new deleteController();
        dll.genre="salle";
        scc.genre="salle";
        sc = FXMLLoader.load(getClass().getResource("show.fxml"));
        Label lblData = (Label) sc.lookup("#afficher_lab");
        if (lblData!=null) lblData.setText("Afficher les salles");
        pr=(Stage)((Node)(event.getSource())).getScene().getWindow();
        pr.setScene(new Scene(sc));

    }

    @FXML
    void initialize() {
        assert main != null : "fx:id=\"main\" was not injected: check your FXML file 'main.fxml'.";
        assert reserv_button != null : "fx:id=\"reserv_button\" was not injected: check your FXML file 'main.fxml'.";
        assert salles_button != null : "fx:id=\"salles_button\" was not injected: check your FXML file 'main.fxml'.";
        assert prof_button != null : "fx:id=\"prof_button\" was not injected: check your FXML file 'main.fxml'.";
        assert club_button != null : "fx:id=\"club_button\" was not injected: check your FXML file 'main.fxml'.";


    }
}
