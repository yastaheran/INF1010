import java.util.Iterator;
public interface AbstraktTabell<T> extends Iterable<T>> {
	public boolean settInn(int i, T t);
	public T finn(int i);
	public Iterator<T> iterator();
}