/** Legemidler
Et legemiddel har et navn, et unikt nummer og en pris. Naar nye legemidler registreres 
gis de et nytt løpende (unikt) nummer som starter paa 0.
Et legemiddel er enten av type A, narkotisk, eller av type B, vanedannende, eller av type 
C, vanlige legemiddel. For alle legemidler maa vi kunne vite hvor mye virkestoff (mg) det 
inneholder totalt.
Det er stor forskjell paa legemidler av disse tre typene, men i denne oppgaven skal vi 
bare ta hensyn til:
	Legemidler av type A har et heltall som sier hvor sterkt narkotisk det er.
	Legemidler av type B har et heltall som sier hvor vanedannende det er.
	Legemidler av type C har ingen nye egenskaper (annet enn klassens navn).

I tillegg til egenskapene beskrevet over kommer legemidler enten som piller eller 
som mikstur (flytende). Disse egenskapene skal du beskrive vha. grensesnitt (interface).
For enkelhets skyld skal vi for piller bare vite hvor mange piller det er i en eske og 
hvor mye virkestoff det er i hver pille. For mikstur skal vi vite hvor mange cm3 det er 
i en flaske og hvor mye virkestoff det er i hver cm3. */

interface typeLegemiddel {
	int getAntPiller();
	int getVirksestoffprPille();
	int getvolum();
	int getVirkestoffprCM3();
}

class Legemider interface typeLegemiddel {
	private String navnLegemiddel;
	private static int legemiddelnr;
	private double pris;
	private int antPiller = 20;
	private int virkestoff;
	private int volum = 30;
	
	Legemidler(String navn, double pris) {
		this.navnLegemiddel = navn;
		this.legemiddelnr;
		this.pris = pris;
		legemiddelnr ++;
	}
	
	public int setAntPiller(int ant) {
		this.antPiller = ant;
	}
	
	public int getAntPiller() {
		System.out.println("Det er " + this.antPiller + " i esken.");
		return this.antPiller;
	}
	
	public int setVirksestoffprPille(int virkestoff) {
		this.virkestoff = virkestoff;
	}
	
	public int getVirksestoffprPille() {
		System.out.println("Det er " + this.virkestoff + " virkestoff pr pille.");
		return this.virkestoffPille;
	}
	
	public int setVolumMiks(int volum) {
		this.volum = volum;
	}
	
	public int getVolumMiks() {	
		System.out.println("Det er " + this.volum + " cm3 i flasken.");
		return this.volum;
	}
	
	public int setVirkestoffprCM3(int virkestoff) {
		this.virkestoff = virkestoff;
	}
	
	public int getVirkestoffprCM3() {
		System.out.println("Det er " + this.virkestoff + " virkestoff per cm3.");
		return this.virkestoffMiks;
	}
}

class LegemidlerA extends Legemidler {
	private int narkotisk;						//sier hvor sterkt narkotisk det er.
	
	public int getStyrke() {
		System.out.println("Styrken er " + narkotisk);
		return this.narkostisk;
	}
	
	public void setStyrke(int styrke) {
		this.nakotisk = styrke;
	}
}

class LegemidlerB extends Legemidler {
	private int vanedannende;					//sier hvor vanedannende det er.
	
	public int getVanedann() {
		System.out.println("Dette legemiddelet er " + " % vanedannande.");
		return vanedannende;
	}
	
	public void setVanedann(int prosent) {
		this.vanedannende = prosent;
	}
}

class LegemidlerC extends Legemidler {
										//har ingen nye egenskaper.
}