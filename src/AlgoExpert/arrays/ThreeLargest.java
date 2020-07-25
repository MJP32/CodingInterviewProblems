package AlgoExpert.arrays;

import java.util.PriorityQueue;

public class ThreeLargest {
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int[] result = new int[3];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b-a));

        for(int i : array){
            maxHeap.add(i);


        }
        int k =3;


        result[2] = maxHeap.poll();
        result[1] = maxHeap.poll();
        result[0] = maxHeap.poll();

        //System.out.println()
        return result;

    }
}
