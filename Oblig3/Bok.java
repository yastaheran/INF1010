/**
 * Inteface for Bok.java
 * Bok.java må ha alle metodene i TilUTlaan
 * @author yast
 */
interface TilUtlaan { //Oppgave 3a
	/**
	* metode for å sette navn på låner av en bok
	* @param navn navn på låner 
	* @return returner null dersom boken er allerede utlånt, returnerer navnet på låner
	*  dersom den ikke er det.
	*/
	String settLaaner(String navn);

	/**
    * metode for å levere tilbake en bok
    * @param tittel tittelen på boken som returneres
    * @param laaner navn på låneren
    * @return returnerer true dersom boken er levert tilbake, false hvis boken ikke 
    * var lån fra før
    */
	boolean leverTilbake(String tittel, String laaner);
	
	/**
    * metode for å sjekke om boken er lånt.
    * @param utlaant 
    * @return returnerer true dersom boken er utlånt, false hvis den ikke er utlånt
    */
	boolean sjekkOmLaant(boolean utlaant);
	
}

public class Bok implements TilUtlaan { //Oppgave 3b
	private String tittel, laaner;
	private boolean utlaant = true;
	
	Bok(String tittel) {
		this.tittel = tittel;
		this.laaner = null;
		utlaant = false;
	}

	public boolean leverTilbake(String tittel, String laaner) {
		if(this.utlaant == true && this.laaner != null) {
			this.tittel = tittel;
			this.laaner = null;
			this.utlaant = false;
			System.out.println("Boken " + this.tittel + " er levert tilbake.");
			return true;
		}
		System.out.println("Boken er ikke laant.");
		return false;
	}
	
	public String settLaaner(String navn) {
		if(this.laaner == null) {
			this.laaner = navn;
			this.utlaant = true;
			System.out.println("Boken er laant av " + laaner);
			return laaner;
		}
		System.out.println("Boken er allerede utlaant til " + this.laaner);
		return null;
	}
	
	public boolean sjekkOmLaant(boolean utlaant) { //returnerer true dersom boken er laant, false ellers 
		if(this.utlaant == true) {
			System.out.println(this.tittel + " er utlaant.");
			return true;
		}
		System.out.println(this.tittel + " er ikke utlaant.");
		return false;
	}
}
