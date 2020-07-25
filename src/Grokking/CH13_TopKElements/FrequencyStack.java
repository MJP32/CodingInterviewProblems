package Grokking.CH13_TopKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencyStack {
    int sequenceNumber = 0;
    PriorityQueue<Element> maxHeap = new PriorityQueue<>((e1, e2) -> e2.frequency -e1.frequency);
    Map<Integer,Integer> frequencyMap= new HashMap<>();



    public void push(int num) {
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) +1);
        maxHeap.add(new Element(num, frequencyMap.get(num), sequenceNumber++));
    }

    public int pop() {
        int num = maxHeap.poll().number;
        if (frequencyMap.get(num)>1) {
            frequencyMap.put(num, frequencyMap.get(num)-1);
        }
        else{
            frequencyMap.remove(num);
        }

        return num;
    }

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
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
