package fr.iutfbleau.remindme;

import java.sql.*;


public class Evenement{

	protected final int id;

	protected int rang;
	
	protected String titre;

	protected String contenu;

	protected String couleur;


	public Evenement(ResultSet rs){
    int tmpId;
    try {
        tmpId = rs.getInt(1);
        this.titre = rs.getString(2);
        this.contenu = rs.getString(3);
        this.rang = rs.getInt(4);
        this.couleur = rs.getString(5);
    } catch (SQLException e) {
        System.out.println("Erreur d'évènement\n" + e.getMessage());
        tmpId = -1;
        this.titre = "";
        this.contenu = "";
        this.rang = 0;
        this.couleur = "";
    }
    this.id = tmpId;
}


	public int getId(){
		return this.id;
	}


	public int getRang(){
		return this.rang;
	}


	public void setRang(int newRang){
		this.rang = newRang;
	}


	public String getTitre(){
		return this.titre;
	}


	public void setTitre(String newTitre){
		this.titre = newTitre;
	}


	public String getContenu(){
		return this.contenu;
	}


	public void setContenu(String newContenu){
		this.contenu = newContenu;
	}


	public String getCouleur(){
		return this.couleur;
	}


	public void setCouleur(String newCouleur){
		this.couleur = newCouleur;
	}

	public String toString(){
		return "id = "+ this.id + "\nrang = " + this.rang + "\ntitre = " + this.titre + "\ncontenu = " + this.contenu + "\ncouleur = " + couleur;
	}
































	
}