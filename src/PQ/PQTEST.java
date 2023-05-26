package PQ;
import PQ.priorityQueue;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class PQTEST {
    @Test
    void test1(){
        // primary insertion test with path validation to the root.
        priorityQueue<Integer> pq = new priorityQueue<>();
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
        priorityQueue<Integer> pq = new priorityQueue<>();
        assertNull(pq.deleteMax());
        assertTrue(pq.isEmpty());
        pq.insert(10);
        assertEquals(10, pq.deleteMax());
    }

    @Test
    void test3(){
        int[] values = {14, 13, 12, 11, 10};
        // deletion loop.
        priorityQueue<Integer> pq = new priorityQueue<>();
        for (int i = 0; i < 5; i++) {
            pq.insert(values[i]);
        }

        for (int i = 0; i < 5; i++) {
            assertEquals(values[i], pq.deleteMax());
        }
    }

    @Test
    void test4(){
        Integer[] values = {5, 20, 3, 30, 9, 34, 55, 13};
        // build max heap with floyd method.
        priorityQueue<Integer> pq = new priorityQueue<>();
        pq.buildMaxHeap(values);

        Arrays.sort(values);

        for (int i = values.length - 1; i >= 0 ; i--) {
            assertEquals(values[i], pq.deleteMax());
        }
    }

    @Test
    void test5(){
        Integer[] values = {13, 5, 99, 54, 7, 777, 0, 9, 11, 89, 2, 5};
        // sort array test.
        priorityQueue<Integer> pq = new priorityQueue<>();
        for (int i = 0; i < values.length; i++) {
            pq.insert(values[i]);
        }
        Arrays.sort(values);
        Integer[] ourSortedArr = pq.getSortedArr(pq);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], ourSortedArr);
        }
    }

}
