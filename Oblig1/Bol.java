public class Bol<T> {
	private T beboer;
	
	public T beboer() {
		return beboer;
	}
	
	public void settInn(T den) {
		beboer = den;
		System.out.println("-----" + beboer);
	}
	
	public boolean tomt() {
		if (beboer == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public T taUt() {	
		T beboeren = beboer;
		beboer = null;
		return beboeren;
	}
}