package Github.Sorting;

class SelectionSort {

    // Clean Code (Just Code)
    public static int[] sort(int[] numbers) {
        
        int len = numbers.length;        
        for(var i = 0; i < (len - 1); i++) {
            int small = i;
            // Selection loop
            for(var j = (i + 1); j < len; j++) {
                if(numbers[j] < numbers[small]) small = j;
            }
            // Swap after selection
            if(numbers[i] > numbers[small]) {
                int temp = numbers[small];
                numbers[small] = numbers[i];
                numbers[i] = temp;
            }
        }
        return numbers;
    }

}
