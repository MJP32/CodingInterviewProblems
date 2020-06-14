package FB;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Heap().findMedian(new int[]{5, 15, 1, 3})));
    }
    int[] findMedian(int[] arr) {
        // Write your code here

        PriorityQueue<Integer> minHeap  = new PriorityQueue<>((a,b)-> a-b);
        PriorityQueue<Integer> maxHeap  = new PriorityQueue<>((a,b)-> b-a);

        int[] result = new int[arr.length];
        for(int i =0;i < arr.length;i++){

            if(minHeap.size()==0 ||arr[i] < minHeap.peek()){
                maxHeap.add(arr[i]);

            }
            else{
                minHeap.add(arr[i]);
            }

            //rebalance
            if(minHeap.size() - maxHeap.size() ==2){
                maxHeap.add(minHeap.poll());
            }
            else if(maxHeap.size()-minHeap.size() ==2){
                minHeap.add(maxHeap.poll());
            }

            if(minHeap.size() == maxHeap.size()){
                result[i] = (minHeap.peek() + maxHeap.peek())/2;
            }
            else if(minHeap.size() > maxHeap.size()){
                result[i] = minHeap.peek();
            }
            else{
                result[i] = maxHeap.peek();
            }

        }


        return result;
    }

}
