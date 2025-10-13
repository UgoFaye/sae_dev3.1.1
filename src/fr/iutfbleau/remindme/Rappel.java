package fr.iutfbleau.remindme;

import java.awt.*;
import javax.swing.*;




public class Rappel extends JLabel {




	public Rappel(){

		super();

		String theme = "Jaune";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		ImageIcon img = new ImageIcon(loader.getResource("imgs/"+theme+".jpg")); 
        Image resizedImage = img.getImage().getScaledInstance(390, 70, Image.SCALE_SMOOTH); 
        img = new ImageIcon(resizedImage);
        this.setText("BLABLABLA");
        this.setIcon(img);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.CENTER);
		this.setBorder(BorderFactory.createMatteBorder(5, 5, 0, 5, Color.BLACK));
        

		
	}

		public Rappel(int i){

		super();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		ImageIcon img = new ImageIcon(loader.getResource("imgs/"+"Jaune"+".jpg")); 
        Image resizedImage = img.getImage().getScaledInstance(390, 65, Image.SCALE_SMOOTH); 
        img = new ImageIcon(resizedImage);
        this.setText("BLABLABLA");
        this.setIcon(img);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.CENTER);
		this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        

		
	}

































	
}