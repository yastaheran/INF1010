import java.util.Iterator;
public interface AbstraktSortertEnkelListe<T extends Comparable<T> & Lik> extends Iterable<T> {
	public boolean settInn(T t);
	public T finn(String s);
	public Iterator<T> iterator();
}
