class Oblig01yast {
    // ** versjon 15.01.26
    // forbedret testene:
    // get-metodene i Katt returnerer "logiske" typer for
    // vekt, antallMus og syk.
    // Skilt ut infoOmTilstand (i Mus) som egen metode
    // Det er likegyldig om man leverer denne
    // eller tidligere versjon. Det vesentlige er at klassene fungerer sammen.

    public static void main(String[] a) {
        hovedprogram();
    }

    public static void testOmSomForventet(String hva, String verdi, String fverdi) {
	String utfall;
	if (verdi.compareTo(fverdi) == 0) utfall = verdi + ", OK.";
	else utfall =  "FEIL, aktuell verdi: " + verdi 
		 + ", forventet verdi: " + fverdi; 
	System.out.println("== Tester " + hva + ": " + utfall );
    }

    public static void testMusebol( Bol<Mus> musebolet, String id ) {

	// Klasen Bol<T> skal ha en metode tomt() som returnerer true
	// nÃ¥r bolet ikke er bebodd av ei mus.
	if ( musebolet.tomt() ) {
	    System.out.println(" ###### " + id + " Musebolet er tomt");
	} else {
	    System.out.println(" ###### " + id + " Musebolet er bebodd:");
	    musebolet.beboer().infoOmTilstand(" IBOL ");
	}
    }


