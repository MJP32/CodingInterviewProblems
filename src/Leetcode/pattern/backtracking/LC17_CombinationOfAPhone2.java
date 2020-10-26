package Leetcode.pattern.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17_CombinationOfAPhone2 {
    public static void main(String[] args) {
        LC17_CombinationOfAPhone2 lc17 = new LC17_CombinationOfAPhone2();
        lc17.letterCombinations("23").forEach(k -> System.out.println(k));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<String, String> phone = new HashMap<>();
        phone.put("2", "abc");
        phone.put("3", "def");
        phone.put("4", "ghi");
        phone.put("5", "jkl");
        phone.put("6", "mno");
        phone.put("7", "pqrs");
        phone.put("8", "tuv");
        phone.put("9", "wxyz");

        letterCombinationsRecurse( phone, digits, "" , result);

        return result;
    }

    private void letterCombinationsRecurse(Map<String, String> phone, String digits, String curr, List<String> result) {
        if(curr.length() == digits.length()){
            result.add(curr);
            return;
        }
        String possLetters = phone.get(digits.substring(curr.length(), curr.length()+1));
        for (int i = 0; i < possLetters.length(); i++) {
            String newCurr = curr +possLetters.substring(i, i+1);
            letterCombinationsRecurse(phone, digits, newCurr,result);

        }
    }


}

