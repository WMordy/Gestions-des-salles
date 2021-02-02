package code;

import java.sql.SQLException;
import java.util.ArrayList;

public class Club {
    private String Clubname;
    private String derigeant;
    private String mission;
    private String NbAdherants;
    public Club(String Cname,String derg,String miss,String Nb){ //constructeur des clubs
        Clubname=Cname;
        derigeant=derg;
        mission=miss;
        NbAdherants=Nb;
    }

    public String getClubname() {
        return Clubname;
    }
    public String getDerigeant() {
        return derigeant;
    }
    public String getMission() {
        return mission;
    }

    public String getNbAdherants() {
        return NbAdherants;
    }

    public void Add_Club() throws SQLException, ClassNotFoundException { //methode d ajout des clubs qui envoie une phrase de requete au classe DBconnect
        DatabaseConnect connection=new DatabaseConnect();  //objet pour etablir la connexion
        String req="INSERT INTO Club VALUES (?,?,?,?);"; //modele de requete preparé pour l ajout des clubs
        ArrayList<String> a=new ArrayList<>(); //liste des attributs du club a ajouter
        a.add(this.getClubname());
        a.add(this.getDerigeant());
        a.add(this.getMission());
        a.add(this.getNbAdherants());
        connection.DataWrite(req,a);
        return;
    }
    public void Del_Club() throws SQLException, ClassNotFoundException { //methode de supression des clubs qui envoie une phrase de requete au methode WriteData de la classe DBconect
        DatabaseConnect connection=new DatabaseConnect(); //objet pour etablir la connexion
        ArrayList<String> a=new ArrayList<>(); //liste des attributs du club
        a.add(this.getClubname()); //la clé primaire du table relationelle Club
        String req="DELETE FROM Club WHERE NomCLub=? "; //requete prete pour la supression du club
        connection.DataWrite(req,a); //envoie de la requete a la methode Datawrite
    }
    public ArrayList Show_Clubs() throws SQLException, ClassNotFoundException { //methode de lecture des clubs de la DB
        DatabaseConnect connection=new DatabaseConnect();
        ArrayList tmp=connection.DataRead("SELECT * FROM Club");
        return tmp;
    }

}
