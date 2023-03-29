package Github.Sorting;

import java.util.Arrays;

public class HeapSort {
    // Array Temp Default Size
    private int arrayCapacity = 10;
    // Array Temp Sorted
    private int[] data = new int[arrayCapacity];
    // Size of Array Temp
    private int size = 0;

    // Index Left Node Binary Tree
    private int getLeftIndex(int parentIndex) { return (parentIndex * 2) + 1; }
    // Index Right Node Binary Tree
    private int getRightIndex(int parentIndex) { return (parentIndex * 2) + 2; }
    // Index Parent Node Binary Tree
    private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }

    // Value Array Left Node Binary Tree
    private int left(int index) {  return this.data[getLeftIndex(index)]; }
    // Value Array Right Node Binary Tree
    private int right(int index) {  return this.data[getRightIndex(index)]; }
    // Value Array Parent Node Binary Tree
    private int parent(int index) {  return this.data[getParentIndex(index)]; }

    private boolean hasLeft(int index) { return getLeftIndex(index) < size; }
    private boolean hasRight(int index) { return getRightIndex(index) < size; }
    
    public void add(int[] array) {
        // Adding new element to heap
        for(var index = 0; index < array.length; index++) {
            add(array[index]);
        }
    }

    public void add(int value) {
        // Adding new element to heap
        ensureCapacity();
        this.data[size] = value;
        size++;
        heapUp();
    }

    public int[] sort() {
        // Sorting
        for(var index = size - 1; index > 0; index--) {
            pool(index);
        }
        return this.data;
    }

    private void pool(int index) {
        swap(0, index);
        size--;
        heapDown();
    }
    
    private void ensureCapacity() {
        if(size >= arrayCapacity) {
            arrayCapacity *= 2;
            this.data = Arrays.copyOf(this.data, arrayCapacity);
        }
    }

    private void heapUp() {
        int index = size - 1;
        while(parent(index) < this.data[index]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapDown() {
        int index = 0;
        while(hasLeft(index)) {
            int biggest = getLeftIndex(index);
            if(right(index) > left(index) && hasRight(index)) {
                biggest = getRightIndex(index);
            }
            if(this.data[index] > this.data[biggest] || biggest == size) {
                break;
            } else {
                swap(index, biggest);
            }
            index = biggest;
        }
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = this.data[indexOne];
        this.data[indexOne] = this.data[indexTwo];
        this.data[indexTwo] = temp;
    }
}
