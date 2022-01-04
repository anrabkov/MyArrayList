package by.rabkov.anderson.entity;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void quickSort() {
        QuickSort quickSort = new QuickSort();
        int[] array = {3, 64, 22, 5, 3, 3,-4};
        quickSort.quickSort(array, 2, 6);
        int[] expectedArray = {3, 64, -4 , 3, 3, 5, 22};
        assertArrayEquals(array, expectedArray);

    }

    @Test
    public void testQuickSort() {
        QuickSort quickSort = new QuickSort();
        int[] array = {3, 64, 22, 5, 3, 3,-4};
        quickSort.quickSort(array);
        int[] expectedArray = {-4 , 3, 3,  3, 5, 22, 64};
        assertArrayEquals(array, expectedArray);
    }
}