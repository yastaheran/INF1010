interface GenHylle <T> { //Oppgave 3d
	public int hentStorrelse();
	public void settInn(T bok, int plass);
	public boolean sjekkLedig(int plass);
	public T taUt(int plass);
}

public class Hylle <T> implements GenHylle <T> { //Oppgave 3e
	@SuppressWarnings("unchecked")
	private T[] hylle;
	private int antall = 0;
	
	Hylle(int antPlass){
		hylle = (T[]) new Object[antPlass];
	}
	
	public int hentStorrelse() { //returnerer antall boeker i hyllen
		System.out.println("Det er " + antall + " antall boeker i hyllen");
		return antall;
	}
	
	public void settInn(T bok, int plass){ //hvis ledig legges boken inn i hyllen
		if(hylle[plass] == null && plass <= hylle.length) {
			hylle[plass] = bok;
			antall ++;
			System.out.println("Boken er plassert i hyllen");
		} else {	
			System.out.println("Plassen " + plass + " er Ugyldig");
		}
	}
	
	public boolean sjekkLedig(int plass){ //sjekker om plassen er ledig
		if(hylle[plass] == null) {
			System.out.println("Plassen " + plass + " er ledig");
			return true;
		}
		System.out.println("Plassen " + plass + " er ikke ledig");
		return false;
	}
	
	public T taUt(int plass) {
		T bok;
		if(hylle[plass]!= null) { 
			bok = hylle[plass];
			hylle[plass] = null;
			antall --;
			System.out.println("Boken er tatt ut av plassen: " + plass);
			return bok;
		}
		System.out.println("Ugyldig plass/plass " + plass + " er tom");
		return null;
	}
}