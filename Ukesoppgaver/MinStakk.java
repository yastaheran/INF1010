public class MinStakk {
	Node start, slutt;

	class Node {
		Square data;
		Node neste, forrige;
		Node(Square data) {
			this.data = data;
		}

		boolean hasNext() {
			Node denne = start;
			if(denne.neste != null) {
				return true;
			} else {
				return false;
			}
		}
	}

	void push() {
		Square s = new Square;
		Node n = new Node(s);
		if(isEmpty()) {
			start = n;
		} else if(!start.hasNext()){
			n.neste = n;
		}
	}
	
	void pop(){
	}

	boolean isEmpty(){
		Node n = start;
		if(n = null) {
			return true;
		} else{
			return false;
		}
	}
}

/**
Vi skal implementere en enkel stakk som skal ha tre metoder:
push() - et element dyttes på toppen av stakken.
pop() - et element tas av toppen av stakken og returneres.
Hvis stakken er tom skal den returnere null.
b) Skriv klassen MinStack med metodene push(), pop() og is Empty().
 push() skal legge en ny node med en
square på "toppen" av listen, altså før forrige objekt som ble lagt til.
pop() skal ta av det øverste objektet og returnere dette.
*/
