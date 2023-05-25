package Sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
    public int[][] sort(int[] array, boolean intermediate) {
        List<int[]> intermediateArrays = new ArrayList<>();
        if (intermediate) {
            intermediateArrays.add(array.clone()); // Add the initial unsorted array to the list
        }
        for (int i = array.length; i > 1; i--) {
            boolean swap = false;
            for (int j = 0; j < i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, array);
                    swap = true;
                    if (intermediate) {
                        intermediateArrays.add(array.clone()); // Add the intermediate sorted array to the list
                    }
                }
            }
            if (!swap) {
                break;
            }
        }
        if (!intermediate) {
            intermediateArrays.add(array.clone()); // Add the final sorted array to the list
        }
        return intermediateArrays.toArray(new int[intermediateArrays.size()][]);
    }
    private void swap(int index, int[] arr) {
        int temp = arr[index]; arr[index] = arr[index + 1]; arr[index + 1] = temp;
    }
}
