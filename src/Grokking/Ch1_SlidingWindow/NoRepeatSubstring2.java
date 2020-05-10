
package Grokking.Ch1_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring2 {
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring2.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring2.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring2.findLength("abccde"));
    }
    public static int findLength(String str) {


        int windowStart =0;
        int maxLength =0;
        Map<Character,Integer> map = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {


            char leftChar = str.charAt(windowEnd);

            if(map.containsKey(leftChar)){
                windowStart = Math.max(windowStart, map.get(leftChar) +1);
            }


            map.put(leftChar, windowEnd);
            maxLength =Math.max(maxLength, windowEnd-windowStart+1);



        }





        return maxLength;



    }
}
