package Amazon.assessment;

import java.util.*;

public class SubstringSizeKwithKDistinctChars {
    public static void main(String[] args) {
        new SubstringSizeKwithKDistinctChars().count("awaglk", 4).forEach(k-> System.out.println(k));
        new SubstringSizeKwithKDistinctChars().count("democracy", 5).forEach(k-> System.out.println(k));
        new SubstringSizeKwithKDistinctChars().count("wawaglknagagwunagkwkwagl", 4).forEach(k-> System.out.println
                (k));
    }
    public List<String> count(String s , int k ){
        Set<String> result = new HashSet<>();

        Map<Character, Integer> map = new HashMap<>();
        int start = -k+1;
        for(int end = 0;end < s.length();end++ ) {
            map.put(s.charAt(end),map.getOrDefault(s.charAt(end), 0)+1);

            if(map.size()==k-1 && end - start+1 == k&& start >=0){
                result.add(s.substring(start, end+1));
            }

            if(start >=0) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                if (map.get(s.charAt(start)) == 0) {
                    map.remove(s.charAt(start));
                }
            }
            start++;

        }

        return new ArrayList<>(result);
    }
}
