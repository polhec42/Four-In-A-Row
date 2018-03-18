import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		//int stevecPotez = 0;
		//Ustvarimo okno
		Okno o = new Okno("Stiri v vrsto: Barium");
		Okno vpisPotez = new Okno("Vpisi potezo: ", o.getX() + o.getSirina(), o.getY(), o.getSirina()/3);
		Poteza p = new Poteza();
		
		RisalnaPlosca rp = new RisalnaPlosca(o.getX(), o.getY(), o.getSirina(), o.getVisina(), p.vrniMrezo());
		o.add(rp);
		o.setVisible(true);
		
		VpisnaPlosca vp = new VpisnaPlosca(p);
		vp.add(vp.getVpisnoPolje());
		vp.add(vp.getGumb());
		vpisPotez.add(vp);
		vpisPotez.setVisible(true);
		
		
			
			
		while(p.getStPotez() < 42) {
			if(vp.seSpremeni() == true) {
				
				rp = new RisalnaPlosca(o.getX(), o.getY(), o.getSirina(), o.getVisina(), p.vrniMrezo());
				o.add(rp);
				o.setVisible(true);
			
				//preverimo èe je igre konec
				if(p.jeKonec()) {
					
					//System.out.println("Zmagal je igralec " + p.getStPotez() % 2);
					TimeUnit.SECONDS.sleep(10);
					System.exit(0);
				}
				vp.setSprememba(false);	
				
			//int poteza = p.narediPotezo();
			/*
			boolean potezaJeBilaLegalna = false;
			
			for(int i = 6; i >= 0; i--) {
				if(p.vrniMrezo()[i][poteza] == 0) {
					p.setMreza(i, poteza, stevecPotez % 2 + 1);
					potezaJeBilaLegalna = true;
					break; 
				}
			}
			//Èe je poteza nelegalna, potem znova naredimo potezo (zmanjšamo števec, da ohranimo pravo barvo)
			if(!potezaJeBilaLegalna) {
					stevecPotez--;
				}
			 */
			
				
			}
		}
		
		
	}
	
}
