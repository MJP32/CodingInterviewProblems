package FB;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Triplet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Triplet().findMaxProduct(new int []{1,2,3,4,5})));
    }
    int[] findMaxProduct(int[] arr) {
        // Write your code here

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        int[] result = new int[arr.length];

        for(int i =0 ;i < arr.length;i++){

            maxHeap.add(arr[i]);

            if(i ==0 || i ==1){
                arr[i] = -1;
            }
            else{
                int x = maxHeap.poll();
                int y = maxHeap.poll();
                int z = maxHeap.poll();

                arr[i] = x*y*z;

                maxHeap.add(x);
                maxHeap.add(y);
                maxHeap.add(z);

            }

        }

        return result;
    }
}
