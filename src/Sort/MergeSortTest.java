package Sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    MergeSort sorter = new MergeSort();
    @Test
    void test1() {
        int[] input = {};
        int[][] expected = {{}};
        int[][] result = sorter.sort(input, true);
        assertArrayEquals(expected, result);
    }
    @Test
    void test2() {
        //duplicate and steps
        int[] input = {5, 2, 3, 5, 1};
        int[][] expected = {{5, 2, 3, 5, 1}, {2, 5, 3, 5, 1}, {2, 3, 5, 5, 1}, {2, 3, 5, 1, 5}, {1, 2, 3, 5, 5}};
        int[][] results = sorter.sort(input, true);
        assertArrayEquals(expected, results);
    }

    @Test
    public void test3() {
        //ordered array
        int[] input = {1, 2, 3, 4, 5};
        int[][] expected = {{1, 2, 3, 4, 5}};
        int[][] result = sorter.sort(input, false);
        assertArrayEquals(expected, result);
    }
    @Test
    public void test4() {
        //reverse array
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[][] expected = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
        int[][] results = sorter.sort(input, false);
        assertArrayEquals(expected, results);
    }

    @Test
    public void test5() {
        int[] input = {-5, -2, 5, -7, 4, -3, -7, -1};
        int[][] expected = {{-7, -7, -5, -3, -2, -1, 4, 5}};
        int[][] result = sorter.sort(input, false);
        assertArrayEquals(expected, result);
    }
    @Test
    public void test6(){
        //large random array
        int[] input = new RandomArray().generateRandomArray(100, -1000, 1000);
        int[][] result = sorter.sort(input, true);
        Arrays.sort(input);
        assertArrayEquals(input, result[result.length-1]);
    }

    @Test
    public void test7(){
        //larger random array
        int[] input = new RandomArray().generateRandomArray(1000, -100000, 100000);
        int[][] result = sorter.sort(input, false);
        Arrays.sort(input);
        assertArrayEquals(input, result[0]);
    }

    @Test
    public void test8(){
        //more larger random array
        int[] input = new RandomArray().generateRandomArray(10000, -100000, 100000);
        int[][] result = sorter.sort(input, false);
        Arrays.sort(input);
        assertArrayEquals(input, result[0]);
    }

    int N = 100;

    int[] average = new RandomArray().generateRandomArray(N, 0, 10000);

    @Test
    public void average(){

        System.out.println("size : " + N);
        long start, end;
        start = System.nanoTime();
        int[][] result2 = sorter.sort(average, false);
        end = System.nanoTime();
        System.out.println("merge sort average case: " + ((end-start)/1000) + " us" );
        Arrays.sort(average);
        assertArrayEquals(average, result2[0]);
    }

    @Test
    public void best(){
        long start, end;
        Arrays.sort(average);
        start = System.nanoTime();
        int[][] result = sorter.sort(average, false);
        end = System.nanoTime();
        System.out.println("merge sort best case: " + ((end-start)/1000) + " us" );
        Arrays.sort(average);
        assertArrayEquals(average, result[0]);
    }

    @Test
    public void worst(){
        Arrays.sort(average);
        new RandomArray().reverseArray(average);

        long start, end;
        start = System.nanoTime();
        int[][] result3 = sorter.sort(average, false);
        end = System.nanoTime();
        System.out.println("merge sort worst case: " + ((end-start)/1000) + " us" );
        Arrays.sort(average);
        assertArrayEquals(average, result3[0]);
    }
}