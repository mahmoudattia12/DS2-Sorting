package PQ;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.swap;

// <<<<<<<<<<<<<<<<<<<<<<<<<<                  max heap                     >>>>>>>>>>>>>>>>>>>>>>>>>>
// <<<<<<<<<<<<<<<<<<<<<<<<<<               1-based array                   >>>>>>>>>>>>>>>>>>>>>>>>>>

public class priorityQueue<T extends Comparable<T>> {
    private ArrayList<T> key;


    public priorityQueue(){
        key = new ArrayList<T>();
        // add a dummy index.
        key.add(null);
    }

    public void insert(T insertedKey){
        key.add(insertedKey);

        // used index and its parent.
        int parentIndex = ( key.size() - 1 ) / 2;
        int usedIndex = key.size() - 1;
        int compResult;

        while( parentIndex > 0 ){

            compResult = key.get(parentIndex).compareTo( key.get(usedIndex) );
            // parent value > used value.
            if( compResult < 0 ){                                                   /////////// update
                swap(key, parentIndex, usedIndex);
            } else {
                break;
            }

            usedIndex = parentIndex;
            parentIndex /= 2;
        }
    }

    public T deleteMax(){                                                               ///////////// update

        // dummy index case only.
        if( getArrSize() == 0 ){
            return null;
        }
        T deletedKey = getMax();

        // base case: one element.
        if( getArrSize() == 1 ){
            key.remove(getArrSize());
            return deletedKey;
        }

        // normal case: more than one element.
        key.set(1, key.remove( getArrSize() ) );
        pathToLeafUpdate(1);
        return deletedKey;
    }

    private void pathToLeafUpdate(int startIndex) {
        int usedIndex = startIndex;
        T maxChildValue;                                                                //////// update
        int maxChildIndex;                                                              //////// update
        while( usedIndex * 2 <= getArrSize() ){

            maxChildValue = key.get(usedIndex*2);
            maxChildIndex = usedIndex*2;

            // children communications.
            if( usedIndex * 2 + 1 <= getArrSize() ){
                if( key.get(usedIndex * 2).compareTo(key.get(2 * usedIndex + 1)) < 0 ){ ///////// update
                    maxChildIndex++;
                    maxChildValue = key.get(usedIndex*2+1);
                }
            }

            // parent child communication.
            if( key.get(usedIndex).compareTo(maxChildValue) < 0 ){                      ////////// update
                swap(key, usedIndex, maxChildIndex);
                usedIndex = maxChildIndex;
            } else {
                break;
            }

        }
    }

    private int getArrSize() {
        return key.size() - 1;
    }

    public T getMax(){                                                          /////// update
        return (getArrSize() == 0 )? null : key.get(1);
    }

    public boolean isEmpty(){
        return getArrSize() == 0;
    }

    public void buildMaxHeap(T[] givenArr){
        key = new ArrayList<>(Collections.nCopies(givenArr.length + 1, null));
        for (int i = 1; i <= givenArr.length; i++) {
            key.set(i, givenArr[i-1]);
        }
        for (int i = givenArr.length; i >= 1; i--) {
            pathToLeafUpdate(i);
        }
    }

    public T[] getSortedArr(priorityQueue<T> pq){
        return (T[]) pq.key.toArray();
    }
}