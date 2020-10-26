package AlgoExpert.dp;

import java.util.*;

public class LongestStringChain {

    public static void main(String[] args) {

//        String[] words = {"abde", "abc", "abd", "abcde", "ade", "ae", "labde", "abcdef", "e"};


        /*
        *      5       4        5      1    3
        *    abcdef  [abcde] [abde] [abd, ade]  2    1
        *                                      [ae] [e]
        *    labde
        * */

        String[] words = {"abde","ade","ae","abd", "e"};
        System.out.println(new LongestStringChain().longestStrChain(words));
//        System.out.println(new LongestStringChain().maxLength);
//        new LongestStringChain().longestStrChain(words).forEach(k -> System.out.println(k));
    }

    int maxLength = 0;
//    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> wordMap = new HashMap<>();
    public int longestStrChain(String[] words) {
        Set<String> set = new HashSet<>();
        for(String s : words){
            set.add(s);
        }
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());
        for(int i = words.length - 1; i >= 0; i--){
            String word = words[i];
            int count = recursiveSearch(set, word, 0);
            System.out.println(word + " " + count);
        }
        for(int i = words.length - 1; i > 0; i--) {
            String word = words[i];
            int count = recursiveSearch2(set, word, words[i - 1], 0, new HashMap<>());
            System.out.println(word + " " + count);
        }

        System.out.println();
        //map.forEach((k,v) -> System.out.println(k+" " +v));
        return maxLength;
    }

    private int recursiveSearch2(Set<String> set, String word,String child, int count,
                                                       Map<String, List<String>> map){
        if(!set.contains(word) || !set.contains(child)){
            return 0;
        }

        if(!map.containsKey(word)){
            map.put(word, new ArrayList<>());
        }
        map.get(word).add(child);
        return map.get(word).size();

//        int max =0;
//        for(int j = 0; j < word.length(); j++){
//            child = word.substring(0, j) + word.substring(j + 1);
//            max =Math.max(max,  recursiveSearch2(set, word, child, count, new HashMap<>() ));
//        }
//
//        return max;
    }

    private int recursiveSearch(Set<String> set, String word, int count){
        if(!set.contains(word)){
            return 0;
        }
        if(wordMap.containsKey(word)){
            return wordMap.get(word);
        }
        if(!wordMap.containsKey(word)){
            wordMap.put(word, 0);
        }
        maxLength = Math.max(maxLength, count + 1);

        int max =0;
        for(int j = 0; j < word.length(); j++){
            String subString = word.substring(0, j) + word.substring(j + 1);
            max =Math.max(max,  recursiveSearch(set, subString, count ));
        }
        wordMap.put(word, max +1);
        return wordMap.get(word);
    }
}
