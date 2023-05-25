package Sort;
import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> {

    public T[][] sort(T[] array, boolean intermediate) {
        List<T[]> intermediateArrays = new ArrayList<>();
        intermediateArrays.add(array.clone()); // Add the initial unsorted array to the list

        mergeSort(array, intermediate, intermediateArrays);

        intermediateArrays.add(array.clone()); // Add the final sorted array to the list

        return intermediateArrays.toArray((T[][]) new Comparable[intermediateArrays.size()][]);
    }

    private void mergeSort(T[] array, boolean intermediate, List<T[]> intermediateArrays) {
        if (array.length <= 1) {
            return;
        }

        T[] leftArray = (T[]) new Comparable[array.length / 2];
        T[] rightArray = (T[]) new Comparable[array.length - array.length / 2];

        for (int i = 0; i < array.length / 2; i++) {
            leftArray[i] = array[i];
        }

        for (int i = array.length / 2; i < array.length; i++) {
            rightArray[i - array.length / 2] = array[i];
        }

        mergeSort(leftArray, intermediate, intermediateArrays);
        mergeSort(rightArray, intermediate, intermediateArrays);
        merge(leftArray, rightArray, array);

        if (intermediate) {
            intermediateArrays.add(array.clone()); // Add the intermediate sorted array to the list
        }
    }

    private void merge(T[] left, T[] right, T[] array) {
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].compareTo(right[rightIndex]) < 0) { // Fix the comparison here
                array[mergedIndex++] = left[leftIndex++];
            } else {
                array[mergedIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            array[mergedIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            array[mergedIndex++] = right[rightIndex++];
        }
    }

}
