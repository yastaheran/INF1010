class Oblig2TestA {

	/* 
    Testmetodekallene i  denne klassen kaller pÃ¥ metoder som ikke er generiske.
	Ellers er klassen identisk med Oblig2TestB
    
	Denne klassen skal du ikke trenge aa endre paa, den er bare til hjelp
	for deg og for retterne(men lever den sammen med resten).

	Konsentrer deg om en test om gangen og ikke vent til du er helt ferdig med
	aa bruke testene. Lykke til!
	*/

	public static void main(String[] args) {
		Mengde<String> tomMengde = new Mengde<>();
		testBoolean("tom() paa tom mengde returnerer true", true, tomMengde.tom());
		//      beskrivelse          forventet returverdi, det vi tester

		Mengde<String> litenMengde = new Mengde<>();
		litenMengde.leggTil("Hei");
		testBoolean("tom() paa ikke-tom mengde returnerer false", false, litenMengde.tom());

		Mengde<Integer> tallMengde = new Mengde<>();
		Integer en = 1;
		testBoolean("inneholder() paa en tom mengde skal returnere false", false, tallMengde.inneholder(en));
		testBoolean("leggTil() med et nytt element skal returnere true", true, tallMengde.leggTil(en));
		tallMengde.leggTil(2);
		Integer tre = 3;
		tallMengde.leggTil(tre);
		tallMengde.leggTil(4);
		Integer fem = 5;
		tallMengde.leggTil(fem);
		testBoolean("inneholder() skal returnere false for elementer som ikke er i mengden", false, tallMengde.inneholder(100));
		testBoolean("inneholder() skal klare aa finne eldste element", true, tallMengde.inneholder(en));
		testBoolean("inneholder() skal klare aa finne et element midt i mengden", true, tallMengde.inneholder(tre));
		testBoolean("inneholder() skal klare aa finne nyeste element", true, tallMengde.inneholder(fem));
		testBoolean("leggTil() med et eksisterende element skal returnere false", false, tallMengde.leggTil(tre));

		testString("fjernEldste() paa en tom mengde skal returnere null", null, tomMengde.fjernEldste());

		Mengde<Boolean> boolMengde = new Mengde<>();
		boolMengde.leggTil(true);
		boolMengde.fjernEldste();
		testBoolean("fjernEldste() paa en mengde med ett element skal gi en tom mengde", true, boolMengde.tom());

		Mengde<String> halloMengde = new Mengde<>();
		String hallo = "Hallo";
		halloMengde.leggTil(hallo);
		halloMengde.leggTil("Hei");
		halloMengde.leggTil("Tjolahopp!");
		testString("fjernEldste() skal returnere det forste objektet vi la inn", hallo, halloMengde.fjernEldste());

		testString("fjernNyeste() paa en tom mengde skal returnere null", null, tomMengde.fjernNyeste());

		Mengde<Boolean> boolMengde2 = new Mengde<>();
		boolMengde2.leggTil(true);
		boolMengde2.fjernNyeste();
		testBoolean("fjernNyeste() paa en mengde med ett element skal gi en tom mengde", true, boolMengde2.tom());

		Mengde<String> heiMengde = new Mengde<>();
		String hei = "Hei";
		heiMengde.leggTil("Hallo");
		heiMengde.leggTil("Tjolahopp!");
		heiMengde.leggTil(hei);
		testString("fjernNyeste() skal returnere det siste objektet vi la inn", hei, heiMengde.fjernNyeste());
	}

    public static void testBoolean(String description, boolean expected, boolean actual) {
	    if (expected == actual) {
		System.out.printf("OK - %s%n", description);
	    } else {
		System.out.printf("FEIL - %s. Skulle vaert: %s. Var: %s%n",
				  description,
				  expected,
				  actual);
	    }
	}

    public static void testString(String description, String expected, String actual) {
	if (expected == actual) {
		System.out.printf("OK - %s%n", description);
	    } else {
		System.out.printf("FEIL - %s. Skulle vaert: %s. Var: %s%n",
				  description,
				  expected,
				  actual);
	    }
	}

    public static <T> void test(String description, T expected, T actual) {
	if (expected != null && expected.equals(actual)) {
	    System.out.printf("OK - %s%n", description);
	} else if (expected == actual) {
	    System.out.printf("OK - %s%n", description);
	} else {
	    System.out.printf("FEIL - %s. Skulle vaert: %s. Var: %s%n",
			      description,
			      expected,
			      actual);
	}
    } 

}