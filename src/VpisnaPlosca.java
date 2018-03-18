import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VpisnaPlosca extends JPanel implements ActionListener{
	
	private JTextField vpisnoPolje;
	private JButton gumb;
	private String poteza;
	private Poteza p;
	private boolean sprememba;
	
	public VpisnaPlosca(Poteza p) {
		this.vpisnoPolje = new JTextField(10);
		this.gumb = new JButton("Potrdi");
		this.poteza = "1";
		this.p = p;
		this.sprememba = false;
		
		gumb.addActionListener(this);
		gumb.setEnabled(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == gumb) {
			poteza = vpisnoPolje.getText();
			
			p.narediPotezo(poteza);
			vpisnoPolje.setText("");
			this.sprememba = true;
		}
	}
	
	public boolean seSpremeni() {
		//Zaradi problemov z Multithreading
		//treba bo drugaèe napisat ozadje -> TODO
		System.out.println("");
		return this.sprememba;
	}
	
	public void setSprememba(boolean b) {
		this.sprememba = b;
	}
	
	public JTextField getVpisnoPolje() {
		return this.vpisnoPolje;
	}
	
	public JButton getGumb() {
		return this.gumb;
	}
	
	public String getPoteza() {
		return this.poteza;
	}
}
