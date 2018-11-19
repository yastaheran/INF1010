import java.util.Iterator;

public class EnkelReseptListe {
	protected Node forste, temp, siste;
	protected int data;
	
	class Node {
		Node neste, forrige;
		int data;
		Resepter obj;
		
		Node(int nr) {
			this.data = nr;
		}
	}
	
	public boolean tom() {
		temp = forste;
		if(temp.data == 0) {
			return null;
		}
		return false;
	}
	
	public int finnResept(int reseptnr) throws Exception {
		if(tom()) {
			return -1;
		} else {
			temp = forste;
			while(temp.data != 0) {
				if(temp.data == reseptnr) {
					return temp.data;
				}
				temp = temp.neste;
			}
		return -1;
		}
	}
	
	private class MinReseptIterator<Resepter> implements Iterator<Resepter> {		
		Node denne = forste;
		public boolean hasNext() { 		//sjekker om den har neste
			if((denne.neste != null){
				return true;
			}
			return false;
		}
		
		public int next() { //returnerer neste objekt
			Resepter resept = denne.obj; //samme feil som i SortertEnkelListe
			denne = denne.neste;
			return resept;
		}
			
		public void remove() { //fjerner objekt
			throw new UnsupportedOperationException();
		}	
	}
	
	public MinReseptIterator<Resepter> iterator(){
		return new MinReseptIterator();
	}
}