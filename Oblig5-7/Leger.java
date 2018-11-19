/** Leger
En lege har et unikt navn.
I oblig 6 skal vi kunne finne en lege basert paa navn. Klassen Lege skal derfor 
implementere grensesnittet Lik der sammenlikningen (likheten) skal skje med legens navn.
Grensesnittet Lik inneholder en metode kalt "samme" som har som parameter en String og 
returnerer sann eller usann. Dette grensesnittet kan f.eks. brukes til aa finne om et 
objekt som inneholder et navn (String) har samme navn som parameteren til metoden.
Noen leger har avtaler med kommunen der de jobber (fastleger). Dette aa ha en avtale med 
kommunen er noe ikke bare leger kan ha. Denne egenskapen skal derfor beskrives med et 
grensesnitt (interface). For alle som har en avtale med kommunen skal vi kunne faa 
tak i et avtalenummer. */

class Leger implements Lik {
	private String navn;
	
	Lege(String navn, int avtalenr){
		this.navn = navn;
		this.avtalenr = avtalenr;
	}
	
	Lege(String navn) {
		this.navn = navn;
		this.avtalenr
	}

	public boolean samme(String navn) {
		if(this.navn.equalsIgnoreCase(navn)){
			System.our.println("Dette er samme person.");
			return true;
		} else {
			System.out.println("Dette er ikke samme person");
			/*Lege dr = new Lege(navn, 123);*/
		}
		return false;
	}
}

class Fastlege extends Leger {
	private int avtalenr = 0;
	public void setAvatalenr(String navn, int avtalenr){
		if(sjekkAvtalenr(navn) = true) {
			System.out.println(navn + " har avtalenr " + this.avtalenr);
		} else {
			this.avtalenr = avtalenr;
		}
	}
	
	public int getAvtalenr() {
		Sytem.out.println("Avtalenr er " + this.avtalenr);
		return this.avtalenr;
	}
	
	boolean sjekkAvtalenr(String navn){
		if(this.avtalenr != 0) {
			return true;
		}
		return false;
	}
}

interface Lik {
	boolean samme(String navn);
	int getAvtalenr();
	void settInnLeger();
}
