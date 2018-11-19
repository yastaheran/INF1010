class Boks {
	private static int boksID = 0;
	private int boks;
	
	Boks() {
		this.boks = boksID;
		boksID ++;
	}
	
	/**
	 * @return returnerer IDen til boksen
	 *************************************/
	public int getNR() {
		return this.boks;
	}
}
