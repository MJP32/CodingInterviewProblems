package Amazon;

import java.util.*;

public class Gcd {
    public static void main(String[] args) {
        System.out.println(new Gcd().generalizedGCD(5 , new int[]{2,4,6,8,10}));
    }
    public int generalizedGCD(int num, int[] arr)
    {
        // WRITE YOUR CODE HERE

        int result = arr[0];
        for(int i =1; i < arr.length;i++){
            result = gcd(arr[i],result);
        }
        return result;
    }

    private int gcd(int a, int b){
        if(a==0)
            return b;
        return gcd(b%a, a);
    }

    public static class SubsstringsOfSizeKWithKDistinctCharrs {
        public static void main(String[] args) {
            distictStrings("abcabc", 3).forEach(k-> System.out.println(k));

        }
        public static List<String> distictStrings(String str, int k ){

            List<String> result = new ArrayList<>();


            for (int i = 0; i < str.length()-k; i++) {
                if(containsDistinctChars(str.substring(i,k+i))){
                    result.add(str.substring(i,k +i));
                }

            }


            return result;
        }

        private static boolean containsDistinctChars(String substring) {

            HashSet<Character> set = new HashSet<>();

            for(char c : substring.toCharArray()){
                if(!set.contains(c))
                    set.add(c);
                else
                    return false;
            }

            return true;
        }
    }

    public static class TopKFrequentlyMentionedWords {
        public static void main(String[] args) {
            String[] keywords = {"anacell", "cetracular", "betacellular"};
            String[] reviews = {"Anacell provides the best services in the city",
                    "betacellular has awesome services",
                    "Best services provided by anacell, everyone should use anacell"};

            TopMentionedWords(2, keywords, reviews).forEach(k-> System.out.println(k));
        }

        public static List<String> TopMentionedWords(int k, String[] keywords, String[] reviews) {


            List<String> res = new ArrayList<>();
            Set<String> set = new HashSet<>(Arrays.asList(keywords));
            Map<String, Integer> map = new HashMap<>();
            for(String r : reviews) {
                String[] strs = r.split("\\W");
                Set<String> added = new HashSet<>();
                for(String s : strs) {
                    s = s.toLowerCase();
                    if(set.contains(s) && !added.contains(s)) {
                        map.put(s, map.getOrDefault(s, 0) + 1);
                        added.add(s);
                    }
                }
            }
            Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b)->a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
            maxHeap.addAll(map.entrySet());
            while(!maxHeap.isEmpty() && k-- > 0) {
                res.add(maxHeap.poll().getKey());
            }
            return res;



        }
    }
}
