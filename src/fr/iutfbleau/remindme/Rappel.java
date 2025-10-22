package fr.iutfbleau.remindme;

import java.awt.*;
import javax.swing.*;




public class Rappel extends JLabel {




	public Rappel(){

		super();

		String nomImg = "Bleu";
		ImageIcon img = new ImageIcon("res/imgs/"+nomImg+".jpg"); 
        Image resizedImage = img.getImage().getScaledInstance(390, 95, Image.SCALE_SMOOTH); 
        img = new ImageIcon(resizedImage);
        this.setText("BLABLA");
        this.setIcon(img);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.CENTER);
		this.setBorder(BorderFactory.createMatteBorder(5, 5, 0, 5, Color.BLACK));
        

		
	}

		public Rappel(int i){

		super();
		String nomImg = "Jaune";
		ImageIcon img = new ImageIcon("res/imgs/"+nomImg+".jpg"); 
        Image resizedImage = img.getImage().getScaledInstance(390, 90, Image.SCALE_SMOOTH); 
        img = new ImageIcon(resizedImage);
        this.setText("BLABLABLA");
        this.setIcon(img);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.CENTER);
		this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        

		
	}

































	
}