import java.awt.*;
import javax.swing.*;

public class Okno extends JFrame{
	
	private int x;
	private int y;
	private int sirina;
	private int visina;
	
	public Okno(String ime) {
		setTitle(ime);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		int dSirina = d.width;
		int dVisina = d.height;
		
		setX(dSirina/4);
		setY(dVisina/4);
		setSirina(dSirina/2);
		setVisina(dVisina/2);
		
		setBounds(x, y, sirina, visina);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	public Okno(String ime, int xLega, int yLega, int sirina) {
		setTitle(ime);
		
		setX(xLega);
		setY(yLega);
		setSirina(sirina);
		setVisina(sirina);
		
		setBounds(x, y, sirina, visina);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
	}
	
	//Getters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getSirina() {
		return sirina;
	}

	public int getVisina() {
		return visina;
	}
	//Setters
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public void setSirina(int sirina) {
		this.sirina = sirina;
	}
	
	public void setVisina(int visina) {
		this.visina = visina;
	}
	
	
}
