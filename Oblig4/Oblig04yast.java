class Oblig04yast {
	public static void main(String [] args) {
		LesFil filen = new LesFil("biler.txt");
		
		filen.lesBilnr();
		System.out.println("Setter inn bilene:");
		filen.settInnBiler();
		System.out.println("Fossil Personbiler:");
		filen.hentFossilPersonbiler();
	}
}