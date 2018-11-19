class RekursivListe {
	int[] liste = new int[100];
	
	public void settInn(int plass) {
		if(liste[plass] == null) {
			liste[plass] = plass;
			settInn(plass+1);
		} else {
			settInn(plass+1);
		}
	}
	
	
}