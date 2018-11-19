/** Resepter
En resept har et unikt nummer som starter paa 0 med første resept som opprettes. En resept
inneholder en peker til et legemiddel, en peker til den legen som har skrevet ut resepten,
og nummeret til den personen som eier resepten (se nedenfor om leger og personer).
En resept har et antall ganger som er igjen paa resepten (kalles "reit"). Hvis antall 
ganger igjen er null, er resepten ugyldig.
Noen resepter er blaa, andre er hvite. Vi skal ta høyde for at det er stor forskjell paa 
hvite og blaa resepter, men igjen skal vi gjøre en forenkling og si at bare prisen er 
forskjellig: Blaa resepter er sterkt subsidiert, og for enkelhets skyld sier vi her at 
de er gratis. 

class Resepter {
	private String reseptnr;
	private Legemidler pekerLegemiddel;
	private Leger pekerLege;
	private Person person;
	ArrayList<Person> nr = new ArrayList<Person>();
	private int reit;
	private int pris;
	static int index = 0;
	
	Resept(int antReit, String reseptnr, Lege lege, Legemidler legemiddel, Person pers){
		this.reit = antReit;
		this.reseptnr = reseptnr;
		this.pekerLege = lege;
		this.pekerLegemiddel = legemiddel;
		this.person = pers;
		index ++;
	}
	
	public int sjekkAntallReit() {
		if(this.reit == 0) 
			System.out.println("Denne resepten er ugyldig");
			return;
		}
		System.out.println("Det er " + this.reit + " igjen.");
		return reit;
	}
}

class Blaa extends Resepter{
	public getPris() {
		return pris;
	}
}

class Hvit extends Resepter{
	public void setPris(int pris) {
		this.pris = pris;
	}
	
	public int getPris() {
		return this.pris;
	}
} */

public abstract class Resepter {
	private int reseptNummer;
	private int reit;
	Legemidler legemiddel;
	Leger lege;
	//Fastlege fastlege;
	Personer person;
	static int index = 0;
	
	public Resepter(Legemidler legemiddel, Leger lege, Personer person, int reit) {
		this.legemiddel = legemiddel;
		this.lege = lege;
		this.person = person;
		this.reit = reit;
		this.reseptNummer = index;
		index++;
	}
		
	public int getReseptNummer() {
		return reseptNummer;
	}
	
	public int getReit() {
		return reit;
	}
	public double getPris() {
		return legemiddel.getPris();
	}
	
	public String toString() {
		return "Reseptnummer: " + reseptNummer + "	Reit: " + reit;
	} 		
}
