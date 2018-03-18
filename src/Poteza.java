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
	
	//Vmesnik za vnašanje potez
	public int narediPotezo(String p) {
		
		//System.out.println("Stolpec?");
		
		int poteza = Integer.parseInt(p) - 1;
		/*
		 * To sedaj preverjamo v VpisnaPlosca
		
		//Èe poteza ni ustrezna se rekutzivno vrnemo
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
	//mreža vseh potez
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
		 * Konec igre po vrsticah je takrat, ko obstaja zaporedje štirih enakih žetonov znotraj
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
			//Isti postopek, samo da tokrat gremo prvo po stolpcu in jih damo žetone iz istega
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
	//Ta funkcija išèe nize istih žetonov ki so dolgi vsaj 4
	//index je zato, ker je igralno polje 6x7 in pazimo indekse :D 
	private boolean preveri(int[] a, int index) {
		int najdaljsiNiz = 0;
		int prejsni = 0;
		int trenutniNiz = 0;
		for(int j = 0; j < index; j++) {
			//Èe je mesto zasedeno z žetonom
			if(a[j] != 0) {
				//Poveèamo dolžino niza, èe enak žeton kot prejšnji,
				//ali pa èe je bil prejšno polje prazno
				if(a[j] == prejsni || prejsni == 0) {
					trenutniNiz++;
					prejsni = a[j];
					if(trenutniNiz > najdaljsiNiz) {
						najdaljsiNiz = trenutniNiz;
					}
				//Èe je drug žeton potem zaèenmo niz znova	
				}else {
					trenutniNiz = 1;
					prejsni = a[j];
				}
			//Èe mesto ni zasedeno, potem se zaène nov niz	
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
