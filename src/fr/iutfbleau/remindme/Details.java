package fr.iutfbleau.remindme;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Details extends JPanel{

	Rappel r = new Rappel(0);

	public Details(){
		super();
		this.add(r);
	}
	public Details(Rappel e){
		super();
		Rappel j = e;
		this.add(j);
	}


}