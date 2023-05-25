package Sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortArray<T extends Comparable<T>> {
    private T[] array;

    public SortArray(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            String[] elements = line.split(",");
            array = (T[]) new Comparable[elements.length];
            for (int i = 0; i < elements.length; i++) {
                array[i] = (T) elements[i].trim();  //remove leading and trailing white spaces from a string
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("file path or its contents is not correct");
        }
    }

    //bubble sort
    public T[][] SimpleSort(boolean intermediate) {
        List<T[]> intermediateArrays = new ArrayList<>();
        if(intermediate) intermediateArrays.add(array.clone()); // Add the initial unsorted array to the list
        for (int i = array.length; i > 1; i--) {
            boolean swap = false;
            for (int j = 0; j < i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
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
        if(!intermediate) intermediateArrays.add(array.clone()); // Add the final sorted array to the list
        return intermediateArrays.toArray((T[][]) new Comparable[intermediateArrays.size()][]);
    }

    private void swap(int index, T[] arr) {
        T temp = arr[index]; arr[index] = arr[index + 1]; arr[index + 1] = temp;
    }

}
