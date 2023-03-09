package org.example.my_arrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void add() {
        MyArrayList myArrayList1 = new MyArrayList();
        assertEquals(true, myArrayList1.add(1));
        assertEquals(true, myArrayList1.add(2));
        assertEquals(2, myArrayList1.size());
    }

    @Test
    void testAdd() {
        MyArrayList myArrayList1 = new MyArrayList();
        myArrayList1.add(1);
        myArrayList1.add(2);
        myArrayList1.add(3);
        myArrayList1.add(1, 100);
        assertEquals(4, myArrayList1.size());
        MyArrayList expectedList = new MyArrayList<>();
        expectedList.add(1);
        expectedList.add(100);
        expectedList.add(2);
        expectedList.add(3);
        assertEquals(expectedList.toString(), myArrayList1.toString());
    }

    @Test
    void remove() {
        MyArrayList myArrayList1 = new MyArrayList();
        myArrayList1.add(1);
        myArrayList1.add(2);
        myArrayList1.add(3);
        myArrayList1.remove(1);
        MyArrayList expectedList = new MyArrayList<>();
        expectedList.add(1);
        expectedList.add(3);
        assertEquals(expectedList.toString(), myArrayList1.toString());
    }

    @Test
    void get() {
        MyArrayList myArrayList1 = new MyArrayList();
        myArrayList1.add(1);
        myArrayList1.add(2);
        assertEquals(1, myArrayList1.get(0));
        assertEquals(2, myArrayList1.get(1));
    }

    @Test
    void size() {
        MyArrayList myArrayList1 = new MyArrayList();
        myArrayList1.add(1);
        myArrayList1.add(2);
        myArrayList1.add(3);
        MyArrayList myArrayList2 = new MyArrayList();
        assertEquals(3, myArrayList1.size());
        assertEquals(0, myArrayList2.size());
    }

    @Test
    void clear() {
        MyArrayList myArrayList1 = new MyArrayList();
        myArrayList1.add(1);
        myArrayList1.add(2);
        myArrayList1.clear();
        assertEquals(null, myArrayList1.get(0));
        assertEquals(null, myArrayList1.get(1));
    }


    @Test
    void sorted() {
        MyArrayList myArrayList1 = new MyArrayList();
        myArrayList1.add(3);
        myArrayList1.add(6);
        myArrayList1.add(1);
        myArrayList1.sorted();
        MyArrayList expectedList = new MyArrayList<>();
        expectedList.add(1);
        expectedList.add(3);
        expectedList.add(6);
        assertEquals(expectedList.toString(), myArrayList1.toString());

        MyArrayList myArrayList2 = new MyArrayList();
        myArrayList2.add("b");
        myArrayList2.add("a");
        myArrayList2.add("c");
        myArrayList2.sorted();
        MyArrayList expectedList2 = new MyArrayList<>();
        expectedList2.add("a");
        expectedList2.add("b");
        expectedList2.add("c");
        assertEquals(expectedList2.toString(), myArrayList2.toString());
    }

    @Test
    void iterator() {
        MyArrayList myArrayList1 = new MyArrayList();
        myArrayList1.add(3);
        myArrayList1.add(6);
        myArrayList1.add(1);
        assertEquals(3, myArrayList1.iterator().next());
        myArrayList1.remove(0);
        assertEquals(true, myArrayList1.iterator().hasNext());
        assertEquals(6, myArrayList1.iterator().next());
        myArrayList1.remove(0);
        assertEquals(1, myArrayList1.iterator().next());
        myArrayList1.remove(0);
        assertEquals(false, myArrayList1.iterator().hasNext());
    }

    @Test
    void testIncreaseCapacity() {
        MyArrayList<Object> objects = new MyArrayList<>();

        for (int i = 0; i < 1000; i++) {
            objects.add(0, new Object());
        }
        assertEquals(1000, objects.size());
    }
}