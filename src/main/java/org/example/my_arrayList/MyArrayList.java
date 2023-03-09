package org.example.my_arrayList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Here is my ArrayList implemented
 * Please see the {@link MyList} interface
 *
 * @author Elmira Antipina
 */
public class MyArrayList<E> implements MyList<E>, Comparator<E> {

    private E[] values;
    private int capacity = 0;
    private final int CAPACITY = 10;
    private int size = 0;

    public MyArrayList() {
        values = (E[]) new Object[CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        values = (E[]) new Object[capacity];
    }

    /**
     * <p>Appends the specified element to the end of this list.
     * </p>
     *
     * @return the amount of health hero has after attack
     */
    @Override
    public boolean add(E e) {
        if (size >= capacity) {
            increaseCapacity();
        }
        values[size++] = (E) e;
        return true;
    }
    /**
     * <p>Method for calculating new capacity if there is not enough space in the array
     * </p>
     */
    private void increaseCapacity() {
        capacity = capacity * 3 / 2 + 1;
        E[] array = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            array[i] = values[i];
            values[i] = null;
        }
        values = array;
    }

    /**
     * <p>Inserts the specified element at the specified position in this list.
     * </p>
     */
    @Override
    public void add(int index, E element) {
        if (index < 0) {
            return;
        }
        if (size + 1 >= capacity) {
            increaseCapacity();
        }
        if (index > size) {
            index = size;
        }
        for (int i = size; i > index; i--) {
            values[i] = values[i - 1];
        }
        values[index] = (E) element;
        size++;

    }

    /**
     * <p>Removes the element at the specified position in this list.
     * </p>
     */
    @Override
    public void remove(int index) {
        try {
            Object o = null;
            if (index < size && index >= 0) {
                o = get(index);
                size--;
                if (size != index) {
                    System.arraycopy(values, index + 1, values, index, size - index);
                }
                values[size] = null;
            }
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * <p>Method for getting an element by index.
     * </p>
     *
     * @return Returns the element at the specified position in this list.
     */
    @Override
    public E get(int index) {
        if (index<size && index>=0){
            return (E) values[index];
        }
        return null;
    }

    /**
     * <p>Method for getting an element by index.
     * </p>
     *
     * @return Returns the number of elements in this list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * <p>Removes all of the elements from this list.
     * </p>
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            values[i] = null;
        }
        size=0;
    }

    /**
     * <p>Sorts this list by natural order
     * </p>
     */
    @Override
    public void sorted() {
        quickSort(values, 0, size - 1);
    }

    private void quickSort(E[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(E[] arr, int begin, int end) {
        E pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (compare(arr[j], pivot) <= 0) {
                i++;

                E swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        E swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }

    /**
     * <p>Returns an iterator over the elements in this list in proper sequence.
     * </p>
     */

    @Override
    public Iterator<E> iterator() {
        E[] array = (E[]) new Object[size];
        System.arraycopy(values, 0, array, 0, size);
        return new ArrayListIterator<E>(array);
    }

    public int compare(Object o1, Object o2) {
        return (o1 == null) ? -1 : ((o2 == null) ? 1 : ((Comparable<Object>) o1).compareTo(o2));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("List { ");
        for (int i=0; i<size-1;i++){
            sb.append(values[i]+", ");
        }
        sb.append(values[size-1]+" }");
        return sb.toString();
                /*"MyArrayList{" +
                "values=" + Arrays.toString(values.) +
                '}';*/
    }

}

