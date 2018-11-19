/**Personer
Personer har et navn og et fødselsnummer (11 siffer) og en adresse. 
Adressen skal være et veinavn og nummer (som til sammen lagres i en String) 
og et firesifret postnummer. Naar en ny person registreres gis personen i tillegg et nytt
løpende (unikt) nummer som starter paa 0 med første personen som programmet oppretter. */

class Personer interface PersonInfo {
	private String navn;
	private String adresse;
	private int postnr = 0000;
	private int foedselsnr = 00000000000;
	private String uniktnr;
	private int i = 0;
	
	Person(String navn, String veinavn, int nr, int postnr, int foedselsnr) {
		this.navn = navn;
		this.adresse = veinavn + " " + nr;
		this.postnr = postnr;
		this.foedselsnr = foedselsnr;
		this.uniktnr = "0" + i;
	}
	
	public String getInfoOmPerson() {
		System.out.println("Navn: " + navn + " Adresse: " + adresse + " Postnr: " + postnr + " Foedselsenr: " + foedselsnr + "uniktnr: " + uniktnr);
		return this.uniktnr;
	}
}

interface PersonInfo {
	String getInfoOmPerson();	
}