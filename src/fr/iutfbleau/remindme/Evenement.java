package fr.iutfbleau.remindme;

import java.sql.*;

/**
 * Classe qui représente un évènement de la base de données. 
 * Un évènement à un identifiant (id) unique, un rang, un titre, 
 * un contenu et une theme. 
 * 
 */
public class Evenement{
	/**
	 * Identifiant unique d'un évènement non modifiable une fois initialisé
	 */ 
	protected final int id;
	/**
	 * Rang/priorité de l'évènement 
	 */ 
	protected int rang;
	/**
	 * Titre de l'évènement
	 */ 
	protected String titre;
	/**
	 * Contenu de l'évènement
	 */ 
	protected String contenu;
	/**
	 * theme de l'évènement
	 */ 
	protected String theme;

	/**
	 * Constructeur qui crée un Evenement à partir d'un tuple d'une base de données
	 * 
	 * @param rs un tuple de la base de données
	 */
	public Evenement(ResultSet rs){
    int tmpId;
    try {
        tmpId = rs.getInt(1);
        this.titre = rs.getString(2);
        this.contenu = rs.getString(3);
        this.rang = rs.getInt(4);
        this.theme = rs.getString(5);
    } catch (SQLException e) {
        System.out.println("Erreur d'évènement\n" + e.getMessage());
        tmpId = -1;
        this.titre = "";
        this.contenu = "";
        this.rang = 0;
        this.theme = "";
    }
    this.id = tmpId;
}

	/**
	 * renvoi l'id de l'Evenement
	 * 
	 * @return l'id de l'Evenement
	 */
	public int getId(){
		return this.id;
	}

	/**
	 * renvoi le rang de l'Evenement
	 * 
	 * @return le rang de l'Evenement
	 */
	public int getRang(){
		return this.rang;
	}

	/**
	 * Défini un nouveau rang à l'Evenement
	 * 
	 * @param newRang le nouveau rang à attribuer à l'Evenement
	 */
	public void setRang(int newRang){
		this.rang = newRang;
	}

	/**
	 * Renvoie le titre d'un Evenement  
	 * 
	 * @return le titre d'un Evenement
	 */
	public String getTitre(){
		return this.titre;
	}

	/**
	 * Défini un nouveau titre à l'Evenement
	 * 
	 * @param newTitre le nouveau titre à attribuer à l'Evenement
	 */
	public void setTitre(String newTitre){
		this.titre = newTitre;
	}

	/**
	 * renvoi le contenu d'un Evenement
	 * 
	 * @return le contenu d'un Evenement
	 */
	public String getContenu(){
		return this.contenu;
	}

	/**
	 * Défini un nouveau contenu à l'Evenement
	 * 
	 * @param newContenu le nouveau contenu à attribuer à l'Evenement
	 */
	public void setContenu(String newContenu){
		this.contenu = newContenu;
	}

	/**
	 * renvoi le theme d'un Evenement
	 * 
	 * @return la couleur d'un Evenement
	 */
	public String getTheme(){
		return this.theme;
	}

	/**
	 * Défini une nouvelle couleur à l'Evenement
	 * 
	 * @param newCouleur la nouvelle couleur à attribuer à l'Evenement
	 */
	public void settheme(String newtheme){
		this.theme = newtheme;
	}

	/**
	 * Renvoi une chaine de characteres décrivant l'Evenement
	 * 
	 * @return une chaine de characteres décrivant l'Evenement
	 */
	public String toString(){
		return "id = "+ this.id + "\nrang = " + this.rang + "\ntitre = " + this.titre + "\ncontenu = " + this.contenu + "\ntheme = " + theme;
	}


}