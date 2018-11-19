public class Bil {
	private String regnr;
	private int antallps;
	
	Bil(String regnr, int seter) {
		this.regnr = regnr;
		this.antallps = seter;
	}
	public String getRegnr(){
		return regnr;
	}
	public int getSeter(){
		return seter;
	}
}