public class TestprogramBok { //Oppgave 3c
	public static void main(String [] args) {
		//Nye Bok-objekter
		Bok harryPotter = new Bok("Harry Potter");
		Bok sherlockHolmes = new Bok("Sherlock Holmes");
		Bok goneWithTheWind  = new Bok("Gone with the Wind ");
		
		//tester ut de forskjellige metodene i Bok-klassen
		harryPotter.settLaaner("Julie");
		sherlockHolmes.settLaaner("Marius");
		sherlockHolmes.settLaaner("Eiril");
		
		harryPotter.leverTilbake("Harry Potter", "Julie");
		goneWithTheWind.leverTilbake("Gone with the Wind", "Sunniva");
	}
}