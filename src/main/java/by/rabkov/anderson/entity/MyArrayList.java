package by.rabkov.anderson.entity;

/**
 * This is a parameterized class with some basic methods of ArrayList
 * @Author Alexey Rabkov
 *
 *
 * This class is a dynamic array.
 * @param <T> This is a parameterized type
 *
 */
public class MyArrayList<T> implements Array<T> {

    private final static int INITIAL_CAPACITY = 10;
    private int size = 0;
    private T[] initialArray;
    private static final Object[] EMPTY_ARRAY = {};


    public MyArrayList() {
        initialArray = (T[]) new Object[INITIAL_CAPACITY];
    }


    public MyArrayList(int capacity)  {
        if (capacity > 0){
            initialArray = (T[]) new Object[capacity];
        }else if(capacity == 0) {
            initialArray = (T[]) EMPTY_ARRAY;
        }else {
            throw new IndexOutOfBoundsException("Size of array can't be below zero");
        }
    }

    /**
     * This method inserts T class object in place of an existing array element at the passed index.
     *
     * @param index shows which element of the array needs to be changed
     * @param t this is object T class
     * @return the replaced array element
     *
     * */
    @Override
    public T set(int index, T t) {
        T temp = initialArray[index];
        initialArray[index] = t;
        return temp;
    }

    /**
     *
     * This method adds object T class after the last array element.
     * @param t This is object T class
     * @return boolean variable: if passed object was added to an existing array successfully the method returns true,
     * in other case the method returns false.
     */
    @Override
    public boolean add(T t) {
        size++;
        if (initialArray.length < size){
            initialArray = increaseCapacity(initialArray);
        }
        initialArray[size-1] = t;
        return true;
    }


    /**
     * This method shows the number elements of array
     * @return number elements of array
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This method removes array element at the specified index
     * @param index shows which element of array need to remove
     * @return value of the deleted array element
     */
    @Override
    public T remove(int index) {
        T value = initialArray[index];
        initialArray[index] = null;
        System.arraycopy(initialArray, index + 1, initialArray, index, size - index);
        initialArray[--size] = null;
        return value;
    }

    /**
     * This method adds T class object to an existing array at the passed index,
     * all subsequent elements of the existing array are moved to the right one position from the passed index
     * @param index indicates the  position of the existing array to which object t of T class should to be added.
     * @param t This is object T class
     * @return This method returns a boolean variable true if the object t of class T was added to an existing
     * array by the passed index, otherwise it returns false.
     */
    @Override
    public boolean add(int index, T t)  {
        if (index <= size && index >= 0) {
            size++;
            if (initialArray.length < size) {
                initialArray = increaseCapacity(initialArray);
            }
            System.arraycopy(initialArray, index, initialArray, index + 1, size - index);
            initialArray[index] = t;
            return true;
        } else {
            return false;
        }
    }


    /**
     * This method removes the first element of the existing array that is equal to the passed object
     * @param o This is object of Object class.
     * @return This method returns a boolean variable true if passed object o was deleted from the array,
     * in otherwise it returns false.
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (initialArray[i] == null) {
                    System.arraycopy(initialArray, i + 1, initialArray, i, size - i);
                    initialArray[--size] = null;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (initialArray[i].equals(o)) {
                    System.arraycopy(initialArray, i + 1, initialArray, i, size - i);
                    initialArray[--size] = null;
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * This method gets array element by the passed index.
     * @param index
     * @return the element of the array by the passed index.
     * @throws IndexOutOfBoundsException Throws exception when the passed index out of bounds for length
     */
    @Override
    public T get(int index)  {
        if (index >= 0 && index < size) {
            return initialArray[index];
        } else throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
    }

    /**
     * This method shows existing array is empty or not empty.
     * @return This method returns boolean variable true if length of the existing array is zero,
     * otherwise it returns false.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * This method increased the capacity of the existing array
     * @param oldArray This is array which capacity need to increase
     * @return This method returns an array with increased capacity
     */
    private T[] increaseCapacity(T[] oldArray) {
        int newCapacity;
        newCapacity = oldArray.length*3/2 + 1;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
       return newArray;
    }

    /**
     * This method removes all elements of an existing array and reduces the array capacity to zero.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            initialArray[i] = null;
        }
        size = 0;
    }


}
