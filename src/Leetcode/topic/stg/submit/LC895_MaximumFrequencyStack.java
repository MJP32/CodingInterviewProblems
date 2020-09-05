package Leetcode.topic.stg.submit;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC895_MaximumFrequencyStack {

    PriorityQueue<Element> maxHeap;
    Map<Integer, Integer> map;
    int sequenceNumber =0;

    public LC895_MaximumFrequencyStack() {

        maxHeap = new PriorityQueue<>((e1, e2) -> (e1.frequency!=e2.frequency ?
                e2.frequency-e1.frequency:e2.sequenceNumber-e1.sequenceNumber));


        map = new HashMap<>();
    }

    public void push(int x) {
        map.put(x, map.getOrDefault(x, 0)+1);
        maxHeap.offer(new Element(x, map.get(x), sequenceNumber++));


    }

    public int pop() {

        int num = maxHeap.poll().number;

        if(map.get(num) > 0){
            map.put(num, map.get(num)-1);
        }
        else{
            map.remove(num);
        }



        return num;
    }


    class Element{
        int number;
        int frequency;
        int sequenceNumber;

        public Element(int number, int frequency, int sequenceNumber) {
            this.number = number;
            this.frequency = frequency;
            this.sequenceNumber = sequenceNumber;
        }
    }
}
