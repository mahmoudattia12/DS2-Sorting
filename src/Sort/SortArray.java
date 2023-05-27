package Sort;

import PQ.maxHeap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortArray {
    private int[] array;

    public SortArray(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            String[] elements = line.split(",");
            array = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                array[i] = Integer.parseInt(elements[i].trim()); // Convert string to integer
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File path or its contents are not correct.\n");
            throw new IllegalArgumentException("Invalid input value");
        } catch (Throwable t) {
            System.out.println("File path or its contents are not correct.\n");
            throw new IllegalArgumentException("Invalid input value");
        }
    }

    //bubble sort
    public int[][] SimpleSort(boolean intermediate) {
        return new BubbleSort().sort(array, intermediate);
    }

    //merge sort
    public int[][] efficientSort(boolean intermediate) {
        return new MergeSort().sort(array, intermediate);
    }
    public int[][] NonComparisonSort(boolean intermediate) {return new CountingSort().sort(array, intermediate);}

    // heap sort
    public int[][] heapSort(boolean intermediate){
        maxHeap pq = new maxHeap(array.length);
        return pq.sort(array, intermediate);
    }
}
