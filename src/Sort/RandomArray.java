package Sort;

import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class RandomArray {
    public int[] generateRandomArray(int size, int start, int end) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than zero.");
        }
        if (start > end) {
            throw new IllegalArgumentException("Start value cannot be greater than end value.");
        }
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(end - start + 1) + start;
        }
        return array;
    }

    public void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i != arr.length-1) System.out.print(", ");
            else System.out.println();
        }
    }

    public void writeArrayToFile(int[] array, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < array.length; i++) {
                writer.write(String.valueOf(array[i]));
                if (i < array.length - 1) {
                    writer.write(" ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reverseArray(int[] array) {

        for (int i = 0; i < array.length/2; i++) {
            int temp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = temp;
        }

    }
}
