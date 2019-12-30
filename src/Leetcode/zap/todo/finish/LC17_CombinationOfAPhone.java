package Leetcode.zap.todo.finish;

import java.util.ArrayList;
import java.util.List;

public class LC17_CombinationOfAPhone {
    public static void main(String[] args) {
        LC17_CombinationOfAPhone lc17 = new LC17_CombinationOfAPhone();
        lc17.letterCombinations("23");
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

        //letterCombinationsRecurse()

        return result;
    }
}

