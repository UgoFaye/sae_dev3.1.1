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

	JLabel common = this.newCase2("L");
	JLabel jaune = this.newCase2("Jaune");
	JLabel l = this.newCase2("L");





	/*
		* Le constructeur Liste() permet d'initialiser la fenetre avec 0 rappels, et de l'afficher.
		* A l'initialisation, la fenetre ne contient qu'un bouton permettant de creer un autre rappel. 
	*/


	public Liste(int i)
	{
		super();

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

		
		this.setSize(200,100);
		this.setLocation(0,0);



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


		this.add(common);
		this.gbc.gridy = 1;
		
		if (i==0){this.add(jaune, this.gbc);}else{this.add(l, this.gbc);}
		







	}









	public static JLabel newCase2(String nomImg){


		ImageIcon img = new ImageIcon("res/imgs/"+nomImg+".jpg"); 
        Image resizedImage = img.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH); 
		JLabel laKaze = new JLabel(nomImg, img, JLabel.CENTER);
        laKaze.setHorizontalTextPosition(JLabel.CENTER);
        laKaze.setVerticalTextPosition(JLabel.BOTTOM);
        laKaze.setBorder(BorderFactory.createMatteBorder(2, 2, 3, 3, Color.BLACK));
        return laKaze;

	}

















	
}