package Github.Sorting;

import java.util.Arrays;

public class SortingApp {
    public static void main(String[] args) {
        int[] numbers = {9, 7, 3, 2, 6, 4, 0, 10, -3};

        System.out.println("Original Array : " + Arrays.toString(numbers) + "\n");

        // Bubble Sort
        int[] bubble = BubbleSort.sort(numbers);
        System.out.println("Bubble Sort\t: " + Arrays.toString(bubble));

        // Insertion Sort
        int[] insertion = InsertionSort.sort(numbers);
        System.out.println("Insertion Sort\t: " + Arrays.toString(insertion));

        // Selection Sort
        int[] Selection = SelectionSort.sort(numbers);
        System.out.println("Selection Sort\t: " + Arrays.toString(Selection));

        // Tree Sort
        TreeSort tree = new TreeSort();
        int[] dataTree = tree.toSort(numbers);
        System.out.println("Tree Sort\t: " + Arrays.toString(dataTree));

        // Heap Sort
        HeapSort heap = new HeapSort();
        heap.add(numbers);
        heap.add(1);
        int[] dataHeap = heap.sort();
        System.out.println("Heap Sort\t: " + Arrays.toString(dataHeap));

        // Merge Sort
        int[] mergesort = MergeSort.sort(numbers);
        System.out.println("Merge sort\t: " + Arrays.toString(mergesort));
    }
}
