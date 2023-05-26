package Sort;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {
        public int getMax(int[] array){
                int max =array[0];
                for(int i = 1 ;i<array.length;i++){
                        max=Math.max(max,array[i]);
                }
                return max;
        }
        public int getMin(int[] array){
                int min =array[0];
                for(int i = 1 ;i<array.length;i++){
                        min=Math.min(min,array[i]);
                }
                return min;
        }
        public int[][] sort(int[] arr,boolean intermediate)
        {
                int max = getMax(arr);
                int min = getMin(arr);
                int range = max - min + 1;
                int count[] = new int[range];
                int output[] = new int[arr.length];
                List<int[]> intermediateArrays = new ArrayList<>();
                for (int i = 0; i < arr.length; i++) {
                        count[arr[i] - min]++;
                }

                for (int i = 1; i < count.length; i++) {
                        count[i] += count[i - 1];
                }

                for (int i = arr.length-1 ; i >=0; i--) {
                        output[count[arr[i] - min] - 1] = arr[i];
                        count[arr[i] - min]--;
                        if(intermediate)intermediateArrays.add(output.clone());
                }

                for (int i = arr.length-1; i >= 0; i--) {
                        arr[i] = output[i];
                }
                if(!intermediate)intermediateArrays.add(arr);
                return intermediateArrays.toArray(new int[intermediateArrays.size()][]);
        }
}
