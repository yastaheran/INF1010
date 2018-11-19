class Kolonne {
	private static int kolID = 0;
	private int kolonne;
	
	Kolonne() {
		this.kolonne = kolID;
		kolID++;
	}
	
	/**
	 * @return returnerer IDen til kolonnen
	 **************************************/
	public int getNR() {
		return this.kolonne;
	}
}