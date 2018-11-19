class Rad {
	private static int radID = 0;
	private int rad;
	
	Rad() {
		this.rad = radID;
		radID++;
	}
	
	/**
	 * Metoden getNR
	 * @return returnerer IDen til raden
	 */
	public int getNR() {
		return this.rad;
	}
}