package Amazon;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSumKOperations {
    public static void main(String[] args) {

        System.out.println(minSum(Arrays.asList(10,20,7), 4));
        System.out.println(minSum(Arrays.asList(2), 1));
        System.out.println(minSum(Arrays.asList(2, 3), 1));

    }
    public static int minSum(List<Integer> num, int k ){

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
        for (int i : num) {
//            System.out.println(i);
            maxHeap.add(i);
        }

        while(k> 0 ){
            int max = maxHeap.poll();
            maxHeap.add((int) Math.round(Math.ceil(max/2.0)));
            k--;
        }
        int sum =0;
        for (int i : maxHeap){
//            System.out.println(i);
            sum +=i;
        }

        return sum;
    }
}
