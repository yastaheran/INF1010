public class Motorsykkel {
	private String regnr;
	private int motorvolum;
	
	public Motorsykkel(String r, int m) {
		this.regnr = r;
		this.motorvolum = m;
	}
	public String getRegnr(){
		return regnr;
	}
	public int getMotorVolum(){
		return motorvolum;
	}
}