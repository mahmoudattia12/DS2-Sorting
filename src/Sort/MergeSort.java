package Sort;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public int[][] sort(int[] array, boolean intermediate) {
        List<int[]> intermediateArrays = new ArrayList<>();
        if(intermediate) intermediateArrays.add(array.clone()); // Add the initial unsorted array to the list
        mergeSort(array, 0, array.length - 1, intermediateArrays, intermediate);
        if(!intermediate) intermediateArrays.add(array.clone()); // Add the final sorted array to the list
        return intermediateArrays.toArray(new int[intermediateArrays.size()][]);
    }
    private void mergeSort(int[] array, int left, int right, List<int[]> intermediateArrays, boolean intermediate) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, intermediateArrays, intermediate);
            mergeSort(array, mid + 1, right, intermediateArrays, intermediate);
            merge(array, left, mid, right);
            if(intermediate) intermediateArrays.add(array.clone()); // Add the intermediate sorted array to the list
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[left + i];
        }

        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
