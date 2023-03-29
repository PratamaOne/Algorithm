package Github.Sorting;

public class MergeSort {
    public static int[] sort(int[] data) {
        mergesort(data, new int[data.length], 0, data.length - 1);
        return data;
    }
    
    // Data = Original array
    // Temp = Temporary array
    // Call This Recursive Function 
    public static void mergesort(int[] data, int[] temp, int leftStart, int rightEnd) {
        // Exit if Left == Right
        if(leftStart >= rightEnd) return;
        // 1. Divide by 2
        int middle = (leftStart + rightEnd) / 2;
        // 2. Sort Left Side
        mergesort(data, temp, leftStart, middle);
        // 3. Sort Right Side
        mergesort(data, temp, middle + 1, rightEnd);
        // 4. Merge & Sort Left Side & Right Side
        merge(data, temp, leftStart, rightEnd);
    }

    public static int[] merge(int[] data, int[] temp, int leftStart, int rightEnd) {
        int leftPointer = leftStart;
        int leftEnd = (leftPointer + rightEnd) / 2;
        int rightPointer = leftEnd + 1;
        // Index for temp
        int index = leftStart;

        while(leftPointer <= leftEnd && rightPointer <= rightEnd) {
            if(data[leftPointer] <= data[rightPointer]) {
                temp[index] = data[leftPointer];
                leftPointer++;
            } else {
                temp[index] = data[rightPointer];
                rightPointer++;
            }
            index++;
        }
        
        // System.arraycopy(5 Parameter)
        // 1. Array source
        // 2. Source position
        // 3. Array destination
        // 4. Destination position
        // 5. Length of copy
        
        // Copy the remainder of the loop from the left-hand source data to the temporary array
        System.arraycopy(data, leftPointer, temp, index, leftEnd - leftPointer + 1);
        // Copy the remainder of the loop from the right-hand source data to the temporary array
        System.arraycopy(data, rightPointer, temp, index, rightEnd - rightPointer + 1);
        // Copy temp to data
        System.arraycopy(temp, leftStart, data, leftStart, rightEnd - leftStart + 1);

        return data;
    }
}
