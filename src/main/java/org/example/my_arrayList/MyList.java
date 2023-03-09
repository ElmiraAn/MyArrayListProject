package org.example.my_arrayList;

/**
 * Here is my interface MyList for ArrayList
 *
 * @author Elmira Antipina
 *
 */
public interface MyList<E> extends Iterable<E> {
    boolean add(E e);
    void remove(int index);
    E get(int index);
    int size();
    void clear();

    void sorted();
    void add(int index, E element);

}

