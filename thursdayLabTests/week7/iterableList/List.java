// Remove public in hackerrank submission
public interface List<T> extends Iterable<T> {
    T getFirst();

    T getLast();

    void addFirst(T item);

    void addLast(T item);

    int size();

    T removeFirst();

    T removeLast();

    T get(int index);

    T remove(int index);

}
