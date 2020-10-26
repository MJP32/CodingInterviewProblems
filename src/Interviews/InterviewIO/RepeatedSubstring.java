package Interviews.InterviewIO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatedSubstring {
    public static void main(String[] args) {

        /*

        Input: "abab"
        Output: 2

        Input: "aba"
        Output: -1

        Input: "abcabcabcabc"
        output: 3

        Input: "abcdeabcabcdeabc"
        output: 8


        */

        System.out.println(repeatedSubstringPatternRabinKarp("aba"));
        System.out.println(repeatedSubstringPatternRabinKarp("abcdeabcabcdeabc"));
        System.out.println(repeatedSubstringPatternKMP("aba"));
        System.out.println(repeatedSubstringPatternKMP("abcdeabcabcdeabc"));
    }
    public static boolean repeatedSubstringPatternRabinKarp(String s){
        int n = s.length();
        if (n < 2)
            return false;
        if (n == 2)
            return s.charAt(0) == s.charAt(1);

        for (int i = (int)Math.sqrt(n); i > 0; i--) {
            if (n % i == 0) {
                List<Integer> divisors = new ArrayList<>();
                divisors.add(i);
                if (i != 1) {
                    divisors.add(n / i);
                }
                for (int l : divisors) {
                    String tmp = s.substring(0, l);
                    int firstHash = tmp.hashCode();
                    int currHash = firstHash;
                    int start = l;
                    while (start != n && currHash == firstHash) {
                        tmp = s.substring(start, start + l);
                        currHash = tmp.hashCode();
                        start += l;
                    }
                    if (start == n && currHash == firstHash) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static int repeatedSubstringPatternKMP(String s){
        int n = s.length();
        int lps[] = new int[n];
        int i =1;
        int j =0;
        while (i<n) {
            if (s.charAt(i)==s.charAt(j)) {
                lps[i] = j+1;
                i++;
                j++;
            }
            else{
                if (j!=0) {
                    j = lps[j-1];
                }
                else
                    i++;
            }
        }
        System.out.println(Arrays.toString(lps));
        if (lps[n-1] ==0) {
            return -1;
        }


        int repeatedSubstringLength = n -lps[n-1];


        if(n%repeatedSubstringLength==0)
            return repeatedSubstringLength;
        else
            return -1 ;

    }

    public boolean repeatedSubstringPattern(String s){
        int len =s.length();
        for (int i = len/2; i>=1; i++) {
            if(len % i ==0){
                int numRepeats = len/i;
                String substring = s.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < numRepeats; j++) {
                    sb.append(substring);
                }
                if(sb.toString().equals(s))
                    return true;
            }
        }


        return false;
    }
}