    public static void hovedprogram() {

	Katt pus = new Katt("Pus", 4560, false);
	System.out.println("============= Tester Pus:");
	testOmSomForventet("kattens navn", pus.navn(), "Pus");
	testOmSomForventet("kattens vekt", Integer.toString(pus.vekt()), "4560");
	testOmSomForventet("antall mus i magen", Integer.toString(pus.antMus()), "0");
	testOmSomForventet("om katten er syk", Boolean.toString(pus.syk()), "false");

	Katt mons = new Katt("Mons");
	System.out.println("============= Tester Mons:");
	testOmSomForventet("kattens navn", mons.navn(), "Mons");
	testOmSomForventet("kattens vekt", Integer.toString(mons.vekt()), "5000");
	testOmSomForventet("antall mus i magen", Integer.toString(mons.antMus()), "0");
	testOmSomForventet("om katten er syk", Boolean.toString(mons.syk()), "false");

	Katt[] katter = new Katt[5];
	katter[0] = mons;
	katter[1] = pus;

	Mus m1 = new Mus(37, false);
	m1.sjekktilstand("A", "musNr1", false, 37, true);
	//              (testid, navn, syk, vekt, lever) 
	Mus m2 = new Mus(38, true);
	m2.sjekktilstand("B", "musNr2", true, 38, true);

	Bol<Mus> musebolet = new Bol<Mus>();
	testMusebol(musebolet, "P");

	musebolet.settInn(new Mus(39, false));
	testMusebol(musebolet, "Q");

	/* 
	 * Oppgave 1a
	 * Tegn datastrukturen slik den ser ut her, med 1 katt-array, 1 musebol,
	 * 2 katter og 3 mus. For mus og katt trenger du bare Ã¥ ha med alle detaljer
	 * i ett av objektene
	 *
	 */


	// Tester taUt-metoden i Bol:
	
	Mus mm = musebolet.taUt();
	testMusebol(musebolet, "R");
	musebolet.settInn(mm);

	if (mm != musebolet.beboer())
	    System.out.println("S: FEIL: mm og musebol ikke samme musobjekt");

	// La jakta starte!
	// FÃ¸rst er det Pus som fÃ¥r 2 forsÃ¸k
	// Hvis Pus ikke spiser musa, setter vi den inn igjen
	// Hvis Pus har spist musa i musebolet, setter vi inn ei ny

	for (int i=0; i < 2; i++) {

	    musebolet.beboer().infoOmTilstand("B1");
	    mm = pus.gaaPaaJaktI(musebolet);

	    System.out.println("============= Tester Pus (i lÃ¸kke) :");
	    testOmSomForventet("antall mus i magen", Integer.toString(pus.antMus()),
                                new Integer(i+1).toString());
	    testOmSomForventet("kattens vekt", Integer.toString(pus.vekt()),
                                new Integer(4560+39+i*(55+i-1)).toString());
	    testOmSomForventet("om katten er syk", Boolean.toString(pus.syk()), "false");

	    if ( mm != null) musebolet.settInn(mm);	
	    else musebolet.settInn(new Mus(55+i, false));
	}

	// SÃ¥ tester vi at Pus nÃ¥ er mett, og at musa er blitt syk etter
	// Ã¥ ha blitt bitt...

	musebolet.beboer().sjekktilstand("X", "musNr5", false, 56, false );
	mm = pus.gaaPaaJaktI(musebolet);
	if ( mm != null) musebolet.settInn(mm);
	System.out.println("-----" + musebolet.beboer());
	musebolet.beboer().sjekktilstand("Y", "musNr5", true, 56, false );


	// Deretter fÃ¥r Mons og Pus 2 forsÃ¸k hver annenhver gang:

	for (int i=0; i < 2; i++) {
	    musebolet.beboer().infoOmTilstand("B2");
	    mm = mons.gaaPaaJaktI(musebolet);
	    if ( mm != null) musebolet.settInn(mm);	
	    else musebolet.settInn(new Mus(44+i, false));
	    musebolet.beboer().infoOmTilstand("B3");
	    mm = pus.gaaPaaJaktI(musebolet);
	    if ( mm != null) musebolet.settInn(mm);	
	    else musebolet.settInn(new Mus(33+i, false));
	}


	//  Vi lar sÃ¥ en ny katt, Jery spise ei syk mus:
	musebolet.beboer().sjekktilstand("Z", "musNr7", true, 45, false );

	Katt jerry = new Katt("Jerry");
	mm = jerry.gaaPaaJaktI(musebolet);
	if ( mm != null) musebolet.settInn(mm);	
	else musebolet.settInn(new Mus(77, true));

	// SÃ¥ lar vi en mett katt skade musa til den dÃ¸r:

	mm = mons.gaaPaaJaktI(musebolet);
	if ( mm != null) musebolet.settInn(mm);
	mm = mons.gaaPaaJaktI(musebolet);
	if ( mm != null) musebolet.settInn(mm);
	musebolet.beboer().infoOmTilstand("B4");



	// sjekker til slutt at Jerry ikke spiser den dÃ¸de musa i bolet
	testOmSomForventet("Jerrys antall mus i magen", Integer.toString(jerry.antMus()), "1");
	mm = jerry.gaaPaaJaktI(musebolet);
	testOmSomForventet("Jerrys antall mus i magen", Integer.toString(jerry.antMus()), "1");

	System.out.println("============= Tester Pus:");
	testOmSomForventet("kattens navn", pus.navn(), "Pus");
	testOmSomForventet("kattens vekt", Integer.toString(pus.vekt()), "4654");
	testOmSomForventet("antall mus i magen", Integer.toString(pus.antMus()), "2");
	testOmSomForventet("om katten er syk", Boolean.toString(pus.syk()), "false");

	System.out.println("============= Tester Mons:");
	testOmSomForventet("kattens navn", mons.navn(), "Mons");
	testOmSomForventet("kattens vekt", Integer.toString(mons.vekt()), "5100");
	testOmSomForventet("antall mus i magen", Integer.toString(pus.antMus()), "2");
	testOmSomForventet("om katten er syk", Boolean.toString(mons.syk()), "true");

	System.out.println("============= Tester Jerry:");
	testOmSomForventet("kattens navn", jerry.navn(), "Jerry");
	testOmSomForventet("kattens vekt", Integer.toString(jerry.vekt()), "5045");
	testOmSomForventet("antall mus i magen", Integer.toString(jerry.antMus()), "1");
	testOmSomForventet("om katten er syk", Boolean.toString(jerry.syk()), "true");



    }	
	
	
}