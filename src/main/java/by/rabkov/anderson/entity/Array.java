package by.rabkov.anderson.entity;



/**
 * This is the interface with some basic method.
 * @param <T> This is a parameterized object
 */
public interface Array<T>  {
    boolean add(T t);
    int size();
    boolean remove (Object o);
    T remove(int index);
    boolean add(int index, T t);
    T get(int index);
    boolean isEmpty();
    T set(int index, T t);
    void clear();
}
