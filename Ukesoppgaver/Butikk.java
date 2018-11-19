public class Butikk {
	private Personen person;

	public void entreButikk(String navn, String gjenstand) {
		this.person = new Personen(navn, gjenstand);
	}

	public void kassa(){
		while(!person.taUtPersonForan().equals(null)) {
			System.out.println(person.taUtPersonForan() + "");
		}
	}
}
