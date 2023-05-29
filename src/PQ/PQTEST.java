package PQ;
import Sort.BubbleSort;
import Sort.CountingSort;
import Sort.MergeSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
public class PQTEST {
    @Test
    void test1(){
        // primary insertion test with path validation to the root.
        maxHeap pq = new maxHeap();
        pq.insert(10);
        assertEquals(10, pq.getMax());
        pq.insert(11);
        assertEquals(11, pq.getMax());
        pq.insert(12);
        assertEquals(12, pq.getMax());
        pq.insert(14);
        assertEquals(14, pq.getMax());
    }

    @Test
    void test2(){
        // primary deletion test with delete with no elements in pq, is_empty check and 1-sized deletion case.
        maxHeap pq = new maxHeap();
        assertNull(pq.deleteMax());
        assertTrue(pq.isEmpty());
        pq.insert(10);
        assertEquals(10, pq.deleteMax());
    }

    @Test
    void test3(){
        int[] values = {14, 13, 12, 11, 10};
        // deletion loop.
        maxHeap pq = new maxHeap();
        for (int i = 0; i < 5; i++) {
            pq.insert(values[i]);
        }

        for (int i = 0; i < 5; i++) {
            assertEquals(values[i], pq.deleteMax());
        }
    }

    @Test
    void test4(){
        int[] values = {5, 20, 3, 30, 9, 34, 55, 13};
        // build max heap with floyd method.
        maxHeap pq = new maxHeap();
        pq.buildMaxHeap(values);

        Arrays.sort(values);

        for (int i = values.length - 1; i >= 0 ; i--) {
            assertEquals(values[i], pq.deleteMax());
        }
    }

    @Test
    void test5(){
        int[] values = {13, 5, 99, 54, 7, 777, 0, 9, 11, 89, 2, 5};
        // sort array test.
        maxHeap pq = new maxHeap(values.length);
        int[][] STEPS = pq.sort(values, true);
        Arrays.sort(values);
        assertArrayEquals(values, STEPS[values.length-1]);
    }

    @Test
    void test6(){
        int[] values = {13, 5, 99, 54, 7, 777, 0, 9, 11, 89, 2, 5};
        // sort array test.
        maxHeap pq = new maxHeap(values.length);
        int[][] STEPS = pq.sort(values, false);
        Arrays.sort(values);
        assertArrayEquals(values, STEPS[0]);
    }

    @Test
    void testingTotal(){
        long mst = 0, hpt = 0, ct = 0, bt = 0;
        // generate 1e3 array. >> arr
        int max = (int)1e7;
        int size = (int)1e6;
        for (int k = 0; k < 10; k++) {

            Random random = new Random();
            int[] arr1 = new int[size];
            for (int i = 0; i < size; i++) {
                arr1[i] = random.nextInt(max);
            }
            int[] arr2 = arr1.clone();
            int[] arr3 = arr1.clone();
            int[] arr4 = arr1.clone();
            long st, end;
            maxHeap pq = new maxHeap(size);
            // time
            st = System.nanoTime();
            pq.sort(arr1, false);
            end = System.nanoTime();
            hpt += (end - st)/1000;
            // end time

//            BubbleSort bs = new BubbleSort();
//            // time
//            st = System.nanoTime();
//            bs.sort(arr2, false);
//            end = System.nanoTime();
//            bt += (end - st)/1000;
//            // end time

            MergeSort ms = new MergeSort();
            // time
            st = System.nanoTime();
            ms.sort(arr3, false);
            end = System.nanoTime();
            mst += (end - st)/1000;
            // end time

            CountingSort cs = new CountingSort();
            // time
            st = System.nanoTime();
            cs.sort(arr4, false);
            end = System.nanoTime();
            ct += (end - st)/1000;
            // end time
        }
        System.out.println("heap:" + hpt/10);
        System.out.println("bs:" + bt/10);
        System.out.println("ms:" + mst/10);
        System.out.println("cs:" + ct/10);
    }

    @Test
    void testBest(){
        long start, end;
        int N = 100000;
        int[] input = bestArr(N);
        maxHeap pq = new maxHeap(input.length);
        start = System.nanoTime();
        int[][] STEPS = pq.sort(input, false);
        end = System.nanoTime();
        System.out.println("Heap sort best case: " + ((end-start)/1000) + " us" );
        Arrays.sort(input);
        assertArrayEquals(input, STEPS[0]);
    }

    @Test
    void testWorst(){
        long start, end;
        int N = 100000;
        int[] input = worstArr(N);
        maxHeap pq = new maxHeap(input.length);
        start = System.nanoTime();
        int[][] STEPS = pq.sort(input, false);
        end = System.nanoTime();
        System.out.println("Heap sort worst case: " + ((end-start)/1000) + " us" );
        Arrays.sort(input);
        assertArrayEquals(input, STEPS[0]);
    }

    @Test
    void testAvg(){
        long start, end, avg;
        int N = 100000;
        int[] input = averageArr1(N);
        maxHeap pq = new maxHeap(input.length);
        start = System.nanoTime();
        int[][] STEPS = pq.sort(input, false);
        end = System.nanoTime();
        avg = end - start;
        Arrays.sort(input);
        assertArrayEquals(input, STEPS[0]);


        int[] input2 = averageArr2(N);
        maxHeap pq2 = new maxHeap(input2.length);
        start = System.nanoTime();
        int[][] STEPS2 = pq.sort(input2, false);
        end = System.nanoTime();
        avg += (end-start);
        Arrays.sort(input2);
        assertArrayEquals(input2, STEPS2[0]);

        System.out.println("Heap sort avg case: " + ((avg/2)/1000) + " us" );

    }



    public int[] bestArr(int N) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = N - i;
        }
        return arr;
    }

    public int[] worstArr(int N) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public int[] averageArr1(int N) {
        int[] arr = new int[N];
        int half = N / 2;

        for (int i = 0; i < half; i++) {
            arr[i] = i + 1;
        }

        for (int i = half; i < N; i++) {
            arr[i] = N - i + half;
        }

        return arr;
    }

    public int[] averageArr2(int N) {
        int[] arr = new int[N];
        int half = N / 2;

        for (int i = 0; i < half; i++) {
            arr[i] = half - i;
        }

        for (int i = half; i < N; i++) {
            arr[i] = i - half + 1;
        }

        return arr;
    }

}


