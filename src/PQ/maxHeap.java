package PQ;

// <<<<<<<<<<<<<<<<<<<<<<<<<<                  max heap                     >>>>>>>>>>>>>>>>>>>>>>>>>>
// <<<<<<<<<<<<<<<<<<<<<<<<<<               0-based array                   >>>>>>>>>>>>>>>>>>>>>>>>>>

public class maxHeap {
    private Integer[] usedArr;
    private int keySize, maxSize;

    public maxHeap(){
        this((int)1e5);
    }
    public maxHeap(int maxSize){
        keySize = 0;
        this.maxSize = maxSize;
        usedArr = new Integer[maxSize];
    }



    public void insert(Integer insertedKey){
        usedArr[keySize] = insertedKey;
        keySize++;

        // used index and its parent.
        int usedIndex = getArrSize() - 1;
        int parentIndex = ( usedIndex - 1 ) / 2;

        while( parentIndex >= 0 ){

            if( usedArr[parentIndex] < usedArr[usedIndex] ){/////////// update
                swap(parentIndex, usedIndex);
            } else {
                break;
            }

            usedIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
    }

    public Integer deleteMax(){///////////// update

        // dummy index case only.
        if( getArrSize() == 0 ){
            return null;
        }
        Integer deletedKey = getMax();
        swap(0, getArrSize() - 1);
        keySize--;
        heapify(0);
        return deletedKey;

    }

    private void heapify(int startIndex) {
        int usedIndex = startIndex;
        Integer maxChildValue;//////// update
        int maxChildIndex;//////// update
        while( leftChild(usedIndex) < getArrSize() ){

            maxChildIndex = leftChild(usedIndex);
            maxChildValue = usedArr[ leftChild(usedIndex) ];

            // children communications.
            if( rightChild(usedIndex) < getArrSize() ){

                if( usedArr[ leftChild(usedIndex) ] < usedArr[rightChild(usedIndex)] ){ ///////// update
                    maxChildIndex = rightChild(usedIndex);
                    maxChildValue = usedArr[rightChild(usedIndex)];
                }
            }

            // parent child communication.
            if( usedArr[usedIndex] < maxChildValue ){////////// update
                swap(usedIndex, maxChildIndex);
                usedIndex = maxChildIndex;
            } else {
                break;
            }

        }
    }

    private int leftChild(int index ){ return index*2+1; }
    private int rightChild(int index ){ return index*2+2; }

    private int getArrSize() {
        return keySize;
    }

    public Integer getMax(){                                                          /////// update
        return (getArrSize() == 0 )? null : usedArr[0];
    }

    public boolean isEmpty(){
        return getArrSize() == 0;
    }

    public void buildMaxHeap(int[] givenArr){
        keySize = givenArr.length;

        for (int i = 0; i < givenArr.length; i++) {
            usedArr[i] = givenArr[i];
        }
        for (int i = givenArr.length - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    private void swap(int i, int j){
        Integer additional = usedArr[i];
        usedArr[i] = usedArr[j];
        usedArr[j] = additional;
    }

    public int[][] sort(int[] givenArr, boolean needSteps){
        buildMaxHeap(givenArr);
        int[][] steps;
        if( needSteps )steps = new int[givenArr.length][];
        else  steps = new int[1][];

        for (int i = 0; i < givenArr.length; i++) {
//            System.out.println();
            deleteMax();
            if( needSteps )steps[i] = getState(givenArr.length);
        }
        if( !needSteps ) {
            steps[0] = getState(givenArr.length);
        }
        return steps;
    }

    private int[] getState(int size){
        int[] state = new int[size];
        for (int i = 0; i < size; i++) {
            state[i] = usedArr[i];
//            System.out.print(usedArr[i] + " ");
        }
//        System.out.println();
        return state;
    }


}