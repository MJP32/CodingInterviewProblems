package FB;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatchingPairs {
    public static void main(String[] args) {
        System.out.println(new MatchingPairs().matchingPairs("abcd","adcb"));
    }

    int matchingPairs(String s, String t) {
        Set<Character> set = new HashSet<>();
        boolean hasDup = false;
        int res = 0;
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                sb1.append(s.charAt(i));
                sb2.append(t.charAt(i));
            } else {
                if (!set.add(s.charAt(i)))
                    hasDup = true;
                res++;
            }
        }
        if (sb1.length() == 0) {
            if (hasDup)
                return res;
            return res - 2;
        }
        Map<Character, Integer> mapS = new HashMap<>(), mapT = new HashMap<>();
        for (int i = 0; i < sb1.length(); i++) {
            if (mapS.containsKey(sb2.charAt(i))) {
                res++;
            }
            if (mapS.getOrDefault(sb2.charAt(i), -1) == mapT.getOrDefault(sb1.charAt(i), -2))
                return res + 1;
            mapS.put(sb1.charAt(i), i);
            mapT.put(sb2.charAt(i), i);
        }
        return res + (sb1.length() == 1 ? -1 : 0);
    }
}
