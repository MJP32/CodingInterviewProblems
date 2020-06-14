package FB;

import java.util.PriorityQueue;

public class GetTotalTime {
    public static void main(String[] args) {
        System.out.println(new GetTotalTime().getTotalTime(new int[]{4,2,1,3}));
    }

    int getTotalTime(int[] arr) {
        // Write your code here


        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        int total = 0;
        for(int i =0; i < arr.length;i++){
            maxHeap.add(arr[i]);
        }

        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            total +=x+y;

            maxHeap.add(x+y);

        }

        return total;
    }
}
