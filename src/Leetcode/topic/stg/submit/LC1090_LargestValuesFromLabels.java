package Leetcode.topic.stg.submit;


import java.util.*;

public class LC1090_LargestValuesFromLabels {
    public static void main(String[] args) {
        int[] values = new int[]{5, 4, 3, 2, 1};
        int[] labels = new int[]{1, 1, 2, 2, 3};
        int num_wanted = 3;
        int use_limit = 1;
        System.out.println(new LC1090_LargestValuesFromLabels().largestValsFromLabels(values, labels, num_wanted,
                use_limit));

    }

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {

        List<Item> items = new ArrayList<>();

        for (int i = 0; i < labels.length; i++) {
            items.add(new Item(values[i], labels[i]));
        }

        PriorityQueue<Item> maxHeap = new PriorityQueue<>((a, b) -> b.value - a.value);

        maxHeap.addAll(items);

        Map<Integer, Integer> counts = new HashMap<>();
        int value = 0;

        while (!maxHeap.isEmpty() && num_wanted > 0) {

            Item current = maxHeap.remove();
            counts.put(current.label, counts.getOrDefault(current.label,0)+1);
            if(counts.get(current.label)<= use_limit) {
                value+=current.value;
                num_wanted--;
            }
        }


        return value;
    }

    class Item {
        int value;
        int label;

        public Item(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }
}
