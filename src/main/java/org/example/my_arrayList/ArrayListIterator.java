package org.example.my_arrayList;


import java.util.Iterator;
/**
 * Here is the implemented class for iterating MyArrayList
 *
 * @author Elmira Antipina
 *
 */
public class ArrayListIterator<E> implements Iterator<E> {
    private int index = 0;
    private E[] values;

    ArrayListIterator(E[] values) {
        this.values = values;
    }
    /**
     * <p> With the hasNext() method, you can find out if there is a next element and if the end of the collection has been reached.
     * <br>And if there are more elements, then hasNext() will return true.
     * <br>The hasNext() method should be called before the next() method,
     * <br>because when the end of the collection is reached, the next() method throws a NoSuchElementException
     * </p>
     * @return true or false
     */
    @Override
    public boolean hasNext() {
        return index < values.length;
    }
    /**
     * <p>Get the next element
     * </p>
     * @return the amount of health hero has after attack
     */
    @Override
    public E next() {
        return values[index++];
    }
}



