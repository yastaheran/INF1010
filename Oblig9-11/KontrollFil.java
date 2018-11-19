import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *Klassen KontrollFil inneholder metoden som spør
 *om og registrerer navnet på oppgavefilen, metoden
 *som leser fra fil i det programmet starter
 *og metoden som begynner å løse oppgaven.
 *******************************************/
public class KontrollFil {
   private Brett brett;
   private String filnavn;
   private Scanner leser;
   private char[] abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    
   /**
    * Denne metoden kaller på FilVelger klassen som sjekker filen som  er valgt av bruker
    */
    boolean sporOmOgSjekkFil() { //skriver ut spm. om navn på fil, hvis true så er filen i riktig format
		FilVelger filValg = new FilVelger();
		filValg.lagOgVisGUI();
		if(!filValg.hentFilnavn().equals(null)) {
			filnavn = filValg.hentFilnavn();
			return true;
		} else {
			return false;
		}
	}
	 
    /**
	* Metoden for å lese sudoku-filen
	*/
	public void lesFil() {
		try {
			File fil = new File(filnavn);
			leser = new Scanner(fil);
			
			int rad = leser.nextInt();
			int kolonne = leser.nextInt();
			int antallBokser = rad*kolonne;
			
			brett = new Brett(rad, kolonne);
			brett.delInnRuter(rad, kolonne);
			
			/*
			* får ikke fikset feilmelding:
			* Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 1
			* at SudokuHoved.lesFil(SudokuHoved.java:65)
			* at SudokuHoved.main(SudokuHoved.java:9)
			*/
			while(leser.hasNextLine()) {
				String linje = leser.nextLine();
				String[] del = linje.split(" ");
				System.out.println(del[0]);
				int tall = 0;
				for(int i = 0; i < antallBokser; i++) {
					if(!del[i].equals(" ")) {
						if(del[i].equals(".")) {
							brett.leggTilVerdiIRuter(tall);
							System.out.println(del[i]);					
						} else if(del[i].matches("[a-zA-Z]+") == false && abc.length > 2) {
						//sjekker hvilken bokstav det er og gir den et tallverdi
							for(int x = 0; x < abc.length; x++) {
								if(del[i].equals(abc[x])) {
									tall = 10 + x;
									brett.leggTilVerdiIRuter(tall);
								}
							}
						} else {
        					tall = Integer.parseInt(del[i]);
  					 		brett.leggTilVerdiIRuter(tall);
							System.out.println(del[i]);
						}
					}
				}
			}
			System.out.println("Filen " + filnavn + " ble lest." + 
								"\nSudoku-brettet er " + rad + " x " + kolonne +"." +
								"\nSlik ser oppgaven ut:");
			brett.skrivUtBrett();		
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Finner ikke fil.");
		}
	} 
    
	/**
	* Metoden losOppgave finner pekeren til ruten i øverste venstre hjørne i brettet og 
	* kaller så metoden fyllUtDenneRuteOgResten i denne ruten.
	*******************************************/
    void losOppgave() {
		Rute rute = brett.getRute(0,0);
		rute.fyllUtDenneRuteOgResten(0, 0);
    }
}
