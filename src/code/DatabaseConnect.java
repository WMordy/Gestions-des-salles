/*Class DatabaseConnect gere la connexion avec la DB en mode lecture et ecriture n'importe quelle que soit la table communiquée!!
la base de donnée est lié au programme grace a un utilisateur de nom d'utilisateur:'gestionnaire' et du mot du passe:'Gestio123.' . cet utilisateur doit etre forcement crée hors du program grace a MYSQL
 les requetes sont ecrites grace au classe Arraylist et a l'objet preparedStatement pour une optimisation du code
        */


package code;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnect {
    public ArrayList DataRead(String req) throws SQLException, ClassNotFoundException { // methode de recuperation des données concerant tout les classes liées au tables SQL dans des matrices Arraylist
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost"+ "?useSSL=false", "gestionnaire", "Gestio123."); //conexion au base de donnée
        Statement cur = con.createStatement();
        cur.execute("USE GestionSalles;"); //choix de la base de donnée
        ResultSet data = cur.executeQuery(req); //execution de la requete
        ResultSetMetaData info = data.getMetaData();  //recuperation des donnée concerant la taille de la table
        ArrayList<ArrayList<String>> recov = new ArrayList();  // matrice a remplir par les données recupérer
        while (data.next()) {
            ArrayList<String> temp = new ArrayList<String>(); //ligne de la table recuperé
            for (int i = 0; i < info.getColumnCount(); i++) {
                temp.add(data.getString(i+1)); //creation de la ligne
            }
            recov.add(temp); // ajout de la ligne a la matrice
        }
        cur.close(); //arret du curseur
        con.close();//arret de la connexion
        return recov;
    }
    public void DataWrite(String req,ArrayList<String> temp) throws SQLException, ClassNotFoundException { //methode d insertion des données de n'importe quelle classe vers n'importe quelle table
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost"+ "?useSSL=false", "gestionnaire", "Gestio123.") ; //creation de la connexion
        PreparedStatement cur = con.prepareStatement("USE GestionSalles;");
        cur.execute();
        cur=con.prepareStatement(req); //preparer la requete SQL
        for(int i=0;i< temp.size();i++){
            cur.setString(i+1,temp.get(i)); //placement des attributs des classes dans les places convenables
        }
        cur.execute(); //execution
        cur.close();
        con.close();
        return;
    }

    public void CheckDB() throws SQLException, ClassNotFoundException { //methode qui s assure de l'existance du database ou il cree une nouvelle
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost"+ "?useSSL=false", "gestionnaire", "Gestio123.");
        Statement cur = con.createStatement();
        String req="CREATE DATABASE IF NOT EXISTS GestionSalles; "; //creation de la base de donnée s'elle n'existe pas!
        cur.executeUpdate(req);
        cur.execute("USE GestionSalles;");
        req="CREATE TABLE  IF NOT EXISTS Teacher (Nom VARCHAR(23),Prenom VARCHAR(24),Specialite VARCHAR(32),CONSTRAINT PRIMARY KEY (Nom,Prenom));"; //creation du table Teacher pour stocker les professeurs
        cur.execute(req); //execution
        req="CREATE TABLE  IF NOT EXISTS Club (NomClub VARCHAR(26),Dirigeant VARCHAR(26),Mission VARCHAR(26),NbrAdherants VARCHAR(4),CONSTRAINT PRIMARY KEY (NomClub));" ; //creation du table Club pour le stockage des clubs
        cur.execute(req);
        req="CREATE TABLE  IF NOT EXISTS Salle (Type VARCHAR(26),Numero VARCHAR(4),Nom VARCHAR(26),Capacité VARCHAR(4),Specialité VARCHAR(26),CONSTRAINT PRIMARY KEY (Numero));";//creation du table Salle pour la raison evidante :)
        cur.execute(req);
        req="CREATE TABLE  IF NOT EXISTS Reservation (TypeReservateur VARCHAR(26),Reservateur VARCHAR(26),Date VARCHAR(26),Etat VARCHAR(26),Salle VARCHAR(26),CONSTRAINT PRIMARY KEY (Reservateur,Date,Salle)); "; //de meme
        cur.execute(req);
        cur.close();
        con.close();
        return;

    }
}
