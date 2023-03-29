package Github.Sorting;

class InsertionSort {

    // Clean Code (Just Code)
    public static int[] sort(int[] array) {

        for(var i = 0; i < array.length - 1; i++) {
            for(var j = i; j >= 0; j--) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                } else {
                    break;
                }
            }
        }
        return array;
    }

}
