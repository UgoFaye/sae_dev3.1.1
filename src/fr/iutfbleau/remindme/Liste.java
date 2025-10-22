package fr.iutfbleau.remindme;//implements MouseListener



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;












/*
	* La classe Liste permet d'afficher une liste de Rappels (selectionnables) selon leur ordre de priorité.
	* Elle permet de rapidement en consulter les Details en cliquant simplement sur le Rappel voulu.
	* Un bouton permet de creer un nouveau rappel.
	* Un second bouton permet d'éditer la Liste (notamment de choisir quels rappels sont affiches).
	* Le second bouton n'apparait que si il existe plus d'un rappel.
*/




public class Liste extends JPanel 
{


	GridBagConstraints gbc = new GridBagConstraints();

	Rappel[] events = new Rappel[10];






	/*
		* Le constructeur Liste() permet d'initialiser la fenetre avec 0 rappels, et de l'afficher.
		* A l'initialisation, la fenetre ne contient qu'un bouton permettant de creer un autre rappel. 
	*/


	public Liste()
	{
		super();

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

		



		this.setLayout(new GridBagLayout());
		this.gbc.fill = GridBagConstraints.BOTH;     	// chaque case occupe tout l'espace de la plage
		this.gbc.anchor = GridBagConstraints.CENTER; 	// chaque case place au centre de la plage
		this.gbc.insets = new Insets(0, 0, 0, 0);    	// laisse 0 pixels de vide autour des composants
		this.gbc.weightx = 0.0; 					 	// les composants n'ont pas besoin de largeur supplémentaire
		this.gbc.weighty = 0.0;  					 	// les composants n'ont pas besoin de hauteur supplémentaire
		this.gbc.gridheight = 1; 					 	// les composants font toujours exactement une ligne au max de hauteur
		this.gbc.gridwidth = 1;
		this.gbc.gridx = 0;
		this.gbc.gridy = 0;

		for (int i = 0; i< this.events.length ; i++ ) {
			this.gbc.gridy = i;
			if(i%2==0){
				this.events[i] = this.newCase("a");
			}else{

				this.events[i] = this.newCase2("a");
			}
			this.add(this.events[i], this.gbc);
		}		
		
		







	}




	public static Rappel newCase(String nomImg){

        return new Rappel();

	}




	public static Rappel newCase2(String nomImg){

        return new Rappel(0);

	}

















	
}