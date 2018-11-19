public class Katt {
	private String navn = " ";
	private int vekt = 500;
	private int antMus = 0;
	private boolean syk = false;
	
	public Katt(String n, int v, boolean s) {
		navn = n;
		vekt = v;
		syk = s;
	}
	public Katt(String n) { //Gir Katt n standar vekt
		this.navn = n;
		this.vekt = 5000;
		this.syk = false;
	}
	public String navn() {
		return this.navn;
	}
	public int vekt() {
		return this.vekt;
	}
	
	public int antMus() {
		return this.antMus;
	}
	
	public boolean syk() {
		return this.syk;
	}
	
	public Mus gaaPaaJaktI(Bol<Mus> musebolet) {
		Mus m = musebolet.taUt();   //Dette er for at man skulle ha musebolet som argument.
		if(m.lever()) {         //Ingen katter spiser døde mus
			if(antMus < 2) {
				if(m.syk()) {    //En katt som spiser ei syk mus, blir selv syk
					syk = true;
					System.out.println("Katten er syk");
				}
				vekt += m.vekt();
				antMus ++;     //Musen havner i magen til katten
				return null; // Etter at musen har blitt spist skal den ikke returneres
			} else {
			 	System.out.println("Katten er mett");
			 	m.bliBitt();
			 	return m;
			}
		} else {
			System.out.println("Ingen katter spiser døde mus");
		}
		return m; //returnerer musen
	}
}