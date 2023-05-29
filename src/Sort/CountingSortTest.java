package Sort;
import PQ.priorityQueue;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class CountingSortTest {
    @Test
    void test1(){
        int [] array = {1,3,4,7,11,15,21,35,99};
        int [] arrayClone = array.clone();
        CountingSort sort = new CountingSort();
        assertArrayEquals(arrayClone,sort.sort(array,false)[0]);
    }
    @Test
    void test2(){
        Random r = new Random();
        int [] array =new int[100];
        for(int i = 0;i<100;i++){
            array[i]=r.nextInt(1000)-500;
        }
        int [] arrayClone = array.clone();
        CountingSort sort = new CountingSort();
        Arrays.sort(arrayClone);
        assertArrayEquals(arrayClone,sort.sort(array,false)[0]);
    }
    @Test
    void test3(){
        Random r = new Random();
        int [] array =new int[(int)1e5];
        for(int i = 0;i<(int)1e5;i++){
            array[i]=r.nextInt(100000)-50000;
        }
        int [] arrayClone = array.clone();
        CountingSort sort = new CountingSort();
        Arrays.sort(arrayClone);
        assertArrayEquals(arrayClone,sort.sort(array,false)[0]);
    }
    @Test
    void test4(){
        int [] array = {12,9,5,4,2,1,0,-1,-3,-5,-9,-10,-15};
        int [] arrayClone = array.clone();
        CountingSort sort = new CountingSort();
        int i,t,n = array.length;
        for (i = 0; i < n / 2; i++) {
            t = arrayClone[i];
            arrayClone[i] = arrayClone[n - i - 1];
            arrayClone[n - i - 1] = t;
        }
        assertArrayEquals(arrayClone,sort.sort(array,false)[0]);
    }
    @Test
    void test5(){
        int [] array = new int[0];
        CountingSort sort = new CountingSort();
        assertNull(sort.sort(array,false));
    }

    CountingSort sorter = new CountingSort();

    @Test
    void worst(){
        long start, end;
        String path = "C:/Users/Mahmoud/Downloads/count/W100000.txt";
        int[] input = readIntegersFromFile(path);
        start = System.nanoTime();
        int[][] result = sorter.sort(input, false);
        end = System.nanoTime();
        System.out.println("count sort worst case: " + ((end-start)/1000) + " us" );
        Arrays.sort(input);
        assertArrayEquals(input,result[0]);
    }
    @Test
    void average(){
        long start, end;
        String path = "C:/Users/Mahmoud/Downloads/count/A100000.txt";
        int[] input = readIntegersFromFile(path);
        start = System.nanoTime();
        int[][] result = sorter.sort(input, false);
        end = System.nanoTime();
        System.out.println("count sort worst case: " + ((end-start)/1000) + " us" );
        Arrays.sort(input);
        assertArrayEquals(input,result[0]);
    }

    @Test
    void best(){
        long start, end;
        String path = "C:/Users/Mahmoud/Downloads/count/B100000.txt";
        int[] input = readIntegersFromFile(path);
        start = System.nanoTime();
        int[][] result = sorter.sort(input, false);
        end = System.nanoTime();
        System.out.println("count sort worst case: " + ((end-start)/1000) + " us" );
        Arrays.sort(input);
        assertArrayEquals(input,result[0]);
    }

    private int[] readIntegersFromFile(String filename) {
        List<Integer> integerList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("[,\\s]+");
                for (String token : tokens) {
                    if (!token.isEmpty()) {
                        integerList.add(Integer.parseInt(token.trim()));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] integerArray = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            integerArray[i] = integerList.get(i);
        }
        return integerArray;
    }
}