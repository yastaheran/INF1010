/** Dette programmet, Program, skal:
Lese alle data fra fil.
Skrive alle data til fil.
Skrive ut alle personer, alle leger (sortert paa navn), aller legemidler og alle resepter. 
Opprette og legge inne et nytt legemiddel.
Opprette og legge inn en ny lege.
Opprette og legge inn en ny person.
Opprette og legge inn en ny resept.
Hente legemiddelet paa en resept. */
import java.util.Scanner;

public class Program {
	public class main(String [] args) {
		LesFil filen = new LesFil("fil.txt");
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("Les fil:");
		filen.lesFil();
		System.out.println("Skriv til fil"); //Skal skrive inn i filen returnerer true hvis suksess, ikke ferdig
		filen.skrivFil();
		System.out.println("Alle personer:"); //metoden er ikke lagd
		filen.hentPersoner();
		System.out.println("Alle leger:"); //sortert etter navn, metoden er ikke lagd
		filen.hentLeger();
		System.out.println("Alle legemidler:"); //metoden er ikke lagd
		filen.hentLegemidler();
		System.out.println("Alle resepter:"); //metoden er ikke lagd
		filen.hentResepter();
		System.out.println("Oppretter nytt legemiddel:"); //metoden er ikke lagd
		filen.nyLegemidel();
		System.out.println("Oppretter ny lege:"); //metoden er ikke lagd
		filen.nyLege();
		System.out.println("Oppretter ny person:"); //metoden er ikke lagd
		filen.nyPerson();
		System.out.println("Oppretter ny resept:"); //metoden er ikke lagd
		filen.nyResept();
		System.out.println("Velg reseptnr:"); //metoden er ikke lagd
		String reseptnr = sc.nextLine();
		Resepter resept = new Resepter(parseInteger(reseptnr));
		
	}
}
/*

Haandtere forskjellige ordre for aa skrive ut statistikk.
Filformatet er beskrevet paa slutten av oppgaven. En større fil kommer her. 
Rekkefølgen paa reseptene behøver ikke opprettholdes ved skriving/lesing til/fra fil.
Naar et legemiddel hentes er dette basert paa fødselsnummeret eller det unike nummeret i 
programmet til personen som har resepten og reseptens nummer. Siden vi i denne oppgaven 
ikke har noe data om mengden av legemiddel paa lager, betyr dette at vi bare teller ned 
antallet ganger resepten kan brukes (reit). Om antallet blir null, betyr dette at 
resepten er ugyldig. Prisen som skal betales skrives ut. Skriv også ut legens navn, 
personens navn og all dataene du har om legemiddelet på resepten (inkludert hvor mye 
virkestoff det inneholder totalt og antall piller i en eske eller hvor stort volum det 
er i en flaske mikstur). Programmet skal kunne skrive ut forskjellige former for 
statistikk. Bruk for-each-løkker for aa gaa gjennom beholderne:
- Skriv ut hvor mange vanedannende resepter det finnes totalt 
og hvor mange som er skrevet ut til personer bosatt i Oslo.
- For en gitt person, skriv ut alle dens blå resepter, yngste resept først. Personen 
identifiseres enten ved sitt fødselsnummer eller ved dets unike nummer i programmet.
- For en lege med et gitt navn, skriv ut alle legens resepter paa mikstur-preparater, 
eldste resept først. Skriv ogsaa ut den samlede mengde virkestoff for alle resepter legen 
har skrevet ut, og hvor mye av dette som er i pilleform og hvor mye er mikstur.

- For aa finne medisinsk misbruk av narkotika gjør to ting:
	- List opp navnene paa alle leger (i alfabetisk rekkefølge) som har skrevet ut minst 
	en (gyldig eller ikke) resept paa narkotiske legemidler, og antallet slike resepter 
	per lege. 
	- List opp navnene paa alle personer som har minst en gyldig resept paa narkotiske
	legemidler, og for disse, skriv ut antallet per person.
Skriv en kommentar i programmet om hva dere bør gjøre hvis disse siste to spørringene 
(om narkotiske resepter) utføres veldig ofte.
*/