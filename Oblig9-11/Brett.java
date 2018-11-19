import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class Brett extends JPanel {
	private Rute[][] ruter;
	private Rad[] rader;
	private Kolonne[] kolonner;
	private Boks[][] bokser;
	private Rute rute;
	private JTextField txtFelt[][];
	
	Brett(int rad, int kolonne) {
    	ruter = new Rute[rad][kolonne];
    	setBorder(new EmptyBorder(4, 4, 4, 4));
    	txtFelt = new JTextField[rad * kolonne][rad * kolonne];
		setLayout(new GridLayout(rad, kolonne, 2, 2));
        for (int r = 0; r < rad; r++) {
            for (int k = 0; k < kolonne; k++) {
                int startRad = r * rad;
                int startKol = k * kolonne;
                add(lagBrett(txtFelt, startRad, startKol, rad, kolonne));
            }
        }
	}
	
	protected JPanel lagBrett(JTextField[][] felt, int startRad, int startKol, int totRad, int totKol) {
        JPanel panel = new JPanel(new GridLayout(startRad, startKol, 2, 2));
        panel.setBorder(new CompoundBorder(new LineBorder(Color.BLACK, 2), new EmptyBorder(2, 2, 2, 2)));

        for (int r = 0; r < totRad; r++) {
        	for (int k = 0; k < totKol; k++) {
                int radIndex = (startRad * r) * totRad;
                int kolIndex = (startKol * k) * totKol;
                panel.add(lagSubBrett(felt, radIndex, kolIndex, totRad, totKol));
            }
        }
        return panel;
    }
    
    protected JPanel lagSubBrett(JTextField[][] felt, int startRad, int startKol, int totRad, int totKol) {
    	JPanel panel = new JPanel(new GridLayout(startRad, startKol, 2, 2));
        panel.setBorder(new CompoundBorder(new LineBorder(Color.GRAY, 2), new EmptyBorder(2, 2, 2, 2)));

    	fyllFelt(felt, startRad, startKol, totRad, totKol);
        for (int r = 0; r < startRad; r++) {
        	for (int k = 0; k < startKol; k++) {
                panel.add(felt[r + startRad][k + startKol]);
            }
        }
        return panel;
    }

    protected void fyllFelt(JTextField[][] felt, int rad, int kolonne, int totRad, int totKol) {
        for (int r = rad; r < rad + totRad; r++) {
            for (int k = kolonne; k < totKol; k++) {
                felt[r][k] = new JTextField(1);
            }
        }
    }
	
	/**
	* oppretter riktig antall rader, kolonner og bokser. 
	* jeg delte denne metoden i to fordi jeg ikke fikk til å ha alt i en metode. 
	* den andre metoden heter leggtTilVerdiIRuter(int verdi)
	*/
	public void delInnRuter(int totRader, int totKolonner) {
		rute.settAntallRK(totRader, totKolonner);
		rader = new Rad[totRader];
		kolonner = new Kolonne[totKolonner];
		bokser = new Boks[totRader][totKolonner];		
		//oppretter rader
		for (int i = 0; i < totRader; i++) {
            this.rader[i] = new Rad();
        }
        
        //Oppretter kolonner
        for (int i = 0; i < totRader; i++) {
        	this.kolonner[i] = new Kolonne();
        }
        
        //Oppretter bokser
        for (int i = 0; i < rader.length; i++) {
            for (int j = 0; j < kolonner.length; j++) {
                this.bokser[i][j] = new Boks();
            }
        }
	}
	
	/**
	* faar hvert rute-objekt i brettet til aa peke paa sine respektive rader, 
	* kolonner og bokser. 
	*/
	public void leggTilVerdiIRuter(int verdi) {
        for(int i = 0; i < rader.length; i++) {
        	for(int j = 0; j < kolonner.length; j++) {
        		this.ruter[i][j] = new Rute(verdi, rader[i].getNR(), kolonner[j].getNR(), bokser[i][j].getNR());
        	}
        }
	}
	
	public Rute getRute(int rad, int kolonne) {
		return ruter[rad][kolonne];
	}
	
	/**
	* Skriver ut brettet
	*/
	@SuppressWarnings("unused")
	public String skrivUtBrett() {
		for(int i = 0; i < ruter.length; i++){
			for(int j = 0; j < ruter[i].length; j++) {
				System.out.println(ruter[i][j].getVerdi());
				return ruter[i][j].getVerdi();
			}
		}
		return null;
	}
	
	/**
	* lager en string av Brettet
	*/
	@SuppressWarnings("unused")
	public String toString() {
		for(int i = 0; i < ruter.length; i++){
			for(int j = 0; j < ruter[i].length; j++) {
				return ruter[i][j].getVerdi();
			}
		}
		return null;
	}
}