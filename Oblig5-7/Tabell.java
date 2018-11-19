import java.util.*;
public class Tabell<T> implements AbstraktTabell<T> & Iterable<T> {
	private int index;
	private T[] array;
	
	@SuppressWarnings("unchecked")
	Tabell(int lengde) {
	    array = (T[]) new Object[lengde];
	}
	
	public boolean settInn(int i, T t) {	//returnerer true dersom objektet ble settet inn
		if(array[i] == null) {
			array[i] = t;
			return true;
		}
		return false;
	}
	
	public T finn(int i) { //Finner et objekt i et bestemt plass
		return array[i];
	}
	
	public Iterator<T> iterator() {
	 	return new TabellIterator();
	}
	
	public class TabellIterator implements Iterator<T> {
		T denne = array[index];

		public boolean hasNext() {
			if (array[index+1] != null) {
				return true;
			}
			return false;
		}
	
		public T next() {
			index++;
			return array[index];
		}
		public void remove() { 
			throw new UnsupportedOperationException();
		}
	}	
}
