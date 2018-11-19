import java.util.Iterator;
public class SortertEnkelListe<T extends Comparable<T> & Lik> implements AbstraktSortertEnkelListe<T>{
	private Node foran, temp, bak;

	protected class Node {
		Node neste;
		T obj;
		String nokkel;
		Node(T t) {
			this.obj = t;
			this.nokkel = t.toString();
		}
	}

	public boolean settInn(T t) {	//setter inn objekt
		Node ny = new Node(t);
		if(foran == null) {			//Hvis listen er tom
			foran = ny;
			bak = ny;
			return true;
		} else if(bak.obj.compareTo(t) > 0) {  //Hvis objektet skal settes inn bakerst
			temp = bak;
			ny = temp.neste;
			bak = ny;
			return true;
		} else {					//t storre enn obj
			temp = foran;
			while(t.compareTo(denne.obj) > 0) {
				temp = temp.neste;
			}
			ny.neste = temp;
			return true;
		}
		return false;
	}
	
	public T finn(String s){
		for (T navn : this) {
			if (navn.samme(s)) {
				return navn;
			}
		}
	}
	
	/*public boolean equals(String s){ //finner et objekt ved hjelp av en String nokkel
		while(foran.hasNext()) {
			if(s.equalsIgnoreCase(foran.nokkel)) {
				return true;
			}
			foran = foran.neste;
		}
		return false;
	}*/
	
	public MinIterator<T> iterator(){
		return new MinIterator();
	}
	
	private class MinIterator<T> implements Iterator<T> {
		Node denne = foran;
		public boolean hasNext() { 		//sjekker om den har neste
			if(denne.neste != null) {
				return true;
			}
			return false;
		}
		
		public T next() { //returnerer neste objekt
			T data = denne.obj;		//får feilmelding her
			denne = denne.neste;
			return data;
		}
		
		public void remove() { //fjerner objekt
			throw new UnsupportedOperationException();
		}
	}
}