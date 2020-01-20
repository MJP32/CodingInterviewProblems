package Leetcode.topic.recursion;

import java.util.ArrayList;
import java.util.List;

public class LC17_CombinationOfAPhone {
    public static void main(String[] args) {
        LC17_CombinationOfAPhone lc17 = new LC17_CombinationOfAPhone();
        lc17.letterCombinations("23").forEach(k-> System.out.println(k));
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length()==0){
            return result;
        }


        String [] mappings = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };

         letterCombinationsRecurse(result, digits, "", 0, mappings);

        return result;
    }

    private void letterCombinationsRecurse(List<String> result, String digits, String current, int index, String[] mappings) {
        if(index == digits.length()){
            result.add(current);
            return;
        }

        String letters = mappings[digits.charAt(index) -'0'];
        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsRecurse(result,digits,current+letters.charAt(i), index+1, mappings);
        }



    }
}

