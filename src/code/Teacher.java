package code;

import java.sql.SQLException;
import java.util.ArrayList;

public class Teacher {
    private String nom;
    private String prenom;
    private String specialite;
    public Teacher(String Fname,String name,String spec){
        nom=name;
        prenom=Fname;
        specialite=spec;
    }

    public String getNom() {
        return nom;
    }


    public String getPrenom() {
        return prenom;
    }


    public String getSpecialite() {
        return specialite;
    }


    public void Add_Teacher() throws SQLException, ClassNotFoundException {
        DatabaseConnect connection=new DatabaseConnect();
        String req="INSERT INTO Teacher VALUES (?,?,?);";
        ArrayList<String> a=new ArrayList<>();
        a.add(this.getNom());
        a.add(this.getPrenom());
        a.add(this.getSpecialite());
        connection.DataWrite(req,a);
    }
    public void Del_Teacher() throws SQLException, ClassNotFoundException {
        DatabaseConnect connection=new DatabaseConnect();
        ArrayList<String> a=new ArrayList<>();
        a.add(this.getNom());
        a.add(this.getPrenom());
        String req="DELETE FROM Teacher WHERE Nom=? AND Prenom=? ";
        connection.DataWrite(req,a);
    }
    public ArrayList Show_Teachers() throws SQLException, ClassNotFoundException {
        DatabaseConnect connection=new DatabaseConnect();
        ArrayList a=connection.DataRead("SELECT * FROM Teacher");
        return a;
    }

}
