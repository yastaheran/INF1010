/** Skriv programmet for det generiske grensesnittet AbstraktTabell. Det skal ikke være 
noen restriksjoner paa hva slags elementer den abstrakte tabellen skal kunne inneholde. 
AbstraktTabell beskriver en beholder og du skal kunne:
- sette et objekt inn i tabellen paa en oppgitt plass (indeks). 
- finn et objekt basert paa en indeks. - iterere over listen. */

interface AbstraktTabell<E> {
	boolean settInnObjekt(int index); //Metoden returnerer sann eller usann avhengig om operasjonen gikk bra eller ikke.
	E finnElement(int index);
}

/** Skriv programmet for det generiske grensesnittet AbstraktSortertEnkelListe. 
En slik liste skal bare kunne inneholde elementer som implementerer grensesnittene 
Comparable (med seg selv) og Lik. En slik liste skal kunne:
- sette inn et nytt element (i sortert rekkefølge, minste først).
- finne et element basert paa en nøkkel av typen String
- itereres over, slik at innholdet kan bli listet opp i sortert rekkefølge, 
	minste foerst.*/

interface Comparable {}

interface AbstraktSortertEneklListe <T> implements Comparable, Lik {
	settInnElement();
	finnElement(String noekkel);
}



/** De beholderene dere skal programmere i oblig 6 skal i oblig 7 ta vare paa alle
legemidler, resepter, leger og personer. I tillegg skal en lege ha en beholder over alle 
reseptene vedkommende har skrevet ut, og en person skal ha en beholder som inneholder alle 
personenes resepter. Legemidlene skal lagres i et objekt av klassen Tabell, reseptene 
skal lagres i et objekt av klassen EnkelReseptListe, legene skal lagres i et objekt av 
SortertEnkelListe og personene skal lagres i et objekt av klassen Tabell. Beholderen som 
inneholder en leges resepter skal være av klassen EldsteForstReseptListe, mens beholderen 
som inneholder en persons resepter skal være av klassen YngsteForstReseptListe.

Ikke ta med navn paa metoder og variable
Oppgave 6.1.b. Tegn opp datastrukturen.
Tegn alle beholderne, noen legemiddel-objekter, noen lege-objekter, noen person-objekter 
og noen resept-objekter. La det komme klart frem at en resept er med i mange beholdere. 
Tegn inn ”public” metodene (grensesnittet) i alle beholderene. Ikke ta med andre metoder. 
Naar det er flere like objekter behøver du bare tegne inn all variable i ett objekt. */

/** Generiske klasser
Skriv den generiske klassen Tabell som implementerer AbstraktTabell.
Klassen skal lagre alle elementene i en array, og arrayens lengde skal oppgis som 
parameter til konstruktøren.
Skriv den generiske klassen SortertEnkelListe som implementerer AbstraktSortertEnkelListe 
som en enveisliste. Du skal programmere denne listen selv, ikke bruke klasser fra 
Java-biblioteket. */

abstract class Tabell<T> implements AbstraktTabell<T> {
	
	Tabell(int index) {
		Array<T> elementliste = new Array<T>(index); //Elementer skal lagres i en array
	}
}
class SorterEnkelListe <T> implements AbstraktSortertEnkelListe {
}

/**b) Ikke generiske klasser
Skriv klassen EnkelReseptListe. Klassen EnkelReseptListe skal inneholde en envisliste med 
en peker til første og en peker til siste element i listen. Klassen skal kunne ta vare paa
resepter, og en resept maa kunne være med i flere objekter av denne klassen. Metodene i 
klassen skal kunne sette inn en resept og finne en resept basert paa reseptnummeret. Hvis 
resepten som det letes etter ikke finnes i listen, skal det kastes et unntak. Skriv ogsaa
en iterator over listen. Igjen skal du programmere denne listen selv, ikke bruke klasser 
fra Java-biblioteket.
Skriv subklassene EldsteForstReseptListe og YngsteForstReseptListe. Naar du itererer over 
den første klassen skal du starte med den eldste resepten (den som ble satt inn først) og 
gaa mot yngre (de som ble satt inn sist). Når du itererer i den andre klassen, skal du 
starte i den yngste enden.

Hint: Forskjellen paa de to subklassene til klassen EnkelReseptListe kan være bare 
metoden som setter inn en resept.

Utfordring: I baade SortertEnkelListe og EnkelReseptListe skal du skrive en iterator. 
Kan du klare aa bruke den samme iteratoren i begge klassene? 
Da maa de to listene kanskje ha de samme nodene?

Oppgave 6.4. Lag enkle enhetstester for alle beholderene.
Skriv et lite testprogram for hver av klassene Tabell, SortertEnkelListe, 
EldsteForstReseptListe og YngsteForstReseptListe. Prøv aa lage programmene slik at baade 
vanlige tilfeller og noen spesialtilfeller blir testet.
Innleveringen på denne oppgaven er tegningene fra oppgave 6.1, alle grensesnittene 
og klassene, og de fire kjørbare programmene fra oppgave 6.4*/