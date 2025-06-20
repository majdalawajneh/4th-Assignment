import java.util.*;

/**
 * The SortExample class demonstrates two sorting algorithms:
 * Quick Sort and Merge Sort.
 */
public class SortExample {

    /**
     * Main method to demonstrate sorting examples.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Unsorted arrays
        Integer[] quickSortArray = { 12, 13, 24, 10, 3, 6, 90, 70 };
        int[] mergeSortArray = { 2, 6, 3, 5, 1 };

        // Sort using Quick Sort
        quickSort(quickSortArray, 0, quickSortArray.length - 1);
        System.out.println("Quick Sort Result: " + Arrays.toString(quickSortArray));

        // Sort using Merge Sort
        mergeSort(mergeSortArray, mergeSortArray.length);
        System.out.println("Merge Sort Result: " + Arrays.toString(mergeSortArray));
    }

    /**
     * Sorts an array using Quick Sort algorithm.
     *
     * @param arr the array to sort
     * @param low the starting index
     * @param high the ending index
     */
    public static void quickSort(Integer[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || low >= high) {
            return;
        }

        // Choose pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // Partition the array around the pivot
        int i = low, j = high;

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // Recursively sort sub-arrays
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    /**
     * Swaps two elements in an array.
     *
     * @param array the array containing elements to swap
     * @param x the index of the first element
     * @param y the index of the second element
     */
    public static void swap(Integer[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * Sorts an array using Merge Sort algorithm.
     *
     * @param array the array to sort
     * @param length the size of the array
     */
    public static void mergeSort(int[] array, int length) {
        if (length < 2) {
            return;
        }

        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        // Copy data to temp arrays
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, length - mid);

        mergeSort(left, mid);
        mergeSort(right, length - mid);

        merge(array, left, right, mid, length - mid);
    }

    /**
     * Merges two sorted arrays into a single sorted array.
     *
     * @param array the original array to store merged result
     * @param left the left sub-array
     * @param right the right sub-array
     * @param leftSize the size of the left sub-array
     * @param rightSize the size of the right sub-array
     */
    public static void merge(int[] array, int[] left, int[] right, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;

        // Merge arrays
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy remaining elements
        while (i < leftSize) {
            array[k++] = left[i++];
        }

        while (j < rightSize) {
            array[k++] = right[j++];
        }
    }

    /**
     * Checks if an integer array is sorted in ascending order.
     *
     * @param array the array to check
     * @return true if sorted, false otherwise
     */
    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
