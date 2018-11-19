/**
 * SudokuBeholder inneholder de tre offentlige metodene settInn, taUt og hentAntallLosninger. 
 * Programmet skal finne løsninger og legge dem inn i et objekt av klassen SudokuBeholder. 
 * Hvis det finnes flere løsninger enn 2500, skal beholderen holde orden på hvor mange 
 * løsninger som er funnet, men ikke ta vare på flere enn 2500 løsninger.
 */
public class SudokuBeholder {
	private int antall = 0;
	private String[] losninger = new String[2500];;
	
	public void settInn(String loesning) {
		if(antall > 2500) {
			antall++;
		} else {
			losninger[antall] = loesning;
			antall++;
		}
	}
	
	public String taUt(int index) {
		return losninger[index];
	}
	
	public int hentAntallLosninger() {
		return antall;
	}
}