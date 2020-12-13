package Leetcode.topic.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1153_StringTransformsIntoAnotherString {
    public static void main(String[] args) {
//        String str1 = "aabcc";
//        String str2 = "ccdee";
//        System.out.println(new LC1153_StringTransformsIntoAnotherString().canConvert(str1, str2));
//        String str3 = "leetcode";
//        String str4 = "codeleet";
//        System.out.println(new LC1153_StringTransformsIntoAnotherString().canConvert(str3, str4));
        String str5 = "abcdefghijklmnopqrstuvwxyz";
        String str6 = "bcadefghijklmnopqrstuvwxzz";
        System.out.println(new LC1153_StringTransformsIntoAnotherString().canConvert(str5, str6));

    }

    public boolean canConvert(String str1, String str2) {
        Map<Character, List<Integer>> map1 = new HashMap<>();
        Map<Character, List<Integer>> map2 = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            map1.putIfAbsent(c1, new ArrayList<>());
            map2.putIfAbsent(c2, new ArrayList<>());

            map1.get(c1).add(i);
            map2.get(c2).add(i);
            if (!map1.get(c1).equals(map2.get(c2))) {
                return false;
            }

        }
        System.out.println(map1.values());
        System.out.println(map2.values());

        for (Map.Entry<Character, List<Integer>> entry : map1.entrySet()) {

        }

        return true;
    }
}
