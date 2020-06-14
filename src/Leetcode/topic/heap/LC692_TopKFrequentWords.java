package Leetcode.topic.heap;

import java.util.*;

public class LC692_TopKFrequentWords {
    public static void main(String[] args) {
        new LC692_TopKFrequentWords().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2)
                .forEach(k-> System.out.println(k));
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for(String word: words){
            count.put(word, count.getOrDefault(word,0) +1);
        }

        PriorityQueue<String> maxHeap = new PriorityQueue<>((w1,w2)-> count.get(w1).equals(count.get(w2))?
                w2.compareTo(w1): count.get(w1) - count.get(w2));



        for (String word: count.keySet()) {
            maxHeap.offer(word);
            if (maxHeap.size() >k) {
                maxHeap.poll();
            }
        }
        //System.out.println(maxHeap);

        List<String> ans = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            ans.add(maxHeap.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
