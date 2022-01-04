package by.rabkov.anderson.entity;

import java.util.Random;

/**
 * This is quickSort class
 */
public class QuickSort {

    /**
     * This method sorts all elements of the passed array.
     * @param array This is array that will be sorted.
     */
    static void quickSort(int[] array) {
        quickSort(array,0, array.length-1);
    }

    /**
     * This method sorts elements of passed array from lowIndex till highIndex.
     * @param array This is array that will be sorted.
     * @param lowIndex TThis index shows the ordinal element in the array, starting from
     *                 which the array will be sorted.
     * @param highIndex This index shows the ordinal element in the array, ending till
     *                  which the array will be sorted.
     */
    static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        Random random = new Random();
        int pivotIndex = random.nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);
        int leftPointer = lowIndex;
        int rightPointer = highIndex;


        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);
        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highIndex);


    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
