//package fr.iutfbleau.remindme;implements MouseListener



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;












/*
	* La classe Fenetre permet d'afficher une liste de 0 à 4 Rappels (selectionnables).
	* Elle permet de rapidement en consulter les Details en cliquant simplement sur le Rappel voulu.
	* Un bouton permet de creer un nouveau rappel.
	* Un second bouton permet d'éditer son contenu (notamment de choisir quels rappels sont affiches).
	* Le second bouton n'apparait que si il existe plus de quatre rappels.
*/




public class Fenetre extends JFrame 
{








	/*
		* Le constructeur Fenetre() permet d'initialiser la fenetre avec 0 rappels, et de l'afficher.
		* A l'initialisation, la fenetre ne contient qu'un bouton permettant de creer un autre rappel. 
	*/


	public Fenetre()
	{
		super();

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setSize(400, 75);
		this.setLocation(d.width-400,0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);



		this.display();





	}








	/*
		* La methode display() permet d'afficher la fenetre en fonction de ses rappels contenus, et de l'afficher.
		* Si la fenetre n'a aucun rappel, elle n'affiche qu'un bouton de création de rappel. 
	*/

	public void display()
	{
		if(this.isVisible())
		{
			this.dispose();
		}
		this.setVisible(true);
	}






















	
}