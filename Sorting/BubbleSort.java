package Github.Sorting;

public class BubbleSort {

    // Clean Code (Just Sort)
    public static int[] sort(int[] array) {

        for(var i = 1; i < array.length; i++) {
            for(var j = 0; j < (array.length - i); j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
