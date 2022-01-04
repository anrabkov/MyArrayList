package by.rabkov.anderson.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {

    @Test
    public void set() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(55);
        myArrayList.add(64);

        int actual = myArrayList.set(2, 30);
        int expected = 55;
        assertEquals(actual, expected);
    }

    @Test
    public void add() {   MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(55);
        myArrayList.add(64);

        boolean actual = myArrayList.add(70);

        assertTrue(actual);
    }

    @Test
    public void size() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(55);
        myArrayList.add(64);

        int actual = myArrayList.size();
        int expected = 4;
        assertEquals(actual, expected);
    }

    @Test
    public void remove() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(55);
        myArrayList.add(64);

        int actual = myArrayList.remove(2);
        int expected = 55;
        assertEquals(actual, expected);
    }

    @Test
    public void testAdd() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(55);
        myArrayList.add(64);

        boolean actualTrue = myArrayList.add(3, 385);
        boolean actualFalse = myArrayList.add(8, 785);
        assertTrue(actualTrue);
        assertFalse(actualFalse);
    }

    @Test
    public void testRemove() {
    }

    @Test()
    public void get() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Hello");
        myArrayList.add("world");
        String actual = myArrayList.get(0);
        String expected = "Hello";
        assertEquals(actual, expected);

    }


    @Test
    public void isEmpty() {
        MyArrayList<Object> myArrayList = new MyArrayList<>();
        boolean arrayIsEmpty = myArrayList.isEmpty();
        assertTrue(arrayIsEmpty);
    }

    @Test
    public void clear() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(34);
        myArrayList.add(36);
        myArrayList.add(65);
        myArrayList.add(76);

        myArrayList.clear();
        int actualArrayListSizeAfterClear = myArrayList.size();
        int expectedSizeAfterClear = 0;
        assertEquals(actualArrayListSizeAfterClear, expectedSizeAfterClear);
    }
}