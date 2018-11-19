public class Testprogram { //Oppgave 3f
	public static void main(String [] args) {
		//Lager nye Bok-objekter
		Bok eventyr = new Bok("Harry Potter");
		Bok faglitteratur = new Bok("Big Java");
		Bok kokebok = new Bok("Tapas oppskrifter");
		Bok krim = new Bok("Sherlock Holmes");
						
		//lager en ny array av den generiske Hylle-klassen
		Hylle <Bok> bokhylle = new Hylle<Bok>(100);
		
		//tester ut de forskjellige metodene i Hylle- og Bok-klassen
		bokhylle.settInn(eventyr, 2);
		bokhylle.settInn(kokebok, 1);
		bokhylle.settInn(faglitteratur, 120);

		bokhylle.sjekkLedig(4);
		bokhylle.settInn(krim, 4);
		
		bokhylle.taUt(3);
		bokhylle.taUt(1);
		
		bokhylle.hentStorrelse();
	}
}

