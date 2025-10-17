package fr.iutfbleau.remindme;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;





public class StartApp extends JFrame
{


	public StartApp()
	{

		super();

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setSize(400, 400);
		this.setLocation(d.width-400,0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);


		this.add(new Affichage());
		this.setVisible(true);

	}







	public static void main(String[] args) 
	{
		StartApp start = new StartApp();
	}




























	
}