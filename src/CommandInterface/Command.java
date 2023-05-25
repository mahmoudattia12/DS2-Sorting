package CommandInterface;

import Sort.SortArray;

public class Command<T extends Comparable<T>>  {
    public Command(){
        String filePath = "D:/CSED/level2/2nd semester/Data Structure 2/labs/lab4/DS2-LAB4/test1.txt";
        SortArray sort = new SortArray<>(filePath);
        T[][] arr = (T[][])sort.SimpleSort(false);
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
