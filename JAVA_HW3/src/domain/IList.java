
package domain;

public interface IList<T> {
    public void add(T item);

    public T remove();

    public int size();

    public void clear();

    public void remove( T object);

    public T[] toArray();

    public IList<T> clone();

    public T seek();

}

