import java.util.Scanner;
public class Person {
	private String navn;			//Oppgave 1.1 A
	private Hus bolig;  			//Oppgave 1.2 A
	public Person(String n){		//Oppgave 1.1 B
		navn = n;
	}
	
	public String toString() {
		String t  = navn;
		if(hus!= null) {
			 t += " " + hus;
		}
		return t;
	}
	
	public void settHus(Hus h) {
		bolig = h;
	}
	
	
	
	public static void main(String[] args){						//Oppgave 1.1 C
		Scanner inn = new Scanner(System.in);
		System.out.println("Skriv inn to navn:");
		String navn1 = inn.nextLine();
		String navn2 = inn.nextLine();
		Person en = new Person(navn1);
		Person to = new Person(navn2);
		Hus huset = new Hus();
		
		en.settHus(huset);
		
		System.out.println("Navnene er " + en.toString() + " " + to.toString());
	}
}