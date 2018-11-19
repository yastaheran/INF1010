/* fjernNyeste()-metoden fungerer ikke som den skal */
class Mengde<E> {
	private Node start, temp, slutt;
	
	class Node {
		Node neste, forrige;
		E data;
		Node(E e) {
			this.data = e;
		}
	}
	
	public boolean tom() { //returnerer true hvis mengden er tom, 
		Node gjeldende = start; //false hvis mengden har minst ett objekt.
		if(gjeldende == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean leggTil(E e) { //legger objektet e peker paa inn i mengden hvis det ikke er i mengden fra for.
		if(tom()) { //Metoden skal returnere true dersom objektet ble satt inn,
			Node nyObj = new Node(e); //false dersom det var der fra for. Metoden legger objektet til mengden ved a opprette
			start = nyObj;//et nytt objekt av nodeklassen. Nodeobjektet som har en pekervariabel av type
			slutt = nyObj;//E som settes til aa peke paa e, lenkes inn i lenkelista.
			return true;
		} else {      
			temp = start;
			while(temp != null) {
				if(temp.data == e) {
					return false;
				}
				temp = temp.neste;
			}
			Node nyObj = new Node(e);
			slutt.neste = nyObj;
			slutt = nyObj;
			return true; 
		}
	}
	
	public E fjernEldste() { //Fjerner og returnerer det elementet som har ligget lengst 
		if(tom()) {		//i mengden (FIFO). sReturnerer nulll hvis mengden er tom
			return null;    
		} else if(start == slutt) {
			temp = start;
			start = null;
			slutt = null;
			return temp.data;
		} else {
			temp = start;
			start = start.neste;
			return temp.data;
		}
	}
	
	public E fjernNyeste() { //skal fjerne det elementet som ble lagt inn sist(LIFO)
		if(tom()) {		//og returnerer det. Den skal returnere null hvis mengden er tom
			return null;
		} else if(start == slutt) {
			temp = start;
			start = null;
			slutt = null;
			return temp.data;
		} else {
			temp = slutt;
			slutt = slutt.forrige;
			return temp.data;
		}
	}
	
	public boolean inneholder(E e) { //returnerer true dersom det objektet e peker paa er i mengden
		if(tom()) {
		 	return false;
		} else {
			if(start.data == e) {	//false dersom det ikke er med
				return true;
			}
			temp = start;
			while(temp.neste != null) {
				if(temp.data == e) {
					return true;
				}
				temp = temp.neste;
			}
		}
		return false;
	}
}