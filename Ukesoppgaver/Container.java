public class Container <E> {
	private E object;

	public double put(E object) {
		this.object = object;
	}
	
	public E take() {	
		return this.object;
	}
}