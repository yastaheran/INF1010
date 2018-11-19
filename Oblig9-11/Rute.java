import java.util.Arrays;
/**
*Klassen Rute passer på hver rute sine verdier
*og inneholder metodene fyllUtDenneRuteOgResten
*og finnAlleMuligeTall.
*******************************************/
class Rute {
	private int verdi, rad, kolonne;
	private static int ruteID = 0;
	private int[] rader;
	private int[] kolonner;
	private int[] bokser;
	private int[] rute = new int[ruteID];
	private Brett brett;
	private SudokuBeholder beholder;
	private int[] muligeTall;
	
    /**
    *Konstruktør for klassen Rute
    *@param verdi tallverdien som står i ruten
    *@param rad raden ruten ligger i
    *@param kol kolonnen ruten ligger i
    *@param boks boksen ruten ligger i
    *******************************************/
	Rute(int verdi, int radID, int kolID, int boksID) {
		rader[radID] = radID;
		kolonner[kolID] = kolID;
		bokser[boksID] = boksID;
		rute[ruteID] = verdi;
		ruteID++;
	}
	
    /**
    *metoden settAntallRK setter antall rader og kolonner i sudokuen
    *@param rad raden ruten ligger i
    *@param kol kolonnen ruten ligger i
    *******************************************/
	void settAntallRK(int rad, int kolonne) {
		this.rad = rad;
		this.kolonne = kolonne;
	}
	String getVerdi() { //henter verdien i ruta
		if(this.verdi == 0) {
			return ".";
		} else {
			return String.valueOf(verdi);
		}
	}

    void setBrettpeker(Brett b) {
		brett = b;
    }
    
    void setVerdi(int n) {
		this.verdi = n;
    }
    
	/**
	* metode som returnerer en array med de tallene som er mulige loesningstall i en blank 
	* rute. F.eks. skal metoden kalt i oeverste rute i venstre i eksempelbrettet paa foerste 
	* side returnere en array med tallene 2, 3, 4, 7, 8 og 9.
	* Jeg fikk ikke tid til å lage denne metoden.
	*************************************************/
	public int[] finnAlleMuligeTall() {
		int[] alleTall = new int[35]; // alle tall som kan være i en rute
		for(int i = 0; i < alleTall.length; i++) { //går i gjennom og legger til tall i arrayet
			alleTall[i] = i+1;
		}
		muligeTall = new int[35]; 					//alle tall som er mulige i en rute
		for(int i = 0; i < rute.length; i++) {
			if(rute[i] == 0) { 								// sjekker om ruta er tom
				for(int c = 1; c <= alleTall.length; c++) { //går i gjennom allatTall-arrayet
					for(int j = 1; j < rute.length; j++) {
						if(!Arrays.asList(rute).contains(c)) { 				//sjekker om neste rute er lik tallet c
							muligeTall[i] = c;
						}
					}
				}
			}
			System.out.print("rute " + i + " ");
			return muligeTall;
		}
		return muligeTall;
	}
	/**
	 * Metoden skulle:
	 * - proeve aa sette alle mulige loesningstall i seg selv. 
	 * - foerst gjoere et kall paa metoden finnAlleMuligeTall. 
	 * - Deretter proever den aa sette alle disse tallene i denne ruta, ett om gangen. 
	 * - For hvert tall som settes i ruta kalles metoden fyllUtDenneRuteOgResten i neste rute 
	 * - Når en vannrett rad er ferdig kalles metoden i ruta helt til venstre i 
	* neste rad, osv. Når et kall på fyllUtDenneRuteOgResten-metoden i neste rute returnerer, 
	* prøver ruta neste tall som enda ikke er prøvd, osv. helt til alle tall er prøvd i denne 
	* ruta. Main-metoden starter det hele ved å kalle fyllUtDenneRuteOgResten i den øverste 
	* venstre ruta. Løsningen(e) skal skrives ut på skjermen.
	******************************************************/
	public void fyllUtDenneRuteOgResten(int rad, int kolonne) {
		finnAlleMuligeTall();
		boolean ferdig = false;
		kolonne++;
		
		if (kolonne == kolonner.length) { //sjekker om det er siste kolonne
			kolonne = 0;
			rad++;
			if(rad == rader.length) { //sjekker om det er siste rad
				ferdig = true;
			}
		}
		
		if(verdi == 0) {
			for(int r = 1; r <= rad; r ++) {
				if(sjekkerVerdi(muligeTall[r])) {
					setVerdi(r);
					if(ferdig) {
						brett.skrivUtBrett();
						ferdig = false;
					} else {
						fyllUtDenneRuteOgResten(0, kolonne++);
					}
				}
			}
			setVerdi(0);
		} else {
			if (ferdig) {
				brett.skrivUtBrett();
				beholder.settInn(brett.toString());
				ferdig = false;
			} else {
				fyllUtDenneRuteOgResten(0,kolonne++);
			}
		}	
	}
	
	boolean sjekkerVerdi(int verdi) { 
	//sjekker om den medsendte verdien finnes i allerede i samme rad
		boolean ok = true;
		for(int i = 0; i < rute.length; i++) {
			if(i < rader.length) {	
				if(rute[i] == verdi) {
					ok = false;
				}
			}
		}
		return ok;
	} 
}