package AlgoExpert.heap;

import java.util.PriorityQueue;

public class ContinuousMedianHandler {
    static double median = 0;

    //to store higher numbers
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

    //to store lower numbers
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    public static void main(String[] args) {
        ContinuousMedianHandler cmd = new ContinuousMedianHandler();
        cmd.insert(5);
        System.out.println(median);
        cmd.insert(10);
        System.out.println(median);
        cmd.insert(100);
        System.out.println(median);
    }


    public void insert(int number) {


        if (minHeap.size() ==0 || number < minHeap.peek()) {
            minHeap.add(number);
        } else {
            maxHeap.add(number);
        }

//        rebalanceBalanceHeaps
        if (minHeap.size() - maxHeap.size() ==2) {
            maxHeap.add(minHeap.poll());
        }
        else if(maxHeap.size() - minHeap.size() ==2){
            minHeap.add(maxHeap.poll());
        }

//        updateMedian
        if(minHeap.size() == maxHeap.size()){
            median = (minHeap.peek() + maxHeap.peek())/2.0;
        }
        else if(minHeap.size() > maxHeap.size()){
            median = minHeap.peek();
        }
        else{
            median =maxHeap.peek();
        }
    }





    public double getMedian() {

        return median;
    }
}


