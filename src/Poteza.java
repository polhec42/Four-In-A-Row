import java.util.Arrays;
import java.util.Scanner;


public class Poteza {
	
	Scanner sc = new Scanner(System.in);
	private int[][] mreza;
	private int stevecPotez;
	
	public Poteza() {
		this.stevecPotez = 0;
		this.mreza = new int[7][6];
	}
	
	//Vmesnik za vna�anje potez
	public int narediPotezo(String p) {
		
		//System.out.println("Stolpec?");
		
		int poteza = Integer.parseInt(p) - 1;
		/*
		 * To sedaj preverjamo v VpisnaPlosca
		
		//�e poteza ni ustrezna se rekutzivno vrnemo
		else {
			return narediPotezo();
		}
		*/
		
		if(poteza > -1 && poteza < 6) {
			for(int i = 6; i > -1; i--) {
				
				if(mreza[i][poteza] == 0) {
					this.mreza[i][poteza] = stevecPotez % 2 + 1;
					stevecPotez++;
					break;
				}
			}
		}
		System.out.println(Arrays.deepToString(this.mreza));
		return poteza;
	}
	//mre�a vseh potez
	public int[][] vrniMrezo(){
		return this.mreza;
	}
	public void setMreza(int i, int j, int vrednost) {
		this.mreza[i][j] = vrednost;
	}
	
	public int getStPotez() {
		return this.stevecPotez;
	}
	
	public boolean jeKonec() {
		
		//Preverimo za vrstice:
		/*
		 * Konec igre po vrsticah je takrat, ko obstaja zaporedje �tirih enakih �etonov znotraj
		 * iste vrstice.
		 * 
		 * 
		 * **/
		for(int vrstica = 0; vrstica < 7; vrstica++) {
			if(preveri(this.mreza[vrstica], 6)) {
				return true;
			}
		}
		
		//Stolpci:
		
		for(int i = 0; i < 6; i++) {
			int[] stolpec = new int[7];
			//Isti postopek, samo da tokrat gremo prvo po stolpcu in jih damo �etone iz istega
			//stolpca v svojo array
			for(int j = 0; j < 7; j++) {
				stolpec[j] = this.mreza[j][i];
			}
			
			if(preveri(stolpec, 7)) {
				return true;
			}
			
		}
		
		//Diagonale:
		
		for(int i = 0; i < 7; i++) {
			int trenutniNiz = 1;
			for(int j = 0; j < 6; j++) {
				if(mreza[i][j] != 0) {
					for(int n = 1; n < 4; n++) {
						if(i + n < 7 && j + n < 6) {
							if(mreza[i+n][j+n] == mreza[i][j]) {
								trenutniNiz++;
							
								if(trenutniNiz >= 4) {
									return true;
								}
							}else {
								trenutniNiz  = 1;
								break;
							}
						}else {
							trenutniNiz  = 1;
							break;
						}
					
					}
				
					for(int n = 1; n < 4; n++) {
						if(i - n > -1 && j + n < 6) {
							if(mreza[i-n][j+n] == mreza[i][j]) {
								trenutniNiz++;
								
								if(trenutniNiz >= 4) {
									return true;
								}
							}else {
								trenutniNiz = 1;
								break;
							}
							
						}else {
							trenutniNiz  = 1;
							break;
						}
					}
				}
				
			}
		}
		
		return false;
	}
	//Ta funkcija i��e nize istih �etonov ki so dolgi vsaj 4
	//index je zato, ker je igralno polje 6x7 in pazimo indekse :D 
	private boolean preveri(int[] a, int index) {
		int najdaljsiNiz = 0;
		int prejsni = 0;
		int trenutniNiz = 0;
		for(int j = 0; j < index; j++) {
			//�e je mesto zasedeno z �etonom
			if(a[j] != 0) {
				//Pove�amo dol�ino niza, �e enak �eton kot prej�nji,
				//ali pa �e je bil prej�no polje prazno
				if(a[j] == prejsni || prejsni == 0) {
					trenutniNiz++;
					prejsni = a[j];
					if(trenutniNiz > najdaljsiNiz) {
						najdaljsiNiz = trenutniNiz;
					}
				//�e je drug �eton potem za�enmo niz znova	
				}else {
					trenutniNiz = 1;
					prejsni = a[j];
				}
			//�e mesto ni zasedeno, potem se za�ne nov niz	
			}else{
				prejsni = 0;
				trenutniNiz = 0;
			}
		}
		if(najdaljsiNiz >= 4) {
			if(index == 6) {
				System.out.println("Vrstica");
			}else {
				System.out.println("Stolpec");
			}
			return true;
		}
		return false;
	}
}
