package org.example.my_arrayList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
/**
 * Here is my ArrayList implemented
 *
 * Please see the {@link MyList} interface
 * @author Elmira Antipina
 *
 */
public class MyArrayList<E> implements MyList<E>, Comparator<E> {

    private E[] values;

    public MyArrayList() {
        values = (E[]) new Object[0];
    }
    /**
     * <p>Appends the specified element to the end of this list.
     * </p>
     * @return the amount of health hero has after attack
     */
    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
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
        if (index > values.length) {
            index = values.length;
        }
        E[] temp = values;
        values = (E[]) new Object[temp.length + 1];
        System.arraycopy(temp, 0, values, 0, temp.length);
        for (int i = temp.length; i >= index; i--) {
            values[i] = values[i - 1];
        }
        values[index] = (E) element;

    }
    /**
     * <p>Removes the element at the specified position in this list.
     * </p>
     */
    @Override
    public void remove(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            System.arraycopy(temp, index + 1, values, index, values.length - index);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * <p>Method for getting an element by index.
     * </p>
     * @return Returns the element at the specified position in this list.
     */
    @Override
    public E get(int index) {
        return values[index];
    }

    /**
     * <p>Method for getting an element by index.
     * </p>
     * @return Returns the number of elements in this list.
     */
    @Override
    public int size() {
        return values.length;
    }

    /**
     * <p>Removes all of the elements from this list.
     * </p>
     */
    @Override
    public void clear() {
        for (int i = 0; i < values.length; i++) {
            values[i] = null;
        }
    }
    /**
     * <p>Sorts this list by natural order
     * </p>
     */
    @Override
    public void sorted() {
        quickSort(values, 0, values.length - 1);
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
        return new ArrayListIterator<E>(values);
    }

    public int compare(Object o1, Object o2) {
        return (o1 == null) ? -1 : ((o2 == null) ? 1 : ((Comparable<Object>) o1).compareTo(o2));
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "values=" + Arrays.toString(values) +
                '}';
    }

}

