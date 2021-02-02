/*
la classe salle genere des objets salle des attributs suivants : type,numero,nom,specialité
NB:les attributs sont tous String a cause d'un probleme lors de la creation des requete avec la methode personalisé optée lors de ce projet
!!!!!!!!!!!
la creation,la supression et la lecture des salles est similaire c'est meme copier coller + editer de la classe club ^_^


 */

package code;

import java.sql.SQLException;
import java.util.ArrayList;

public class Salle {
    private String type;
    private String numero;
    private String nom;
    private String cap;
    private String spec;

    public Salle(String type,String numero,String nom,String cap,String spec){
        this.type=type;
        this.numero=numero;
        this.nom=nom;
        this.cap=cap;
        this.spec=spec;
    }
    public void Add_Salle() throws SQLException, ClassNotFoundException {
        DatabaseConnect connection=new DatabaseConnect();
        String req="INSERT INTO Salle VALUES (?,?,?,?,?);";
        ArrayList<String> a=new ArrayList<>();
        a.add(this.getType());
        a.add(this.getNumero());
        a.add(this.getNom());
        a.add(this.getCap());
        a.add(this.getSpec());
        connection.DataWrite(req,a);
        return;
    }
    public void Del_Salle() throws SQLException, ClassNotFoundException {
        DatabaseConnect connection=new DatabaseConnect();
        ArrayList<String> a=new ArrayList<>();
        a.add(this.getNumero());
        String req="DELETE FROM Salle WHERE Numero=? ";
        connection.DataWrite(req,a);
    }
    public ArrayList Show_Salles() throws SQLException, ClassNotFoundException {
        DatabaseConnect connection=new DatabaseConnect();
        ArrayList tmp=connection.DataRead("SELECT * FROM Salle");
        return tmp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

}
