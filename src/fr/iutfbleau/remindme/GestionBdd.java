package fr.iutfbleau.remindme;

import java.sql.*;

/**
 * Classe qui établi la connexion à la base de données. 
 * Les fonctions permettent d'intéragir avec les éléments 
 * de la base de données
 */


public class GestionBdd{

	/**
	 * Connexion vers la base de données
	 */
	protected Connection cnx; 

	/**
	 * Etabli la connexion avec la base de données cible et la stocke dans cnx
	 */
	public GestionBdd(){

		try{
			this.cnx = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/leclere","leclere","CAMcode");
		}catch (SQLException e){
			System.out.println("Erreur connection BD\n"+e.getMessage());
		}
		




		
	}
	/**
	 * ajoute un tuple dans la base de données
	 * 
	 * @param titre le titre du nouvel tuple 
	 * @param contenu le contenu du nouvel tuple
	 * @param rang le rang du nouvel tuple
	 * @param theme le theme du nouvel tuple
	 **/
	public void ajouterElem(String titre, String contenu, int rang, String theme){
		try{
			PreparedStatement pst = this.cnx.prepareStatement("INSERT INTO Rappel(titre,contenu,rang,theme) Values(?,?,?,?)");
			pst.setString(1,titre);
			pst.setString(2,contenu);
			pst.setInt(3,rang);
			pst.setString(4,theme);
			pst.executeUpdate();
			pst.close();
		}catch (SQLException e){
			System.out.println("Erreur ajout tuple\n"+e.getMessage());
		}
	}

	/**
	 * ajout un tuple dans la base de donnée en définissant le contenu à null
	 * 
	 * @param titre le titre du nouvel element 
	 * @param rang le rang du nouvel element
	 * @param theme le theme du nouvel element
	 */
	public void ajouterElem(String titre,int rang, String theme){
		ajouterElem(titre,null,rang,theme);
	}


	/**
	 * Permet de mettre à jour un tuple dans la base de données
	 * 
	 * @param id l'id du tuple qui sera modifié
	 * @param newTitre le nouveau titre du tuple
	 * @param newContenu le nouveau contenu du tuple 
	 * @param newRang le nouveau rang du tuple
	 * @param newTheme le nouveau theme du tuple
	 */
	public void maj(int id, String newTitre, String newContenu, int newRang,String newTheme){
		try{
			PreparedStatement pst = this.cnx.prepareStatement("UPDATE Rappel SET titre = ?, contenu = ?, rang = ?, theme = ? WHERE id = ?");
			pst.setString(1,newTitre);
			pst.setString(2,newContenu);
			pst.setInt(3,newRang);
			pst.setString(4,newTheme);
			pst.setInt(5,id);
			pst.executeUpdate();
			pst.close();
		}catch (SQLException e){
			System.out.println("Erreur maj\n"+e.getMessage());
		}
	}


	/*public void maj(String attribut, int id, String nouvelleVal){
		try{
			PreparedStatement pst = this.cnx.prepareStatement("UPDATE Rappel SET ? = ? WHERE id = ?");
			pst.setString(1,attribut);
			pst.setString(2,nouvelleVal);
			pst.setInt(3,id);
			pst.executeUpdate();
			pst.close();
		}catch (SQLException e){
			System.out.println("Erreur maj\n" + e.getMessage());
		}
	}

	public void maj(String attribut, int id, int nouvelleVal){
		try{
			PreparedStatement pst = this.cnx.prepareStatement("UPDATE Rappel SET ? = ? WHERE id = ?");
			pst.setString(1,attribut);
			pst.setInt(2,nouvelleVal);
			pst.setInt(3,id);
			pst.executeUpdate();
			pst.close();
		}catch (SQLException e){
			System.out.println("Erreur maj\n"+e.getMessage());
		}
	}*/

	/**
	 * Supprime un tuple de la base de données à partir de son id
	 * 
	 * @param id l'id du tuple qui sera supprimé
	 */
	public void supprimer(int id){
		try{
			PreparedStatement pst = this.cnx.prepareStatement("DELETE FROM Rappel WHERE id = ?");
			pst.setInt(1,id);
			pst.executeUpdate();
			pst.close();
		}catch (SQLException e){
			System.out.println("Erreur suppression\n"+e.getMessage());
		}
	}

	/**
	 * Ajoute un nouveau tuple dans la base de données 
	 * 
	 * @param id l'id du nouveau tuple
	 * @param titre le titre du nouveau tuple
	 * @param contenu le contenu du nouveau tuple
	 * @param rang le rang du nouveau tuple 
	 * @param theme le theme du nouveau tuple
	 */
	public void cree(int id, String titre, String contenu, int rang,String theme){
		try{
			PreparedStatement pst = this.cnx.prepareStatement("INSERT INTO Rappel VALUES (?,?,?,?,?)");
			pst.setInt(1,id);
			pst.setString(2,titre);
			pst.setString(3,contenu);
			pst.setInt(4,rang);
			pst.setString(5,theme);
			pst.executeUpdate();
			pst.close();
		}catch (SQLException e){
			System.out.println("Erreur maj\n"+e.getMessage());
		}
	}


	/**
	 * Renvoi tous les tuples stocké dans la base de données
	 * 
	 * @return tous les tuples stocké dans la base de données
	 */
	public ResultSet getEvents(){
		try{
			PreparedStatement pst = this.cnx.prepareStatement("SELECT * FROM Rappel");
			return pst.executeQuery();
		}catch (SQLException e){
			System.out.println("Erreur récupérer tous les Evenements\n"+e.getMessage());
		}
		return null;
	}

	/**
	 * Renvoi le nombre de tuples stocké dans la base de données
	 * 
	 * @return Le nombre de tuples stocké dans la base de données
	 */
	public int nbrEvents(){
		try{
			PreparedStatement pst = this.cnx.prepareStatement("SELECT COUNT(*) FROM Rappel");
			ResultSet res = pst.executeQuery();
			res.next();
			return res.getInt(1);
		}catch (SQLException e){
			System.out.println("Erreur compter les Evenements\n"+e.getMessage());
		}
		return -1;
	}

	/**
	 * Ferme la connexion avec la base de données
	 */
	public void fermeConn(){
		try{
			this.cnx.close();
		}catch (SQLException e){
			System.out.println("Erreur fermeture BD\n"+e.getMessage());
		}
	}
}