package AlgoExpert.assessment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountContainedPermutations {
    public static void main(String[] args) {

        String bigString = "cbabcacabca";
        String smallString = "abc";

        System.out.println(countContainedPermutations(bigString, smallString));
    }
    public static int countContainedPermutations(String bigString, String smallString) {

        List<String> permutations = new ArrayList<>();


        int len = smallString.length();

        for (int i = 0; i < bigString.length() - len+1; i++) {
            String str = bigString.substring(i, i +len);

            if (isPermutation(str, smallString)) {
                permutations.add(str);
            }
        }

        return permutations.size();
    }

    private static boolean isPermutation(String str, String smallString) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (Character c : str.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) +1);
        }

        for (Character c : smallString.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) +1);
        }

        return map1.equals(map2);
    }

}
