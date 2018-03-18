import javax.swing.*;
import java.awt.*;

public class RisalnaPlosca extends JPanel{
	
	private int x;
	private int y;
	private int sirina;
	private int visina;
	private Color barvaZetona;
	private int[][] mreza;
	
	public RisalnaPlosca(int x, int y, int sirina, int visina, int[][] mreza) {
		this.x = x;
		this.y = y;
		this.sirina = sirina;
		this.visina = visina;
		this.mreza = mreza;
		
		this.barvaZetona = null;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Prvo narišemo mrežo
		for(int vrstica = 0; vrstica < 7; vrstica++) {
			g.drawLine(0, vrstica*this.enotaVisine(), this.sirina, vrstica*this.enotaVisine());
		}
		
		
		for(int stolpec = 0; stolpec < 6; stolpec++) {
			g.drawLine(stolpec*enotaSirine(), 0, stolpec*enotaSirine(), this.visina);
		}
		
		int polmer = polmerZetonov();
		//Gremo po tabeli in rišemo že odigrane žetone
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 6; j++) {
				if(mreza[i][j] != 0) {
					setColor(mreza[i][j]);
					g.setColor(this.barvaZetona);
					g.fillOval(this.sredinaStolpca() + j*enotaSirine(), this.sredinaVrstice() + i*enotaVisine(), polmer, polmer);
				}
			}
		}
		
	}
	
	private int enotaVisine() {
		return this.visina/8;
	}
	private int enotaSirine() {
		return this.sirina/6;
	}
	
	private int polmerZetonov() {
		if(enotaVisine() > enotaSirine()) {
			return enotaSirine();
		}
		return enotaVisine();
	}
	
	private int sredinaStolpca() {
		return enotaSirine()/2 - polmerZetonov()/2;
	}
	private int sredinaVrstice() {
		return enotaVisine()/2 - polmerZetonov()/2;
	}
	//Èe je igralec 1, je zelena, drugaèe pa rdeèa
	public void setColor(int a) {
		if(a == 1) {
			this.barvaZetona = Color.GREEN;
		}else {
			this.barvaZetona = Color.RED;
		}
	}
	
}
