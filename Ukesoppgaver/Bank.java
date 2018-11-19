/**
Lag en monitor-klasse som du kaller Bank og som inneholder et pengebeløp. Den skal
inneholde metodene ta() , gi() og saldo() .
Lag en trådklasse som først tar ut et beløp (kaller på ta() ), og så setter inn det samme beløpet (kaller gi() ). Tråden skal gå i løkke og gjøre dette mange ganger.
Hver gang en tråd er ferdig med å både ta ut penger og sette inn det samme beløpet skal den kalle metoden saldo() for å finne hvor mange penger det er i banken. Skriv ut dette beløpet.
Opprett mange tråder av trådklassen og kjør disse i parallell. Lag gjerne en konstruktør til trådklassen slik at alle trådene tar ut og setter inn forskjellige beløp.
a) Skriv først monitoren uten synchronized foran noen av metodene, og se hva som da skjer. Er saldoen alltid den samme før og etter uttak?
Legg inn et kall på metoden Thread.sleep() mellom alle (eller noen av) setningene i
metodene ta og gi. Hva skjer da? Hva skjer hvis du lar parameteren til sleep være et tilfeldig tall? (Bruk f.eks. Math.random()*1000 i parameteren til Thread.sleep )
b) Legg til synchronized foran alle metodene og se hva som skjer.
*/

class Bank {
	int belop;
	
	void gi(int belop) {
	
	}
	
	void ta(int belop) {
	
	}
	
	void saldo() {
	
	}
}