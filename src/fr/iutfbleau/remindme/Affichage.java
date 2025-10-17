package fr.iutfbleau.remindme;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class Affichage extends JPanel implements MouseListener
{




	Liste liste = new Liste(0);
	Liste liste2 = new Liste(1);
	Boolean displayed = true;
	CardLayout cl = new CardLayout();





	public Affichage(){

		super();

		
		this.setLocation(0,0);
		this.setLayout(this.cl);
		this.setSize(100,100);
		this.liste.common.addMouseListener(this);
		this.liste.jaune.addMouseListener(this);
		this.liste2.common.addMouseListener(this);
		this.liste2.l.addMouseListener(this);
		
		this.add(liste);
		this.add(liste2);
		this.cl.first(this);


	}



	



	

	





	public void mouseClicked(MouseEvent e){			// un bouton cliqué
	}          

	public void mouseEntered(MouseEvent e){			// debut du survol
	}          

	public void mouseExited(MouseEvent e){				// fin du survol

	}           

	public void mousePressed(MouseEvent e){			// un bouton appuyé
	}          

	public void mouseReleased(MouseEvent e)
	{			// un bouton relâché
		JLabel jl = (JLabel) e.getSource();
		String nom = jl.getText();
		System.out.println(nom);
		if(displayed)
		{

			displayed=false;
			this.cl.last(this);
		}
		else
		{
			displayed=true;
			this.cl.first(this);			
		}
	}   
	










}