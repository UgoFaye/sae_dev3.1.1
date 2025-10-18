//package fr.iutfbleau.remindme;


import org.mariadb.jdbc.*;
import java.sql.*;




public class GestionBdd{


	Connection cnx; 


	public GestionBdd(){

		try{
			this.cnx = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/leclere","leclere","CAMcode");
		}catch (SQLException e){
			System.out.println("Erreur connection BD\n"+e.getMessage());
		}
		




		
	}
	/**
	 * 
	 **/
	public void ajouterElem(String titre, String contenu, int rang, String couleur){
		try{
			PreparedStatement pst = this.cnx.prepareStatement("INSERT INTO Rappel(titre,contenu,rang,theme) Values(?,?,?,?)");
			pst.setString(1,titre);
			pst.setString(2,contenu);
			pst.setInt(3,rang);
			pst.setString(4,couleur);
			pst.executeUpdate();
			pst.close();
		}catch (SQLException e){
			System.out.println("Erreur ajout element\n"+e.getMessage());
		}
	}

	public void ajouterElem(String titre,int rang, String couleur){
		ajouterElem(titre,null,rang,couleur);
	}

	public void maj(int id, String titre, String contenu, int rang,String couleur){
		try{
			PreparedStatement pst = this.cnx.prepareStatement("UPDATE Rappel SET titre = ?, contenu = ?, rang = ?, theme = ? WHERE id = ?");
			pst.setString(1,titre);
			pst.setString(2,contenu);
			pst.setInt(3,rang);
			pst.setString(4,couleur);
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



	public ResultSet getEvents(){
		try{
			PreparedStatement pst = this.cnx.prepareStatement("SELECT * FROM Rappel");
			return pst.executeQuery();
		}catch (SQLException e){
			System.out.println("Erreur récupérer tous les Evenements\n"+e.getMessage());
		}
		return null;
	}


	public void fermeConn(){
		try{
			this.cnx.close();
		}catch (SQLException e){
			System.out.println("Erreur fermeture BD\n"+e.getMessage());
		}
	}
}