/*
classe qui gerent les reservations en creants des objets reservations qui a comme atrributs le type du reservateur,son nom ,la date de reservation nommé jour et la salle sujet du reservation
ainsi que l'etat du reservation
 */
package code;

import java.sql.SQLException;
import java.util.ArrayList;

public class Reservation {
    private String TypeReservateur;
    private String Reservateur;
    private String jour;
    private String etat;
    private String salle;
    public Reservation( String Reservateur,String TypeReservateur,String etat,String jour,String salle){ //constructeur par default
        this.Reservateur=Reservateur;
        this.TypeReservateur=TypeReservateur;
        this.etat=etat;
        this.jour=jour;
        this.salle=salle;
    }
    public void Add_reservation() throws SQLException, ClassNotFoundException { //ajout d'une reservation a la base de donnée NB: tt controle du duplication ou d'invalidation est gerer dans la partie graphique :)
        DatabaseConnect connection=new DatabaseConnect();
        String req="INSERT INTO Reservation VALUES (?,?,?,?,?);"; // le processus est similaire du class Club et dans le reste des classes du package code
        ArrayList<String> a=new ArrayList<>();
        a.add(this.getTypeReservateur());
        a.add(this.getReservateur());
        a.add(this.getJour());
        a.add(this.getEtat());
        a.add(this.getSalle());
        connection.DataWrite(req,a);
        return;
    }
    public void Del_reservation() throws SQLException, ClassNotFoundException { //methode d'effacement des reservations TT gestion des erreurs est dans la partie graphique
        DatabaseConnect connection=new DatabaseConnect();
        ArrayList<String> a=new ArrayList<>();
        a.add(this.getReservateur());
        a.add(this.getJour());
        a.add(this.getSalle());
        String req="DELETE FROM Reservation WHERE Reservateur=? AND Date=? AND Salle=? ";
        connection.DataWrite(req,a);
    }
    public ArrayList Show_Reservations() throws SQLException, ClassNotFoundException { //recuperation des reservations existants
        DatabaseConnect connection = new DatabaseConnect();
        ArrayList tmp = connection.DataRead("SELECT * FROM Reservation");
        return tmp;
    }

    public String getTypeReservateur() {
        return TypeReservateur;
    }



    public String getReservateur() {
        return Reservateur;
    }



    public String getJour() {
        return jour;
    }



    public String getEtat() {
        return etat;
    }



    public String getSalle() {
        return salle;
    }


}
