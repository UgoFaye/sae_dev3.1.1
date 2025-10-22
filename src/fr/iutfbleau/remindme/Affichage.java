package fr.iutfbleau.remindme;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// REFAIRE L'AFFICHAGE EN ENTIER QD CLICK


public class Affichage extends JPanel implements MouseListener
{




	Liste list = new Liste();
	Details contenu = new Details();
	Boolean displayed = true;
	CardLayout cl = new CardLayout();





	public Affichage(){

		super();

		this.add(this.list);
		this.add(contenu);
		
		this.setLayout(this.cl);
		for (int i = 0; i<list.events.length ; i++ ) {
			this.list.events[i].addMouseListener(this);
		}

		
		
		this.contenu.r.addMouseListener(this);
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
		Rappel jl = (Rappel) e.getSource();
		String nom = jl.getText();
		System.out.println(nom);
		if(displayed)
		{
			this.contenu = new Details(jl);
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